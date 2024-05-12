package src.scripts;

import src.scripts.controllers.WebCrawlController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        WebCrawlController crawler = new WebCrawlController();
        crawler.ReadDataFromFile();

    }
}
