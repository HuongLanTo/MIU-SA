package com.example.Application.cart.service;

import com.example.Application.cart.domain.Cart;
import com.example.Application.cart.domain.Product;
import com.example.Application.cart.repository.CartRepository;
import com.example.Application.cart.service.dto.CartDTO;
import com.example.Application.cart.service.mapper.CartAdapter;
import com.example.Application.product.service.dto.ProductDTO;
import com.example.Application.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;

    @Override
    public void addToCart(Long cartId, int quantity, Long productNumber) {
        ProductDTO productDTO = productService.getProduct(productNumber);
        if(productDTO == null) {
            throw new RuntimeException("Product with id: " + productNumber + " is not existed");
        }
        Product product = new Product(productDTO.getProductNumber(), productDTO.getDescription(), productDTO.getPrice());
        Optional<Cart> existingCart = cartRepository.findById(cartId);
        if(existingCart.isPresent()) {
            Cart cart = existingCart.get();
            cart.addToCart(product, quantity);
            cartRepository.save(cart);
        } else {
            Cart cart = new Cart();
            cart.setCartId(cartId);
            cart.addToCart(product, quantity);
            cartRepository.save(cart);
        }
    }

    @Override
    public CartDTO getCart(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if(cart.isPresent()) {
            return CartAdapter.toCartDTO(cart.get());
        }
        return null;
    }
}
