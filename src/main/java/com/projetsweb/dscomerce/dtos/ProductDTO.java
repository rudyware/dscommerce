package com.projetsweb.dscomerce.dtos;

import com.projetsweb.dscomerce.entities.Product;
import jakarta.persistence.Column;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private Double price;

    public ProductDTO(){}

    public ProductDTO(Long id, String name, String description, String imgUrl, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        imgUrl = product.getImgUrl();
        price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPrice() {
        return price;
    }
}
