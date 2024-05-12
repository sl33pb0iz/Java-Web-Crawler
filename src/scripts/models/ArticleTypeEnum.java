package src.scripts.models;

public enum ArticleTypeEnum {
    Unknown,
    Tweet,
    NewsArticle,
    BlogPost,
    FacebookPost,
    WikipediaPost;


    public static ArticleTypeEnum fromUrl(String url) {
        switch (url){
            case "twitter":{
                return Tweet;
            }
            case "news":{
                return NewsArticle;
            }
            case "blog":{
                return BlogPost;
            }
            case "facebook":{
                return FacebookPost;
            }
            case "wikipedia.org":{
                System.out.println("wiki");
                return WikipediaPost;
            }
            default:{
                return Unknown;
            }
        }
    }
}
