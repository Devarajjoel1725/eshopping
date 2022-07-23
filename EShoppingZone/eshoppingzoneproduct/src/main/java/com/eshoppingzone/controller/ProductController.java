package com.eshoppingzone.controller;

import com.eshoppingzone.entity.Product;
import com.eshoppingzone.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    private ProductService productService;


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

    @GetMapping("/productList/{id}")
    Product productById(@PathVariable Integer id) {
        return productService.productById(id);
    }

    @GetMapping("/productUpdate")
    String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/productList/{id}")
    String deleteProductById(@PathVariable Integer id){
        return productService.deleteProductById(id);
    }
}