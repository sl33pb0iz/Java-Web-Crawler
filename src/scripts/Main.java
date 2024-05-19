package src.scripts;

import src.scripts.controllers.jsonInformationBuilder.*;
import src.scripts.controllers.jsonToObject.WebInformationService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WebCrawlController blochainComBuilder = new BlockChainComController();
        WebCrawlController WikipediaCrawlController = new WikipediaCrawlController();
        WebCrawlController InvestopediaComController = new InvestopediaComController();
        WebCrawlController CoindeskController = new CoindeskController();
        WebInformationService WS = new WebInformationService();

        blochainComBuilder.readDataFromFile();
        WikipediaCrawlController.readDataFromFile();
        InvestopediaComController.readDataFromFile();
        CoindeskController.readDataFromFile();
        WS.readDataFromJsonFile();
    }
}
