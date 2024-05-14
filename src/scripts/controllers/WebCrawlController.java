package src.scripts.controllers;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import src.scripts.models.WebsiteInformation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class WebCrawlController {
    private List<WebsiteInformation> websiteList = new ArrayList<>();

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

    protected Document doc;
    protected String currentUrl;

    public void crawlDataFrom(String url) throws IOException {
        currentUrl = url;
        doc = Jsoup.connect(currentUrl).get();

        WebsiteInformation web = buildWebsiteInformation();
        websiteList.add(web);

        Gson gson = new Gson();
        String jsonList = gson.toJson(websiteList);

        try (FileWriter writer = new FileWriter("D:\\Java\\New folder\\Java-Web-Crawler\\src\\resources\\jsonData\\UpgradJSON")) {
            writer.write(jsonList);
        }

    }

    // Override phương thức này để trả về đường link
    public abstract String getLinkFile();

    // Override phương thức này để build ra class websiteinformation
    // và cho nó sẽ gọi tới cái build bên dưới để build ra từng thuộc tính
    public abstract WebsiteInformation buildWebsiteInformation();

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
