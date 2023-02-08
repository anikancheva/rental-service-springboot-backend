package web.projects.wheeler.models;

import java.math.BigDecimal;
import java.time.Year;

public class ListingModel {

    private String username;
    private String phoneNo;
    private String brand;
    private String model;
    private Year year;
    private int seats;
    private int doors;
    private String imageUrl;
    private BigDecimal price;

    public String getUsername() {
        return username;
    }

    public ListingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public ListingModel setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public int getSeats() {
        return seats;
    }

    public ListingModel setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public int getDoors() {
        return doors;
    }

    public ListingModel setDoors(int doors) {
        this.doors = doors;
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
