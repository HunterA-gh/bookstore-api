package com.hunter.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String isbn;
    private String description;
    private Double price;
    private String active;
    private String image;
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Category category;

    public Book() {
    }

    public Book(Long id, String name, String isbn, String description, Double price, String active, String image, Integer stock, Category category) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.description = description;
        this.price = price;
        this.active = active;
        this.image = image;
        this.stock = stock;
        this.category = category;
    }

    public Book(Long id, String name, String isbn, String description, Double price, String active, String image, Integer stock) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.description = description;
        this.price = price;
        this.active = active;
        this.image = image;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
