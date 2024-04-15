package com.example.Client.cart.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Cart {
    private Long cartId;

    private List<CartLine> cartLines = new ArrayList<>();

    public Cart(Long cartId, List<CartLine> cartLines) {
        this.cartId = cartId;
        this.cartLines = cartLines;
    }

    public Cart() {
    }

    public void addToCart(Product product, int quantity) {
        for(CartLine line : cartLines) {
            if(Objects.equals(line.getProduct().getProductNumber(), product.getProductNumber())) {
                line.setQuantity(line.getQuantity() + quantity);
                return;
            }
        }

        CartLine newLine = new CartLine(quantity, product);
        cartLines.add(newLine);
    }

    public void print() {
        System.out.println("Cart Information: ");
        System.out.println("Cart ID: " + this.cartId);
        for(CartLine line: cartLines) {
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

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }
}
