package src.scripts.controllers.jsonInformationBuilder;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import src.scripts.models.WebsiteInformation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class WebCrawlController {
    protected Document doc;
    protected String currentUrl;

    public String getlinkFileCategory(WebsiteInformation web) {
        String a = web.getCategory();
        if(a == "BlockchainJobs") return "C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\datas\\jsonData\\BlockchainJobs";
        if (a == "DefinitionOfBlockchain") return "C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\datas\\jsonData\\DefinitionOfBlockchain";
        if (a == "FactsAboutBlockchain") return "C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\datas\\jsonData\\FactsAboutBlockchain";
        if (a == "NewsArticleBlockchain") return "C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\datas\\jsonData\\NewsArticleBlockchain";
        return "C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\datas\\jsonData\\Other";
    }
    public abstract String getLinkFile();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String url : urlsToCrawl) {
            WebsiteInformation web = buildWebsiteInformation(url);
            FileWriter writer = new FileWriter(getlinkFileCategory(web),true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(crawlDataFrom(web));
            bw.newLine();
            bw.close();
        }
    }

    public String crawlDataFrom(WebsiteInformation web) throws IOException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(web);
        return jsonList;
    }

    // Override phương thức này để trả về đường link
    public WebsiteInformation buildWebsiteInformation(String url) throws IOException {
        currentUrl = url;
        doc = Jsoup.connect(currentUrl).get();

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

    // Override phương thức này để build ra class websiteinformation
    // và cho nó sẽ gọi tới cái build bên dưới để build ra từng thuộc tính

    // Các phương thức bên dưới sẽ lấy các giá trị từ link website
    // và thực hiện các tính toán, thay đổi để set thông tin cho websiteinformation class
    public abstract void buildTitle(WebsiteInformation web);
    public abstract void buildLink(WebsiteInformation web);
    public abstract void buildSource(WebsiteInformation webs);
    public abstract void buildType(WebsiteInformation web);
    public abstract void buildSummary(WebsiteInformation web);
    public abstract void buildDetail(WebsiteInformation web);
    public abstract void buildCreationDate(WebsiteInformation web);
    public abstract void buildAssociated(WebsiteInformation web);
    public abstract void buildAuthor(WebsiteInformation web);
    public abstract void buildCategory(WebsiteInformation web);
}
