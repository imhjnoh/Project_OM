package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.package1.ISS;
import sample.package1.Items;
import sample.package1.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class OMstartController implements Initializable {

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

    public void startButtonOnAction(ActionEvent event) throws Exception {
        newGame();
    }

    public void newGame() throws Exception{
        Player player = new Player();
        ISS iss = new ISS();
        Items items = new Items();

        Stage stage = (Stage) startButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/OMstory.fxml"));

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
