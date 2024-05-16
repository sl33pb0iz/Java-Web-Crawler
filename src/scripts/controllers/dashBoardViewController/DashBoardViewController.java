package src.scripts.controllers.dashBoardViewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;

public class DashBoardViewController {
    @FXML private BorderPane borderPane;
    @FXML private VBox menuBar;

    public void initialize() {

    }

    private <T> T loadView(URL url) {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            root = fxmlLoader.load();
            return fxmlLoader.getController();
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
        finally {
            borderPane.setCenter(root);
        }
    }

    private void showCrawlDataView(){

    }

    private void showSearchView(){

    }

    private void showSortOrderOfAlgorithms(){

    }
}
