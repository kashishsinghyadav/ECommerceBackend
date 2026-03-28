package org.kashish.ecommerce.service;

import org.kashish.ecommerce.model.Order;
import org.kashish.ecommerce.model.OrderItem;
import org.kashish.ecommerce.model.Product;
import org.kashish.ecommerce.model.dto.OrderItemRequest;
import org.kashish.ecommerce.model.dto.OrderItemResponse;
import org.kashish.ecommerce.model.dto.OrderRequest;
import org.kashish.ecommerce.model.dto.OrderResponse;
import org.kashish.ecommerce.repo.orderRepo;
import org.kashish.ecommerce.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class orderService {

    @Autowired
    private orderRepo orderrepo;
    @Autowired
    private productRepo productrepo;

    public OrderResponse placedOrder(OrderRequest orderrequest) {

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString().substring(0,8).toLowerCase());
        order.setCustomerName(orderrequest.customerName());
        order.setEmail(orderrequest.email());
        order.setStatus("Placed");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderitems = new ArrayList<>();
        for(OrderItemRequest itemreq: orderrequest.items()){
            Product product = productrepo.findById(itemreq.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            product.setStockQuantity(product.getStockQuantity() - itemreq.quantity());
            productrepo.save(product);
            OrderItem orderitem = OrderItem.builder().product(product).quantity(itemreq.quantity()).
                    totalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemreq.quantity()))).
                    order(order).build();


            orderitems.add(orderitem);

        }


        order.setOrderItems(orderitems);
        Order saveorder =  orderrepo.save(order);

        List<OrderItemResponse> orderitemresponse = new ArrayList<>();
        for(OrderItem orderitem: saveorder.getOrderItems()){
            OrderItemResponse orderItemResponse = new OrderItemResponse(
                    orderitem.getProduct().getName(),
                    orderitem.getQuantity(),orderitem.getTotalPrice());
            orderitemresponse.add(orderItemResponse);

        }

        return new OrderResponse(order.getOrderId(), order.getCustomerName(), order.getCustomerName(), order.getStatus(),order.getOrderDate(),orderitemresponse);
    }

    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}
