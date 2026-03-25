package org.kashish.ecommerce.controller;


import org.kashish.ecommerce.model.Product;
import org.kashish.ecommerce.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class productController {

    @Autowired
    private productService productservice;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productservice.getAllProduct();

    }

}
