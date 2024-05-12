package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.ArticleTypeEnum;
import src.scripts.models.WebsiteInformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebCrawlController {
    public void ReadDataFromFile() throws IOException {
        // File path is passed as parameter
        File file = new File(
                "D:\\Java\\New folder\\Java-Web-Crawler\\src\\resources\\BlockChainUrl");

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        List<String> urlsToCrawl = new ArrayList<>();

        try (br) {
            String line;
            while ((line = br.readLine()) != null) {
                urlsToCrawl.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String url : urlsToCrawl) {
            CrawlDataFrom(url);
        }
    }

    public void CrawlDataFrom(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select(".mw-content-container");

        WebsiteInformation web = new WebsiteInformation();
        web.setTitle(elements.select(".mw-page-title-main").text());
        web.setDetailed(elements.select("p").text());
        ArticleTypeEnum articleType = ArticleTypeEnum.fromUrl(url);
        web.setType(articleType);

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }
}
