package web.projects.wheeler.models;

public class ReviewModel {

    private String author;

    private String content;

    private int likes;

    private int dislikes;

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
