package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

import java.io.IOException;

public class WikipediaCrawlController extends WebCrawlController {
    public void ReadDataFromFile() throws IOException{
        super.readDataFromFile("C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\resources\\WikipediaUrl");
    }

    Document doc;
    Elements elements;

    @Override
    public void CrawlDataFrom(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        elements = doc.select(".mw-page-container");

        WebsiteInformation web = new WebsiteInformation();

        setType(web);
        setDetail(web);
        setAssociated(web);
        setCategory(web);
        setCreationDate(web);
        setAuthor(web);
        setSummary(web);
        setLink(web);
        setSource(web);
        setCategory(web);

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }

    @Override
    public void setLink(WebsiteInformation web) {
    }

    @Override
    public void setSource(WebsiteInformation websiteInformation) {

    }

    @Override
    public void setType(WebsiteInformation web) {
    }

    @Override
    public void setSummary(WebsiteInformation web) {

    }

    @Override
    public void setDetail(WebsiteInformation web) {

    }

    @Override
    public void setCreationDate(WebsiteInformation web) {

    }

    @Override
    public void setAssociated(WebsiteInformation web) {

    }

    @Override
    public void setAuthor(WebsiteInformation web) {

    }

    @Override
    public void setCategory(WebsiteInformation web) {

    }
}
