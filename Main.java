import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.blockchain.com/blog/posts/top-moving-tokens-in-april-2024").get();
        Elements elements = doc.select(".sc-5933466a-1.ecdyKA");

        WebsiteInformation web = new WebsiteInformation();
        web.setTitle(elements.select(".sc-1f19948b-5.fOSzTG").text());
        web.setDetailed(elements.select(".sc-1f19948b-6.gTWyeq").text() + elements.select(".sc-1f19948b-7.fWlASx").text());

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }
}
