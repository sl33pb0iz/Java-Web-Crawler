package src.scripts.controllers.jsonInformationBuilder;

import src.scripts.models.CategoryEnum;
import src.scripts.models.WebsiteInformation;

public class BlockChainComController extends WebCrawlController {

    @Override
    public String getlinkFileCategory() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\datas\\jsonData\\BlockchainComJSON";
    }

    @Override
    public String getLinkFile() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\datas\\url\\BlockchaincomUrl";
    }

    @Override
    public WebsiteInformation buildWebsiteInformation() {

        WebsiteInformation web = new WebsiteInformation();
        buildTitle(web);
        buildLink(web);
        buildSource(web);
        buildType(web);
        buildSummary(web);
        /*buildDetail(web);*/
        buildCreationDate(web);
        buildAssociated(web);
        buildSummary(web);
        buildCategory(web);

        return web;
    }

    @Override
    public void buildTitle(WebsiteInformation web) {
        web.setTitle(doc.select(".sc-1f19948b-5.fOSzTG").text());
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
        web.setDetailed(doc.select(".sc-1f19948b-6.gTWyeq").text() + doc.select(".sc-1f19948b-7.fWlASx").text());
    }

    @Override
    public void buildCreationDate(WebsiteInformation web) {
        web.setCreationDate(doc.select(".sc-cba31b2d-8.bEKtyJ").text());
    }

    @Override
    public void buildAssociated(WebsiteInformation web) {

    }

    @Override
    public void buildAuthor(WebsiteInformation web) {
        web.setAuthor(doc.select(".sc-cba31b2d-7.gPdnYn").text());
    }

    @Override
    public void buildCategory(WebsiteInformation web) {
        String summaryText = doc.select(".sc-1f19948b-6.gTWyeq").text() + doc.select(".sc-1f19948b-7.fWlASx").text();
        web.setCategory(CategoryEnum.CategoryClassify(summaryText).toString());
    }
}
