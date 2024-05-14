package src.scripts.controllers;

import src.scripts.models.WebsiteInformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class WebCrawlController {
    public void readDataFromFile(String linkFile) throws IOException {
        File file = new File(linkFile);

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
            CrawlDataFrom(url);
        }
    }

    public abstract void CrawlDataFrom(String url) throws IOException;
    public abstract void setLink(WebsiteInformation web);
    public abstract void setSource(WebsiteInformation websiteInformation);
    public abstract void setType(WebsiteInformation web);
    public abstract void setSummary(WebsiteInformation web);
    public abstract void setDetail(WebsiteInformation web);
    public abstract void setCreationDate(WebsiteInformation web);
    public abstract void setAssociated(WebsiteInformation web);
    public abstract void setAuthor(WebsiteInformation web);
    public abstract void setCategory(WebsiteInformation web);
}
