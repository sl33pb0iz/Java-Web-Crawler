package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

import java.io.IOException;

public class WikipediaCrawlController extends WebCrawlController {
    Document doc;
    Elements elements;

    @Override
    public void crawlDataFrom(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        elements = doc.select(".mw-page-container");

        WebsiteInformation web = new WebsiteInformation();

        buildType(web);
        buildDetail(web);
        buildAssociated(web);
        buildCategory(web);
        buildCreationDate(web);
        buildAuthor(web);
        buildSummary(web);
        buildLink(web);
        buildSource(web);
        buildCategory(web);

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }

    @Override
    public String getLinkFile() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\resources\\WikipediaUrl";
    }

    @Override
    public String getContainer() {
        return null;
    }

    @Override
    public WebsiteInformation buildWebsiteInformation(Elements elements) {
        return null;
    }

    @Override
    public void buildTitle(WebsiteInformation web) {

    }

    @Override
    public void buildLink(WebsiteInformation web) {
    }

    @Override
    public void buildSource(WebsiteInformation websiteInformation) {

    }

    @Override
    public void buildType(WebsiteInformation web) {
    }

    @Override
    public void buildSummary(WebsiteInformation web) {

    }

    @Override
    public void buildDetail(WebsiteInformation web) {

    }

    @Override
    public void buildCreationDate(WebsiteInformation web) {

    }

    @Override
    public void buildAssociated(WebsiteInformation web) {

    }

    @Override
    public void buildAuthor(WebsiteInformation web) {

    }

    @Override
    public void buildCategory(WebsiteInformation web) {

    }
}
