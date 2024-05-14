package src.scripts.controllers;

import src.scripts.Main;
import src.scripts.models.WebsiteInformation;

public class WikipediaCrawlController extends WebCrawlController {
    public WikipediaCrawlController(){
        Main.webCrawlControllers.add(this);
    }

    @Override
    public String getLinkFile() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\resources\\WikipediaUrl";
    }

    @Override
    public WebsiteInformation buildWebsiteInformation() {
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
