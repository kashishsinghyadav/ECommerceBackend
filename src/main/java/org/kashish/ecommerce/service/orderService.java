package org.kashish.ecommerce.service;

import org.kashish.ecommerce.model.dto.OrderRequest;
import org.kashish.ecommerce.model.dto.OrderResponse;
import org.kashish.ecommerce.repo.orderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {

    @Autowired
    private orderRepo orderrepo;

    public OrderResponse placedOrder(OrderRequest orderRequest) {
        return null;
    }

    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}
