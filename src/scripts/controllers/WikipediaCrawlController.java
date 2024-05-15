package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

import java.io.IOException;

public class WikipediaCrawlController extends WebCrawlController {
    public void ReadDataFromFile() throws IOException{
        super.readDataFromFile("C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\resources\\WikipediaUrl");
    }

    @Override
    public void CrawlDataFrom(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        elements = doc.select(".mw-page-container");

        WebsiteInformation web = new WebsiteInformation();

        setType(web);
        setDetail(web);
        setAssociated(web);
        setCategory(web);
        setCreationDate(web);
        setAuthor(web);
        setSummary(web);
        setLink(web,url);
        setSource(web);
        setCategory(web);

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }

    @Override
    public void setLink(WebsiteInformation web, String url) {
        web.setLink(url);
    }

    @Override
    public void setSource(WebsiteInformation web) {
        web.setSource("");
    }

    @Override
    public void setType(WebsiteInformation web) {
        web.setType("");
    }

    @Override
    public void setSummary(WebsiteInformation web) {
        web.setSummary("");
    }

    @Override
    public void setTitle(WebsiteInformation web) {
        web.setTitle(elements.select(".mw-page-title-main").text());
    }

    @Override
    public void setDetail(WebsiteInformation web) {
        web.setDetailed(elements.select("p").text());
    }

    @Override
    public void setCreationDate(WebsiteInformation web) {
        web.setCreationDate(elements.select("#footer-info-lastmod").text());
    }

    @Override
    public void setAssociated(WebsiteInformation web) {
        web.setAssociated("");
    }

    @Override
    public void setAuthor(WebsiteInformation web) {
        web.setAuthor("");
    }

    @Override
    public void setCategory(WebsiteInformation web) {
        web.setCategory("");
    }
}
