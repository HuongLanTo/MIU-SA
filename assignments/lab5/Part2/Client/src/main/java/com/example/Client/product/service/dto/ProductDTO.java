package com.example.Client.product.service.dto;

public class ProductDTO {
    private Long productNumber;
    private String description;
    private double price;

    public ProductDTO(Long productNumber, String description, double price) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
    }

    public ProductDTO() {
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
