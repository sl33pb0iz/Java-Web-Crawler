package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WikipediaCrawlController extends WebCrawlController {

    public void ReadDataFromFile() throws IOException{
        super.ReadDataFromFile("C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\resources\\WikipediaUrl");
    }
    @Override
    public void CrawlDataFrom(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select(".mw-page-container");

        WebsiteInformation web = new WebsiteInformation();
        web.setType("Wikipedia");
        web.setLink(url);
        web.setSource("");
        web.setSummary("");
        web.setTitle(elements.select(".mw-page-title-main").text());
        web.setDetailed(elements.select("p").text());
        web.setCreationDate(elements.select("#footer-info-lastmod").text());
        web.setAssociated("");
        web.setAuthor(elements.select(".noprint").text());
        web.setCategory("");

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }
}
