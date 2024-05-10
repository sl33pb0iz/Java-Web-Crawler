import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Blockchain").get();

        Elements elements = doc.select(".mw-content-container");


            WebsiteInformation web = new WebsiteInformation();
            web.setTitle(elements.select(".mw-page-title-main").text());
            web.setDetailed(elements.select("p").text());

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }
}
