package src.scripts;

import src.scripts.controllers.jsonInformationBuilder.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WebCrawlController blochainComBuilder = new BlockChainComController();
        WebCrawlController upgradComBuilder = new UpgradComBuilder();
        WebCrawlController investopediaBuilder = new InvestopediaComController();
        WebCrawlController wikipediaBuilder = new WikipediaCrawlController();
        WebCrawlController CoindeskController = new CoindeskController();


        blochainComBuilder.readDataFromFile();
        upgradComBuilder.readDataFromFile();
        investopediaBuilder.readDataFromFile();
        wikipediaBuilder.readDataFromFile();
        CoindeskController.readDataFromFile();
    }

}
