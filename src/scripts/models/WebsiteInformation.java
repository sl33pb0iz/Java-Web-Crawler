package src.scripts.models;

public class WebsiteInformation {
    private String link;
    private String source;
    private ArticleTypeEnum type;
    private String summary;
    private String title;
    private String Detailed;
    private String Creation;
    private String Associated;
    private String Author;
    private String Category;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ArticleTypeEnum getType() {
        return type;
    }

    public void setType(ArticleTypeEnum type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetailed() {
        return Detailed;
    }

    public void setDetailed(String detailed) {
        Detailed = detailed;
    }

    public String getCreation() {
        return Creation;
    }

    public void setCreation(String creation) {
        Creation = creation;
    }

    public String getAssociated() {
        return Associated;
    }

    public void setAssociated(String associated) {
        Associated = associated;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
