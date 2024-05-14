package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import src.scripts.models.WebsiteInformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class WebCrawlController {
    public void readDataFromFile() throws IOException {
        File file = new File(getLinkFile());

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        List<String> urlsToCrawl = new ArrayList<>();

        try (br) {
            String line;
            while ((line = br.readLine()) != null) {
                urlsToCrawl.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for (String url : urlsToCrawl) {
            crawlDataFrom(url);
        }
    }

    public void crawlDataFrom(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select(getContainer());

        WebsiteInformation web = buildWebsiteInformation(elements);

        Gson gson = new Gson();
        String Json = gson.toJson(web);
        System.out.println(Json);
    }

    // Override phương thức này để trả về đường link
    public abstract String getLinkFile();

    // Override phương thức này để trả về container nơi chứa các thuộc tính cần lấy
    public abstract String getContainer();

    // Override phương thức này để build ra class websiteinformation
    // và cho nó sẽ gọi tới cái build bên dưới để build ra từng thuộc tính
    public abstract WebsiteInformation buildWebsiteInformation(Elements elements);

    // Các phương thức bên dưới sẽ lấy các giá trị từ link website
    // và thực hiện các tính toán, thay đổi để set thông tin cho websiteinformation class
    public abstract void buildTitle(WebsiteInformation web);
    public abstract void buildLink(WebsiteInformation web);
    public abstract void buildSource(WebsiteInformation websiteInformation);
    public abstract void buildType(WebsiteInformation web);
    public abstract void buildSummary(WebsiteInformation web);
    public abstract void buildDetail(WebsiteInformation web);
    public abstract void buildCreationDate(WebsiteInformation web);
    public abstract void buildAssociated(WebsiteInformation web);
    public abstract void buildAuthor(WebsiteInformation web);
    public abstract void buildCategory(WebsiteInformation web);
}
