package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

import java.io.IOException;

public class BlockChainComController extends WebCrawlController {
    public void ReadDataFromFile() throws IOException {
        super.ReadDataFromFile("C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\resources\\BlockchaincomUrl");
    }
    @Override
    public void CrawlDataFrom(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select(".sc-5933466a-1.ecdyKA");

        WebsiteInformation web = new WebsiteInformation();
        web.setType("blog");
        web.setLink(url);
        web.setSource("");
        web.setSummary("");
        web.setTitle(elements.select(".sc-1f19948b-5.fOSzTG").text());
        web.setDetailed(elements.select(".sc-1f19948b-6.gTWyeq").text() + elements.select(".sc-1f19948b-7.fWlASx").text());
        web.setCreationDate(elements.select(".sc-cba31b2d-8.bEKtyJ").text());
        web.setAssociated("");
        web.setAuthor(elements.select(".sc-cba31b2d-7.gPdnYn").text());
        web.setCategory("");

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }
}
