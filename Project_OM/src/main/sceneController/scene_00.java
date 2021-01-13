package main.sceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.info.ISS;
import main.info.Items;
import main.info.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class scene_00 implements Initializable {

    @FXML
    private Button quitButton;
    @FXML
    private Button startButton;
    @FXML
    private Button openButton;
    @FXML
    private Button albumButton;
    @FXML
    private Button settingButton;
    @FXML
    private Label title_exit, title_newgame;

    public void startButtonOnAction(ActionEvent event) throws Exception {
        newGame();
    }

    public void newGame() throws Exception{
        Player player = new Player();
        ISS iss = new ISS();
        Items items = new Items();

        Stage stage = (Stage) startButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("./fxml/scene_01.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openButtonOnAction(ActionEvent event) {

    }

    public void albumButtonOnAction(ActionEvent event) {

    }

    public void settingButtonOnAction(ActionEvent event) {

    }

    public void quitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    // 주의!! 버튼이 아닌 라벨은 ActionEvent가 아니라 MouseEvent다.
    public void exitButtonOnAction(MouseEvent event){
        Stage stage = (Stage) title_exit.getScene().getWindow();
        stage.close();
    }

    public void newGameOnAction(MouseEvent e) throws IOException {
//        Player player = new Player("Administrator", new int[]{5, 5, 5, 5, 5}, new int[]{0, 0, 0, 0, 0});
        Player player = new Player(100,50,100,100,100,1,
                new ArrayList());

        Parent root;
        Stage stage = (Stage) title_newgame.getScene().getWindow();
//        root = FXMLLoader.load(getClass().getResource("../../fxml/scene_01.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/scene_01.fxml"));
        // pass player parameter to controller
        root = loader.load();

        scene_01 controller = loader.<scene_01>getController();
        controller.initPlayer(player);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
