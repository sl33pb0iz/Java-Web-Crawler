package src.scripts.models;

import src.scripts.controllers.jsonInformationBuilder.*;

import java.io.IOException;

public class CrawlServices {
    public void crawl() throws IOException {
        WebCrawlController blochainComBuilder = new BlockChainComController();
        WebCrawlController wikipediaCrawlController = new WikipediaCrawlController();
        WebCrawlController investopediaComController = new InvestopediaComController();
        WebCrawlController coindeskController = new CoindeskController();

        blochainComBuilder.readDataFromFile();
        wikipediaCrawlController.readDataFromFile();
        investopediaComController.readDataFromFile();
        coindeskController.readDataFromFile();
    }
}
