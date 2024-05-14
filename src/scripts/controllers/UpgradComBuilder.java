package src.scripts.controllers;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

public class UpgradComBuilder extends WebCrawlController{
    @Override
    public String getLinkFile() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\resources\\url\\UpgradUrl";
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
        buildAuthor(web);

        return web;
    }

    @Override
    public void buildTitle(WebsiteInformation web) {
        Elements elements = doc.select("#banner-title");
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

        String[] parts = currentUrl.split("\\.");

        if (parts.length > 1 && parts[0].equals("www")) {
            String type = parts[1];
            web.setType(type);
        }
    }

    @Override
    public void buildSummary(WebsiteInformation web) {
        Elements paragraphs = doc.select("#content p");
        if (paragraphs.size() > 1) {
            Element secondParagraph = paragraphs.get(1);
            String summaryText = secondParagraph.text();
            web.setSummary(summaryText);
        } else {
            System.out.println("Second <p> tag not found in content.");
        }
    }

    @Override
    public void buildDetail(WebsiteInformation web) {
        Elements elements = doc.select("#content");
        web.setDetailed(elements.text());
    }

    @Override
    public void buildCreationDate(WebsiteInformation web) {
        Elements dateElements = doc.select("div.md\\:text-xs.md\\:leading-15p.text-10.leading-13p.opacity-100.md\\:opacity-90.font-450px.md\\:font-medium.text-white.mb-1.whitespace-nowrap.overflow-ellipsis");
        if (dateElements.size() > 1) {
            Element dateElement = dateElements.get(1);
            String dateText = dateElement.text();
            web.setCreationDate(dateText);
        } else {
            System.out.println("Second date element not found.");
        }
    }


    @Override
    public void buildAssociated(WebsiteInformation web) {

    }

    @Override
    public void buildAuthor(WebsiteInformation web) {
        Element element = doc.select("a[href*=/blog/author/]").first();
        if (element != null) {
            web.setAuthor(element.text());
        }
    }

    @Override
    public void buildCategory(WebsiteInformation web) {

    }
}
