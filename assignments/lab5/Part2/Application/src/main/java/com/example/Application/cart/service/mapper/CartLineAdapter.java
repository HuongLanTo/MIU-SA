package com.example.Application.cart.service.mapper;

import com.example.Application.cart.domain.CartLine;
import com.example.Application.cart.service.dto.CartLineDTO;

public class CartLineAdapter {
    public static CartLine toCartLine(CartLineDTO cartLineDTO) {
        return new CartLine(
                cartLineDTO.getQuantity(),
                ProductAdapter.toProduct(cartLineDTO.getProduct())
        );
    }

    public static CartLineDTO toCartLineDTO(CartLine cartLine) {
        return new CartLineDTO(
                cartLine.getQuantity(),
                ProductAdapter.toProductDTO(cartLine.getProduct())
        );
    }
}
