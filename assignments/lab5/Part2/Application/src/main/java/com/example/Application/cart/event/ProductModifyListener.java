package com.example.Application.cart.event;

import com.example.Application.cart.domain.Cart;
import com.example.Application.cart.domain.CartLine;
import com.example.Application.cart.domain.Product;
import com.example.Application.cart.repository.CartRepository;
import com.example.Application.product.event.ProductModifyEvent;
import com.example.Application.product.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductModifyListener {
    @Autowired
    CartRepository cartRepository;

    @EventListener
    public void onEvent(ProductModifyEvent event) {
        ProductDTO productDTO = event.getProduct();
        Product product = new Product(productDTO.getProductNumber(), productDTO.getDescription(), productDTO.getPrice());
        List<Cart> carts = cartRepository.findAll();
        for(Cart cart : carts) {
            if(cart.isProductExist(product)) {
                cart.updateProduct(product);
                cartRepository.save(cart);
            }
        }
    }
}
