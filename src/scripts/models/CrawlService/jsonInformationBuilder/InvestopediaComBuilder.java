package src.scripts.models.CrawlService.jsonInformationBuilder;

import org.jsoup.select.Elements;
import src.scripts.entities.CategoryEnum;
import src.scripts.entities.WebsiteInformation;

public class InvestopediaComBuilder extends WebInformationBuilder {

    @Override
    public String getLinkFile() {
        return "src\\datas\\url\\InvestopediaUrl";
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
        String summaryText = doc.select("p.comp.mntl-sc-block.finance-sc-block-html.mntl-sc-block-html").text();
        web.setCategory(CategoryEnum.CategoryClassify(summaryText).toString());
    }
}