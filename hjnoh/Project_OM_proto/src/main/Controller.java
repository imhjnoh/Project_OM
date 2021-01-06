package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Label title_exit, title_newgame;


    // 주의!! 버튼이 아닌 라벨은 ActionEvent가 아니라 MouseEvent다.
    public void exitButtonOnAction(MouseEvent event){
        Stage stage = (Stage) title_exit.getScene().getWindow();
        stage.close();
    }

    public void newGameOnAction(MouseEvent e) throws IOException {
        Player player = new Player("Administrator", new int[]{5, 5, 5, 5, 5}, new int[]{0, 0, 0, 0, 0});
        Parent root;
        Stage stage = (Stage) title_newgame.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../landscape/scene_01.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //냠

    }
}
