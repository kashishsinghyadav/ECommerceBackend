package org.kashish.ecommerce.controller;

import org.springframework.transaction.annotation.Transactional;

import org.kashish.ecommerce.model.Product;
import org.kashish.ecommerce.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile) {

        Product product1= null;
        try {
            product1 = productservice.saveorUpdate(product,imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<>(product1,HttpStatus.CREATED);

    }
    @GetMapping("/product/{id}/image")
     public ResponseEntity<byte[]> getProductImangeById(@PathVariable int id) {
        
        Product productimg = productservice.getProductById(id);
        if (productimg != null) {
            return new ResponseEntity<>(productimg.getImageData(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

     }

     @PutMapping("/product/{id}")
     public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product,@RequestPart MultipartFile imageFile) throws IOException {
            Product upproduct = productservice.saveorUpdate(product,imageFile);
            if (upproduct != null) {
                return new ResponseEntity<>("Product Updated Successfully", HttpStatus.OK);
            }
            return new ResponseEntity<>("Product Not Updated", HttpStatus.NOT_FOUND);

     }



     @DeleteMapping("/product/{id}")
     public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product productdelete = productservice.getProductById(id);
        if(productdelete!=null){
            productservice.deleteProduct(productdelete);
            return new ResponseEntity<>("Product Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);

     }
// use this to handle large object
    @Transactional
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam String keyword) {

        List<Product> product = productservice.getProductBySearch(keyword);
        if (!product.isEmpty()) {
            return new ResponseEntity<>(product, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
