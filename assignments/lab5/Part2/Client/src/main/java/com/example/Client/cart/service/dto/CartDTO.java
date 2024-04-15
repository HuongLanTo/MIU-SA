package com.example.Client.cart.service.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    private Long cartId;
    private List<CartLineDTO> cartLineDTOS = new ArrayList<>();

    public CartDTO(Long cartId, List<CartLineDTO> cartLineDTOS) {
        this.cartId = cartId;
        this.cartLineDTOS = cartLineDTOS;
    }

    public CartDTO() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartLineDTO> getCartLineDTOS() {
        return cartLineDTOS;
    }

    public void setCartLineDTOS(List<CartLineDTO> cartLineDTOS) {
        this.cartLineDTOS = cartLineDTOS;
    }

    public void print() {
        System.out.println("Cart Information: ");
        System.out.println("Cart ID: " + this.cartId);
        for(CartLineDTO line: cartLineDTOS) {
            System.out.println(
                    "Product: (id: " + line.getProduct().getProductNumber()
                            + ", description: " + line.getProduct().getDescription()
                            + ", price: " + line.getProduct().getPrice()
                            + ")"
            );
            System.out.println(
                    "Quantity: " + line.getQuantity()
            );
        }
    }
}
