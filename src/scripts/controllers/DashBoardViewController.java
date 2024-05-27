package src.scripts.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import src.scripts.App;
import src.scripts.action.IAction;
import src.scripts.models.CrawlService.WebCrawlServices;
import src.scripts.models.InformationService.WebInformationService;
import src.scripts.models.SearchService.AlgorithmServices;
import src.scripts.views.CrawlDataView;
import src.scripts.views.DashBoardView;

import java.io.IOException;
import java.net.URL;

public class DashBoardViewController {
    private DashBoardView view;
    private WebInformationService webInformationService;
    private AlgorithmServices algorithmServices;
    private WebCrawlServices crawlServices;

    public DashBoardViewController(DashBoardView view){
        this.view = view;
        webInformationService = new WebInformationService();
        algorithmServices = new AlgorithmServices();
        crawlServices = new WebCrawlServices();

        IAction onClickedCrawlDataButton = () ->{
            showCrawlView();
        };
        view.onClickedCrawlDataButton = onClickedCrawlDataButton;
    }

    private <T> T loadView(URL url) {
        Parent root = null;
        T controller = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            root = fxmlLoader.load();
            controller = fxmlLoader.getController();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (root != null) {
            view.borderPane.setCenter(root);
        }
        return controller;
    }

    private void showCrawlView() throws IOException {
        crawlServices.crawl();
        URL crawlViewUrl = App.class.getResource("../resources/fxml/crawlDataView.fxml");
        if (crawlViewUrl != null) {
            CrawlDataView view = loadView(crawlViewUrl);
            CrawlDataController controller = new CrawlDataController(view, webInformationService, algorithmServices);

            view.initialize();
        } else {
            System.out.println("Could not find FXML file for CrawlDataView");
        }
    }

}
