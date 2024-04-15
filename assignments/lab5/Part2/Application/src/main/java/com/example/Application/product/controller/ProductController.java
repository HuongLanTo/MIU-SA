package com.example.Application.product.controller;

import com.example.Application.product.service.ProductService;
import com.example.Application.product.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{productNumber}")
    public ResponseEntity<?> getProductById(@PathVariable Long productNumber) {
        ProductDTO product = productService.getProduct(productNumber);
        return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
        return new ResponseEntity<ProductDTO>(HttpStatus.CREATED);
    }
}
