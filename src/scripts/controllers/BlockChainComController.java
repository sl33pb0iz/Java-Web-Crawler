package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

import java.io.IOException;

public class BlockChainComController extends WebCrawlController {

    public void ReadDataFromFile() throws IOException {
        super.readDataFromFile("C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\resources\\BlockchaincomUrl");
    }
    @Override
    public void CrawlDataFrom(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        elements = doc.select(".sc-5933466a-1.ecdyKA");

        WebsiteInformation web = new WebsiteInformation();
        setType(web);
        setLink(web, url);
        setSource(web);
        setSummary(web);
        setTitle(web);
        setDetail(web);
        setCreationDate(web);
        setAssociated(web);
        setAuthor(web);
        setCategory(web);

        // test pull
        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }

    @Override
    public void setLink(WebsiteInformation web, String url) {
        web.setLink(url);
    }

    @Override
    public void setSource(WebsiteInformation web) {
        web.setSource("");
    }

    @Override
    public void setType(WebsiteInformation web) {
        web.setType("blog");
    }

    @Override
    public void setSummary(WebsiteInformation web) {
        web.setSummary("");
    }

    @Override
    public void setTitle(WebsiteInformation web) {
        web.setTitle(elements.select(".sc-1f19948b-5.fOSzTG").text());
    }

    @Override
    public void setDetail(WebsiteInformation web) {
        web.setDetailed(elements.select(".sc-1f19948b-6.gTWyeq").text() + elements.select(".sc-1f19948b-7.fWlASx").text());
    }

    @Override
    public void setCreationDate(WebsiteInformation web) {
        web.setCreationDate(elements.select(".sc-cba31b2d-8.bEKtyJ").text());
    }

    @Override
    public void setAssociated(WebsiteInformation web) {
        web.setAssociated("");
    }

    @Override
    public void setAuthor(WebsiteInformation web) {
        web.setAuthor(elements.select(".sc-cba31b2d-7.gPdnYn").text());
    }

    @Override
    public void setCategory(WebsiteInformation web) {
        web.setCategory("");
    }
}
