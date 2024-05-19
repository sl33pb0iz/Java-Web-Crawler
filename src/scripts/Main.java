package src.scripts;

import src.scripts.controllers.jsonInformationBuilder.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WebCrawlController blochainComBuilder = new BlockChainComController();
        WebCrawlController WikipediaCrawlController = new WikipediaCrawlController();
        WebCrawlController InvestopediaComController = new InvestopediaComController();
        WebCrawlController frontiersinOrgController1 = new FrontiersinOrgController();

        blochainComBuilder.readDataFromFile();
        WikipediaCrawlController.readDataFromFile();
        InvestopediaComController.readDataFromFile();
        frontiersinOrgController1.readDataFromFile();
    }
}
