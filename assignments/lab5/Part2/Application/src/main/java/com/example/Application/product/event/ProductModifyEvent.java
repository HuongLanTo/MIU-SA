package com.example.Application.product.event;

import com.example.Application.product.service.dto.ProductDTO;

public class ProductModifyEvent {
    private ProductDTO product;

    public ProductModifyEvent(ProductDTO product) {
        this.product = product;
    }

    public ProductDTO getProduct() {
        return product;
    }
}
