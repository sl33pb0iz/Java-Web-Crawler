package src.scripts.controllers.jsonInformationBuilder;

import org.jsoup.select.Elements;
import src.scripts.models.CategoryEnum;
import src.scripts.models.WebsiteInformation;

public class WikipediaCrawlController extends WebCrawlController {

    @Override
    public String getlinkFileCategory() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\datas\\jsonData\\WikipediaJSON";
    }

    @Override
    public String getLinkFile() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\datas\\url\\WikipediaUrl";
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
