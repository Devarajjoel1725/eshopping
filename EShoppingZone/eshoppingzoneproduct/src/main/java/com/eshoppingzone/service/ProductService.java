package com.eshoppingzone.service;

import com.eshoppingzone.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ProductService {
    List<Product> products=new ArrayList();
    public String addProduct(Product product) {
        products.add(product);
        return "Success";
    }

    public List<Product> listAllProducts() {
        return products;
    }

    public List<Product> productCategoryList(String category) {
     return products.stream()
             .filter(product -> product.getCategory().getName().equalsIgnoreCase(category))
             .collect(Collectors.toList());
    }

    public Product productById(Integer id) {
        return products.stream()
                .filter(product -> product.getProductId()== id)
                .findAny()
                .get();
    }

    public String updateProduct(Product product) {

        for(Product prod : products){
            if(prod.getProductId()== product.getProductId()){
                prod.setProductName(product.getProductName());
                prod.setCategory(product.getCategory());
                prod.setDiscount(product.getDiscount());
                prod.setDescription(product.getDescription());

                return "product update successfully";
            }
        }
        return "product update successfully";
    }


    public String deleteProductById(Integer id) {
        for(Product product : products){
            if(product.getProductId()==id){
                products.remove(product);
                return "product deleted";
            }
        }
        return "product deletion failed";
    }
}
