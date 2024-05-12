package src.scripts.models;

public enum ArticleTypeEnum {
    Tweet,
    NewsArticle,
    BlogPost,
    FacebookPost,
    WikipediaPost;

    public static ArticleTypeEnum fromUrl(String url) {
        if (url.contains("twitter.com")) {
            return Tweet;
        } else if (url.contains("news")) {
            return NewsArticle;
        } else if (url.contains("blog")) {
            return BlogPost;
        } else if (url.contains("facebook.com")) {
            return FacebookPost;
        } else if (url.contains("wikipedia.org")) {
            return WikipediaPost;
        } else {
            throw new IllegalArgumentException("Unknown URL: " + url);
        }
    }
}
