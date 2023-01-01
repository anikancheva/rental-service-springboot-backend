package web.projects.wheeler.db.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User creator;
    @OneToOne
    private Vehicle vehicle;

    @Min(0)
    private BigDecimal price;

}
