package org.kashish.ecommerce.controller;


import org.kashish.ecommerce.model.Product;
import org.kashish.ecommerce.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        Product product = productservice.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);



    }

}
