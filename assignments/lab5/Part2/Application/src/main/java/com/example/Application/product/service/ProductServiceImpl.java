package com.example.Application.product.service;

import com.example.Application.product.domain.Product;
import com.example.Application.product.event.ProductModifyEvent;
import com.example.Application.product.repository.ProductRepository;
import com.example.Application.product.service.dto.ProductDTO;
import com.example.Application.product.service.mapper.ProductAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ApplicationEventPublisher publisher;

    @Override
    public void create(ProductDTO productDTO) {
        Product product = ProductAdapter.toProduct(productDTO);
        Optional<Product> existingProduct = productRepository.findById(product.getProductNumber());
        if(existingProduct.isPresent()) {
            publisher.publishEvent(new ProductModifyEvent(productDTO));
        }
        productRepository.save(product);

    }

    @Override
    public ProductDTO getProduct(Long productNumber) {
        Optional<Product> product = productRepository.findById(productNumber);
        if(product.isPresent()) {
            return ProductAdapter.toProductDTO(product.get());
        }
        return null;
    }
}
