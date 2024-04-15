package com.example.Client.product.service.mapper;

import com.example.Client.product.domain.Product;
import com.example.Client.product.service.dto.ProductDTO;

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
