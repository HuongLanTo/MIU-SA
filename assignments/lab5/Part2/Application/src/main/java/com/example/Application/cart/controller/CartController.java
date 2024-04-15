package com.example.Application.cart.controller;

import com.example.Application.cart.service.CartService;
import com.example.Application.cart.service.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{cartId}/{productNumber}/{quantity}")
    public ResponseEntity<?> addToCart(@PathVariable Long cartId, @PathVariable Long productNumber,
                                    @PathVariable int quantity) {
        try {
            cartService.addToCart(cartId, quantity, productNumber);
            return new ResponseEntity<CartDTO>(HttpStatus.OK);
        } catch(RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCart(@PathVariable Long cartId) {
        CartDTO cartDTO = cartService.getCart(cartId);
        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
    }
}
