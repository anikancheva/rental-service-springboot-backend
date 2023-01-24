package web.projects.wheeler.db.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UserModel creator;
    @OneToOne
    private Vehicle vehicle;

    @Min(0)
    private BigDecimal price;

    @OneToMany(mappedBy = "listing")
    private List<Review> reviews;

    public Long getId() {
        return id;
    }

    public Listing setId(Long id) {
        this.id = id;
        return this;
    }

    public UserModel getCreator() {
        return creator;
    }

    public Listing setCreator(UserModel creator) {
        this.creator = creator;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Listing setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Listing setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
