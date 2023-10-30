package com.example.myproject.service;


import com.example.myproject.dto.ProductRequest;
import com.example.myproject.dto.ProductResponse;
import com.example.myproject.model.Product;
import com.example.myproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServices {


    private  final ProductRepository productRepository;



    public void createProduct(ProductRequest productRequest)
    {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);

        log.info("product" + product.getId() + "is saved");
    }

    public List<ProductResponse> getAllProducts(){
     List<Product>  products =  productRepository.findAll();
  return  products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }

    public String deleteProductById(Long id){
        productRepository.deleteById( id);
        return "id has been deleted";
    }

    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }



}
