package src.scripts.controllers.jsonInformationBuilder;

import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

public class WikipediaCrawlController extends WebCrawlController {

    @Override
    public String getlinkFileCategory() {
        return "C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\resources\\jsonData\\DefinitionOfBlockchain";
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
    public void buildSource(WebsiteInformation web) {

    }

    @Override
    public void buildType(WebsiteInformation web) {
        String[] parts = currentUrl.split("/");
        if (parts.length > 1) {
            String type = parts[3]; // Get the second last part of the host
            web.setType(type);
        }
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
        web.setAuthor("wikipedia");
    }

    @Override
    public void buildCategory(WebsiteInformation web) {

    }

}
