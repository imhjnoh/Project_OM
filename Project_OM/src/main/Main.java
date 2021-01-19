package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Managers.ItemManager;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        System.setProperty("prism.lcdtext", "false"); // 폰트 안티앨리어싱
        Font.loadFont(getClass().getResourceAsStream("../etc/SairaStencilOne-Regular.ttf"), 40);



        Parent root = FXMLLoader.load(getClass().getResource("../fxml/title.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception{

        ItemManager itemManager = new ItemManager();
        itemManager.parseJson();

        launch(args);

    }
}
