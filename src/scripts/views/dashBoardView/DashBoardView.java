package src.scripts.views.dashBoardView;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import src.scripts.action.IAction;

import java.io.IOException;

public class DashBoardView {
    public IAction onClickedCrawlDataButton;
    public IAction onClickedExitButton;

    public Button crawlFeatureButton;
    public Button orderOfAlgorithmsFeature;
    public Button exitFeature;
    public BorderPane borderPane;

    public void initialize() {
        crawlFeatureButton.setOnAction(event -> {
            try {
                onClickedCrawlDataButton.onAction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }




}
