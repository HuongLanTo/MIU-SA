package com.example.Client.cart.service.mapper;


import com.example.Client.cart.service.dto.ProductDTO;
import com.example.Client.cart.domain.Product;

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
