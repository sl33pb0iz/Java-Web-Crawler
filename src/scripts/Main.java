package src.scripts;

import src.scripts.controllers.BlockChainComController;
import src.scripts.controllers.WebCrawlController;
import src.scripts.controllers.WikipediaCrawlController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WikipediaCrawlController crawler = new WikipediaCrawlController();
        crawler.ReadDataFromFile();
        BlockChainComController crawler1 = new BlockChainComController();
        crawler1.ReadDataFromFile();
    }
}
