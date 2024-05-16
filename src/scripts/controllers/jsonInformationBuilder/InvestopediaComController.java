package src.scripts.controllers.jsonInformationBuilder;

import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

public class InvestopediaComController extends WebCrawlController {

    @Override
    public String getlinkFileCategory() {
        return "D:\\IT\\pork\\Java-Web-Crawler\\src\\datas\\jsonData\\InvestopediaJSON";
    }

    @Override
    public String getLinkFile() {
        return "D:\\IT\\pork\\Java-Web-Crawler\\src\\datas\\url\\InvestopediaUrl";
    }

    @Override
    public void buildTitle(WebsiteInformation web) {
        Elements elements = doc.select("h1#article-heading_1-0");

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
        Elements elements = doc.select("p.comp.mntl-sc-block.finance-sc-block-html.mntl-sc-block-html");
        web.setDetailed(elements.text());

    }

    @Override
    public void buildCreationDate(WebsiteInformation web) {
        Elements elements = doc.select("div.mntl-attribution__item-date");
        web.setCreationDate(elements.text());

    }

    @Override
    public void buildAssociated(WebsiteInformation web) {

    }

    @Override
    public void buildAuthor(WebsiteInformation web) {
        Elements elements = doc.select("a.mntl-attribution__item-name");
        web.setAuthor(elements.text());

    }

    @Override
    public void buildCategory(WebsiteInformation web) {

    }
}