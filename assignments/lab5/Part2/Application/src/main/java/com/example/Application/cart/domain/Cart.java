package com.example.Application.cart.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "cart")
public class Cart {
    @Id
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

    public void updateProduct(Product product) {
        for(CartLine line : cartLines) {
            if(Objects.equals(line.getProduct().getProductNumber(), product.getProductNumber())) {
                line.setProduct(product);
                return;
            }
        }
    }

    public boolean isProductExist(Product product) {
        return cartLines.stream()
                .anyMatch(line -> line.getProduct().getProductNumber().equals(product.getProductNumber()));
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
