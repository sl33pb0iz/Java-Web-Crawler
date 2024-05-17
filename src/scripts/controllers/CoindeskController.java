package src.scripts.controllers;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

import java.net.MalformedURLException;
import java.net.URL;

public class CoindeskController extends WebCrawlController{
    @Override
    public String getlinkFileCategory() {
        return "C:\\Users\\mhung\\OneDrive\\ドキュメント\\GitHub\\Java-Web-Crawler\\src\\resources\\jsonData\\CoindeskJ";
    }

    @Override
    public String getLinkFile() {
        return "C:\\Users\\mhung\\OneDrive\\ドキュメント\\GitHub\\Java-Web-Crawler\\src\\resources\\url\\CoindeskUrl";
    }

    @Override
    public void buildTitle(WebsiteInformation web) {
        Elements elements = doc.select(".typography__StyledTypography-sc-owin6q-0.kbFhjp");
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
        try {
            URL url = new URL(currentUrl);
            String host = url.getHost();
            String[] parts = host.split("\\.");
            if (parts.length > 1) {
                String type = parts[parts.length - 2]; // Get the second last part of the host
                web.setType(type);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildSummary(WebsiteInformation web) {
        Elements paragraphs = doc.select("h2.typography__StyledTypography-sc-owin6q-0.sVcXY");
        if (!paragraphs.isEmpty()) {
            Element firstParagraph = paragraphs.get(0);
            String summaryText = firstParagraph.text();
            web.setSummary(summaryText);
        } else {
            System.out.println("<h2> tag with specified classes not found.");
        }
    }

    @Override
    public void buildDetail(WebsiteInformation web) {
        Elements elements = doc.select("div.typography__StyledTypography-sc-owin6q-0.eycWal p");
        web.setDetailed(elements.text());
    }
    @Override
    public void buildCreationDate(WebsiteInformation web) {
        Elements dateElements = doc.select("span.typography__StyledTypography-sc-owin6q-0.iOUkmj");
        if (!dateElements.isEmpty()) {
            Element dateElement = dateElements.get(0);
            String dateText = dateElement.text();
            web.setCreationDate(dateText);
        } else {
            System.out.println("Date element not found.");
        }
    }


    @Override
    public void buildAssociated(WebsiteInformation web) {

    }

    @Override
    public void buildAuthor(WebsiteInformation web) {
        Element element = doc.select("span.typography__StyledTypography-sc-owin6q-0.hirYAs a").first();
        if (element != null) {
            web.setAuthor(element.text());
        }
    }

    @Override
    public void buildCategory(WebsiteInformation web) {

    }
}
