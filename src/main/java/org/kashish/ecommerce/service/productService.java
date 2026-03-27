package org.kashish.ecommerce.service;

import org.kashish.ecommerce.model.Product;
import org.kashish.ecommerce.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        return productRepo.save(product);

    }

    public Product saveorUpdate(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        return productRepo.save(product);
    }

    public void deleteProduct(Product productdelete) {
        productRepo.delete(productdelete);
    }

    public List<Product> getProductBySearch(String keyword) {
        return productRepo.findProductByKeyword(keyword);

    }
}
