package src.scripts;

import src.scripts.controllers.UpgradComBuilder;
import src.scripts.controllers.WebCrawlController;
import src.scripts.controllers.WikipediaCrawlController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<WebCrawlController> webCrawlControllers = new ArrayList<>(8);

    public static void main(String[] args) throws IOException {
        WebCrawlController crawler = new UpgradComBuilder();
        WebCrawlController crawler1 = new WikipediaCrawlController();

        crawler.readDataFromFile();
    }
}
