package web.projects.wheeler.db.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserModel author;
    @ManyToOne(fetch = FetchType.EAGER)
    private Listing listing;

    @Lob
    private String content;

    private int likes;

    private int dislikes;


    public Long getId() {
        return id;
    }

    public Review setId(Long id) {
        this.id = id;
        return this;
    }

    public UserModel getAuthor() {
        return author;
    }

    public Review setAuthor(UserModel author) {
        this.author = author;
        return this;
    }

    public Listing getListing() {
        return listing;
    }

    public Review setListing(Listing listing) {
        this.listing = listing;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Review setContent(String content) {
        this.content = content;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public Review setLikes(int likes) {
        this.likes = likes;
        return this;
    }

    public int getDislikes() {
        return dislikes;
    }

    public Review setDislikes(int dislikes) {
        this.dislikes = dislikes;
        return this;
    }
}
