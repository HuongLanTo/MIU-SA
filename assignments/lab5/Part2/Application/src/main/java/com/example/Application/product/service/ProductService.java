package com.example.Application.product.service;

import com.example.Application.product.service.dto.ProductDTO;

public interface ProductService {
    void create(ProductDTO productDTO);

    ProductDTO getProduct(Long productNumber);

}
