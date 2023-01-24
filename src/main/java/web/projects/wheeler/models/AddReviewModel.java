package web.projects.wheeler.models;

public class AddReviewModel {

    private Long listingId;
    private String content;

    public Long getListingId() {
        return listingId;
    }

    public AddReviewModel setListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public AddReviewModel setContent(String content) {
        this.content = content;
        return this;
    }
}
