package org.kashish.ecommerce.service;

import org.kashish.ecommerce.model.Product;
import org.kashish.ecommerce.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {


    @Autowired
    private productRepo productRepo;


    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }
}
