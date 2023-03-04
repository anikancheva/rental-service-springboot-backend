package web.projects.wheeler.db.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Year;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    private Year year;
    private int seats;
    private int doors;

    private String picUrl;
    @ManyToOne
    private UserModel owner;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    public Long getId() {
        return id;
    }

    public Vehicle setId(Long id) {
        this.id = id;
        return this;
    }

    public VehicleType getType() {
        return type;
    }

    public Vehicle setType(VehicleType type) {
        this.type = type;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Vehicle setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public Year getYear() {
        return year;
    }

    public Vehicle setYear(Year year) {
        this.year = year;
        return this;
    }

    public int getSeats() {
        return seats;
    }

    public Vehicle setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public int getDoors() {
        return doors;
    }

    public Vehicle setDoors(int doors) {
        this.doors = doors;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public Vehicle setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public UserModel getOwner() {
        return owner;
    }

    public Vehicle setOwner(UserModel owner) {
        this.owner = owner;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Vehicle setCategory(Category category) {
        this.category = category;
        return this;
    }
}
