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
