package src.scripts.models;

import src.scripts.controllers.jsonInformationBuilder.*;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlServices {
    private ArrayList<WebCrawlController> crawlBuilders = new ArrayList<WebCrawlController>();

    public CrawlServices(){
        WebCrawlController blochainComBuilder = new BlockChainComController();
        WebCrawlController wikipediaCrawlController = new WikipediaCrawlController();
        WebCrawlController investopediaComController = new InvestopediaComController();
        WebCrawlController coindeskController = new CoindeskController();

        crawlBuilders.add(blochainComBuilder);
        crawlBuilders.add(wikipediaCrawlController);
        crawlBuilders.add(investopediaComController);
        crawlBuilders.add(coindeskController);
    }

    public void crawl() throws IOException {
        for (var webCrawlBuilder: crawlBuilders) {
            webCrawlBuilder.readDataFromFile();
        }
    }
}
