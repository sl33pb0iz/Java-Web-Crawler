package src.scripts.models.CrawlService.jsonInformationBuilder;

import org.jsoup.select.Elements;
import src.scripts.entities.WebsiteInformation;

public class FrontiersinOrgBuilder extends WebInformationBuilder {
    @Override
    public String getLinkFile() {return "..\\src\\datas\\url\\FrontiersinOrgUrl";
    }
    @Override
    public void buildTitle(WebsiteInformation web) {
        Elements elements = doc.select(".MainHeader__title");

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
        web.setDetailed(elements.text());

    }
    @Override
    public void buildCreationDate(WebsiteInformation web) {
        Elements elements = doc.select(".container-submission-status");
        web.setCreationDate(elements.text());

    }

    @Override
    public void buildAssociated(WebsiteInformation web) {

    }

    @Override
    public void buildAuthor(WebsiteInformation web) {
        Elements elements = doc.select(".teaser-heading author-name");
        web.setAuthor(elements.text());

    }

    @Override
    public void buildCategory(WebsiteInformation web) {
    }
}
