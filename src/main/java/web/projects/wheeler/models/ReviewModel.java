package web.projects.wheeler.models;

public class ReviewModel {

    private Long id;
    private Long listingId;
    private String author;

    private String content;

    private int likes;

    private int dislikes;

    public Long getId() {
        return id;
    }

    public ReviewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    public ReviewModel setListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ReviewModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ReviewModel setContent(String content) {
        this.content = content;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public ReviewModel setLikes(int likes) {
        this.likes = likes;
        return this;
    }

    public int getDislikes() {
        return dislikes;
    }

    public ReviewModel setDislikes(int dislikes) {
        this.dislikes = dislikes;
        return this;
    }
}
