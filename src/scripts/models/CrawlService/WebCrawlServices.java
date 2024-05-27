package src.scripts.models.CrawlService;

import src.scripts.models.CrawlService.jsonInformationBuilder.*;

import java.io.IOException;
import java.util.ArrayList;

public class WebCrawlServices {
    private ArrayList<WebInformationBuilder> crawlBuilders = new ArrayList<WebInformationBuilder>();

    public WebCrawlServices(){
        WebInformationBuilder blochainComBuilder = new BlockChainComBuilder();
        WebInformationBuilder wikipediaCrawlController = new WikipediaCrawlBuilder();
        WebInformationBuilder investopediaComController = new InvestopediaComBuilder();
        WebInformationBuilder coindeskController = new CoindeskBuilder();

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
