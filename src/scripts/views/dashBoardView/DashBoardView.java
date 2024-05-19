package src.scripts.views.dashBoardView;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import src.scripts.App;

import java.net.URL;

public class DashBoardView {

    public Button crawlFeatureButton;
    public Button searchFeatureButton;
    public Button orderOfAlgorithmsFeature;
    public Button exitFeature;
    public BorderPane borderPane;

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
            borderPane.setCenter(root);
        }
        return controller;
    }

    public void initialize() {
        crawlFeatureButton.setOnAction(event -> showCrawlView());
        searchFeatureButton.setOnAction(event -> showSearchView());
    }

    public void showCrawlView() {
        URL crawlViewUrl = App.class.getResource("../resources/fxml/crawlDataView.fxml");
        if (crawlViewUrl != null) {
            loadView(crawlViewUrl);
        } else {
            System.out.println("Could not find FXML file for CrawlDataView");
        }
    }

    public void showSearchView(){
        URL crawlViewUrl = App.class.getResource("../resources/fxml/crawlDataView.fxml");
        if (crawlViewUrl != null) {
            loadView(crawlViewUrl);
        } else {
            System.out.println("Could not find FXML file for CrawlDataView");
        }
    }
}
