package src.scripts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/dashBoardView/dashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1315, 810);

        stage.setTitle("WEB CRAWLER");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
