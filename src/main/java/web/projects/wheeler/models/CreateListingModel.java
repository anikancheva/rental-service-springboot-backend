package web.projects.wheeler.models;


import web.projects.wheeler.db.entities.UserModel;

import java.math.BigDecimal;
import java.time.Year;

public class CreateListingModel {

    private BigDecimal price;

    private String type;

    private String brand;

    private String model;

    private Year year;

    private int seats;

    private int doors;

    private String picUrl;

    private UserModel owner;

    public BigDecimal getPrice() {
        return price;
    }

    public CreateListingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getType() {
        return type;
    }

    public CreateListingModel setType(String type) {
        this.type = type;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CreateListingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CreateListingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public Year getYear() {
        return year;
    }

    public CreateListingModel setYear(Year year) {
        this.year = year;
        return this;
    }

    public int getSeats() {
        return seats;
    }

    public CreateListingModel setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public int getDoors() {
        return doors;
    }

    public CreateListingModel setDoors(int doors) {
        this.doors = doors;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public CreateListingModel setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public UserModel getOwner() {
        return owner;
    }

    public CreateListingModel setOwner(UserModel owner) {
        this.owner = owner;
        return this;
    }
}
