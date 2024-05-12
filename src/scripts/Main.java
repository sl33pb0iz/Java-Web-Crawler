package src.scripts;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.ArticleTypeEnum;
import src.scripts.models.WebsiteInformation;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        String url  = "https://en.wikipedia.org/wiki/Blockchain";

        Document doc = Jsoup.connect(url).get();

        Elements elements = doc.select(".mw-content-container");

        ArticleTypeEnum articleType = ArticleTypeEnum.fromUrl(url);

        WebsiteInformation web = new WebsiteInformation();
        web.setTitle(elements.select(".mw-page-title-main").text());
        web.setDetailed(elements.select("p").text());
        web.setType(articleType);

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }
}
