package org.kashish.ecommerce.controller;

import org.kashish.ecommerce.model.dto.OrderRequest;
import org.kashish.ecommerce.model.dto.OrderResponse;
import org.kashish.ecommerce.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class orderController {

    @Autowired
    private orderService orderservice;


    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestParam OrderRequest orderRequest) {
        OrderResponse orderResponse = orderservice.placedOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getOrders() {

       List<OrderResponse> orderResponse = orderservice.getAllOrderResponses();
       return new ResponseEntity<>(orderResponse, HttpStatus.OK);


    }

}
