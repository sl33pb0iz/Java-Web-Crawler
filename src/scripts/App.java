package src.scripts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.scripts.controllers.dashBoardViewController.DashBoardViewController;
import src.scripts.views.dashBoardView.DashBoardView;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../resources/fxml/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1315, 810);

        DashBoardView view = fxmlLoader.getController();
        DashBoardViewController controller = new DashBoardViewController(view);

        view.initialize();

        stage.setTitle("WEB CRAWLER");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
