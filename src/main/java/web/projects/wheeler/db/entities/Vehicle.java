package web.projects.wheeler.db.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "vehicles")
public class Vehicle{

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

    private LocalDate year;
    private int seats;
    private int doors;

    private String picUrl;
    @ManyToOne
    private User owner;


}
