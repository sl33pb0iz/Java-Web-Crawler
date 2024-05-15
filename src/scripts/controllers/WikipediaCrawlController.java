package src.scripts.controllers;

import org.jsoup.select.Elements;
import src.scripts.Main;
import src.scripts.models.WebsiteInformation;

public class WikipediaCrawlController extends WebCrawlController {
    public WikipediaCrawlController(){
        Main.webCrawlControllers.add(this);
    }

    @Override
    public String getlinkFileCategory() {
        return "C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\resources\\jsonData\\Category1";
    }

    @Override
    public String getLinkFile() {
        return "C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\resources\\url\\WikipediaUrl";
    }

    @Override
    public void buildTitle(WebsiteInformation web) {
        Elements elements = doc.select(".mw-page-title-main");
        web.setTitle(elements.text());
    }

    @Override
    public void buildLink(WebsiteInformation web) {
        web.setLink(currentUrl);
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
        Elements elements = doc.select("p");
        web.setTitle(elements.text());
    }

    @Override
    public void buildCreationDate(WebsiteInformation web) {
        web.setCreationDate(doc.select("#footer-info-lastmod").text());
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
