package web.projects.wheeler.db.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User author;
    @ManyToOne
    private Vehicle vehicle;

    @Lob
    private String content;

    private int likes;

    private int dislikes;


}
