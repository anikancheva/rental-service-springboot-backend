package web.projects.wheeler.models;

import java.math.BigDecimal;
import java.time.Year;

public class ListingModel {

    private Long id;
    private String brand;
    private String model;
    private Year year;
    private String imageUrl;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public ListingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ListingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public ListingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public Year getYear() {
        return year;
    }

    public ListingModel setYear(Year year) {
        this.year = year;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ListingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ListingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
