package com.productmicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.productmicroservice.entity.Product;
import com.productmicroservice.repository.ProductRepository;
import com.productmicroservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/addProduct")
    ResponseEntity<Product> addProduct(@RequestBody Product product) {

        String status = productService.addProduct(product);

        logger.info("Product add stats {}", status);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/productList")
    List<Product> productList() {
        return productService.listAllProducts();
    }

    @GetMapping("/productList/{category}")
    List<Product> productCategoryList(@PathVariable String category) {
        return productService.productCategoryList(category);
    }

    @GetMapping("/product/{productId}")
    Product productById(@PathVariable Integer productId) {
        return productService.productById(productId);
    }

    @PutMapping("/productUpdate")
    String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{productId}")
    String deleteProductById(@PathVariable Integer productId){
        return productService.deleteProductById(productId);
    }
}