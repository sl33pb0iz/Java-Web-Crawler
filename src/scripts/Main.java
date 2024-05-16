package src.scripts;

import src.scripts.controllers.BlockChainComController;
import src.scripts.controllers.UpgradComBuilder;
import src.scripts.controllers.WebCrawlController;
import src.scripts.controllers.WikipediaCrawlController;
import src.scripts.controllers.InvestopediaComController;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<WebCrawlController> webCrawlControllers = new ArrayList<>(8);

    public static void main(String[] args) throws IOException {
        WebCrawlController crawler = new UpgradComBuilder();
        WebCrawlController crawler1 = new WikipediaCrawlController();
        WebCrawlController crawler2 = new BlockChainComController();
        WebCrawlController crawler3 = new InvestopediaComController();
        crawler.readDataFromFile();
        crawler1.readDataFromFile();
        crawler2.readDataFromFile();
        crawler3.readDataFromFile();
    }
}
