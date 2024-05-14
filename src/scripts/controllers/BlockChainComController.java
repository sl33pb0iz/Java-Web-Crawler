package src.scripts.controllers;

import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

public class BlockChainComController extends WebCrawlController {
    private Elements elements;

    @Override
    public String getLinkFile() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\resources\\BlockchaincomUrl";
    }

    @Override
    public String getContainer() {
        return ".sc-5933466a-1.ecdyKA";
    }

    @Override
    public WebsiteInformation buildWebsiteInformation(Elements elements) {
        this.elements = elements;

        WebsiteInformation web = new WebsiteInformation();
        buildTitle(web);
        buildLink(web);
        buildSource(web);
        buildType(web);
        buildSummary(web);
        buildDetail(web);
        buildCreationDate(web);
        buildAssociated(web);
        buildSummary(web);
        buildCategory(web);

        return web;
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
