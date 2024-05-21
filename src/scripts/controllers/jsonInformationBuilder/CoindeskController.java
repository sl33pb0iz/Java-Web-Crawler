package src.scripts.controllers.jsonInformationBuilder;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import src.scripts.entities.CategoryEnum;
import src.scripts.entities.WebsiteInformation;
import java.net.MalformedURLException;
import java.net.URL;

public class CoindeskController extends WebCrawlController {

    @Override
    public String getLinkFile() {
        return "D:\\Java\\New folder\\Java-Web-Crawler\\src\\datas\\url\\CoindeskUrl";
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
    public void buildSource(WebsiteInformation web) {
        // Assuming that the source is the host of the current URL
        try {
            URL url = new URL(currentUrl);
            web.setSource(url.getHost());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void buildType(WebsiteInformation web) {
        // Assuming that the type is a fixed string for this controller
        String[] parts = currentUrl.split("/");
        if (parts.length > 1) {
            String type = parts[3]; // Get the second last part of the host
            web.setType(type);
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
        String summaryText = doc.select(".sc-1f19948b-6.gTWyeq").text() + doc.select(".sc-1f19948b-7.fWlASx").text();
        web.setCategory(CategoryEnum.CategoryClassify(summaryText).toString());
    }
}
