package com.example.Application.cart.service.mapper;


import com.example.Application.cart.domain.Product;
import com.example.Application.cart.service.dto.ProductDTO;

public class ProductAdapter {
    public static Product toProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.getProductNumber(),
                productDTO.getDescription(),
                productDTO.getPrice()
        );
    }

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getProductNumber(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
