package web.projects.wheeler.models;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

public class ListingDetailsModel {


    private Long id;
    private String username;
    private String phoneNo;
    private String brand;
    private String model;
    private Year year;
    private int seats;
    private int doors;
    private String imageUrl;
    private BigDecimal price;
    private List<ReviewModel> reviews;

    public Long getId() {
        return id;
    }

    public ListingDetailsModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ListingDetailsModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public ListingDetailsModel setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ListingDetailsModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public ListingDetailsModel setModel(String model) {
        this.model = model;
        return this;
    }

    public Year getYear() {
        return year;
    }

    public ListingDetailsModel setYear(Year year) {
        this.year = year;
        return this;
    }

    public int getSeats() {
        return seats;
    }

    public ListingDetailsModel setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public int getDoors() {
        return doors;
    }

    public ListingDetailsModel setDoors(int doors) {
        this.doors = doors;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ListingDetailsModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ListingDetailsModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public List<ReviewModel> getReviews() {
        return reviews;
    }

    public ListingDetailsModel setReviews(List<ReviewModel> reviews) {
        this.reviews = reviews;
        return this;
    }
}
