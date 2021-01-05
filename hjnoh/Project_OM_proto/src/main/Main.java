package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        System.setProperty("prism.lcdtext", "false"); // 폰트 안티앨리어싱
        Font.loadFont(getClass().getResourceAsStream("../etc/SairaStencilOne-Regular.ttf"), 40);

        Parent root = FXMLLoader.load(getClass().getResource("../landscape/title.fxml"));

        primaryStage.setTitle("OM");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
