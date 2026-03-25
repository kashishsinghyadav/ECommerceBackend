package org.kashish.ecommerce.controller;


import org.kashish.ecommerce.model.Product;
import org.kashish.ecommerce.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class productController {

    @Autowired
    private productService productservice;

    @GetMapping("/product")
    public List<Product> getProduct() {
        return productservice.getAllProduct();

    }

}
