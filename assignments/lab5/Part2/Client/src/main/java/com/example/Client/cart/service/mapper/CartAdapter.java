package com.example.Client.cart.service.mapper;

import com.example.Client.cart.domain.Cart;
import com.example.Client.cart.domain.CartLine;
import com.example.Client.cart.service.dto.CartDTO;
import com.example.Client.cart.service.dto.CartLineDTO;

public class CartAdapter {
    public static Cart toCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        for(CartLineDTO line : cartDTO.getCartLineDTOS()) {
            cart.getCartLines().add(CartLineAdapter.toCartLine(line));
        };
        return cart;
    }

    public static CartDTO toCartDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        for(CartLine line : cart.getCartLines()) {
            cartDTO.getCartLineDTOS().add(CartLineAdapter.toCartLineDTO(line));
        }
        return cartDTO;
    }
}
