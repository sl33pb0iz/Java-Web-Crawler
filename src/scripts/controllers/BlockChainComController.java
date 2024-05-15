package src.scripts.controllers;

import src.scripts.Main;
import src.scripts.models.WebsiteInformation;

public class BlockChainComController extends WebCrawlController {
    public BlockChainComController(){
        Main.webCrawlControllers.add(this);
    }


    @Override
    public String getLinkFile() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\resources\\BlockchaincomUrl";
    }

    @Override
    public WebsiteInformation buildWebsiteInformation() {

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
        web.setType("blog");
    }

    @Override
    public void setSummary(WebsiteInformation web) {
        web.setSummary("");
    }

    @Override
    public void setTitle(WebsiteInformation web) {
        web.setTitle(elements.select(".sc-1f19948b-5.fOSzTG").text());
    }

    @Override
    public void setDetail(WebsiteInformation web) {
        web.setDetailed(elements.select(".sc-1f19948b-6.gTWyeq").text() + elements.select(".sc-1f19948b-7.fWlASx").text());
    }

    @Override
    public void setCreationDate(WebsiteInformation web) {
        web.setCreationDate(elements.select(".sc-cba31b2d-8.bEKtyJ").text());
    }

    @Override
    public void setAssociated(WebsiteInformation web) {
        web.setAssociated("");
    }

    @Override
    public void setAuthor(WebsiteInformation web) {
        web.setAuthor(elements.select(".sc-cba31b2d-7.gPdnYn").text());
    }

    @Override
    public void setCategory(WebsiteInformation web) {
        web.setCategory("");
    }
}
