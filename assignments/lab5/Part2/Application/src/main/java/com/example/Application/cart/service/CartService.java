package com.example.Application.cart.service;

import com.example.Application.cart.service.dto.CartDTO;

public interface CartService {
    void addToCart(Long cartId, int quantity, Long productNumber);

    CartDTO getCart(Long cartId);
}
