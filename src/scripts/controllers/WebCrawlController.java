package src.scripts.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebCrawlController {
    public void ReadDataFromFile(String linkFile) throws IOException {
        // File path is passed as parameter
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

    public void CrawlDataFrom(String url) throws IOException {

    }
}
