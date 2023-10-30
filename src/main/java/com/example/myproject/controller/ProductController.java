package com.example.myproject.controller;


import com.example.myproject.dto.ProductRequest;
import com.example.myproject.dto.ProductResponse;
import com.example.myproject.model.Product;
import com.example.myproject.service.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productServices;

    @PostMapping("/created")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest)
    {
        productServices.createProduct(productRequest);

    }

    @GetMapping("/getproduct")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productServices.getAllProducts();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
public Product updateProduct(@RequestBody Product product){
        return productServices.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)

    public String deleteProduct(@PathVariable Long id){
        return productServices.deleteProductById(id);
    }

}
