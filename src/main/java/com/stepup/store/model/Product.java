package com.stepup.store.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String category;
    private double price;
    private double originalPrice;
    private int discountPercent;
    private String sizes;       // comma-separated: "4,5,6,7,8"
    private String colors;      // comma-separated
    private double rating;
    private int stock;
    private String imageUrl;

    @Column(length = 1000)
    private String description;

    public Product() {}

    public Product(String name, String brand, String category, double price,
                   double originalPrice, int discountPercent, String sizes,
                   String colors, double rating, int stock, String imageUrl, String description) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.originalPrice = originalPrice;
        this.discountPercent = discountPercent;
        this.sizes = sizes;
        this.colors = colors;
        this.rating = rating;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public double getOriginalPrice() { return originalPrice; }
    public int getDiscountPercent() { return discountPercent; }
    public String getSizes() { return sizes; }
    public String getColors() { return colors; }
    public double getRating() { return rating; }
    public int getStock() { return stock; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setOriginalPrice(double originalPrice) { this.originalPrice = originalPrice; }
    public void setDiscountPercent(int discountPercent) { this.discountPercent = discountPercent; }
    public void setSizes(String sizes) { this.sizes = sizes; }
    public void setColors(String colors) { this.colors = colors; }
    public void setRating(double rating) { this.rating = rating; }
    public void setStock(int stock) { this.stock = stock; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setDescription(String description) { this.description = description; }
}
