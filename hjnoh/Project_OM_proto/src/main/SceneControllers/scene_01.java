package main.SceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.Player;

public class scene_01 {
    @FXML
    private Label btn_exit, item_slot_1;
    @FXML
    private Button btn_item1;

    // 졸려서 아주 약식으로 박아버림.. 아이템은 버튼리스트로 만들어서 셋온액션을 아이템온액션으로 하면 될 것 같다
    // buttonList[i].setOnAction(event -> checkId((Button) event.getSource()));
    public void itemButtonOnAction(ActionEvent e){
//        BackgroundImage item1_image = new BackgroundImage(new Image("./images/item_chip.png",32,32,false,true), BackgroundRepeat.NO_REPEAT, BackgroundSize.AUTO);

        BackgroundImage backgroundImage = new BackgroundImage( new Image("./images/item_chip.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);

        item_slot_1.setBackground(background);
    }

    public void exitOnAction(MouseEvent e){
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }
}
