package src.scripts;

import src.scripts.controllers.BlockChainComController;
import src.scripts.controllers.WebCrawlController;
import src.scripts.controllers.WikipediaCrawlController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Nên tạo các tham chiếu là WebCrawlController, sau đó ta có thể chứa trong list và gọi
        // Không cần quan tâm cụ thể từng đối tượng của tham chiếu thuộc loại nào
        // Chỉ quan tâm có thể làm gì
        WebCrawlController crawler = new WikipediaCrawlController();
        WebCrawlController crawler1 = new BlockChainComController();
        crawler.readDataFromFile();
        crawler1.readDataFromFile();
    }
}
