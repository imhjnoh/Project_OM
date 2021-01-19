package main.sceneController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class map {

    @FXML
    private Label player_token;
    @FXML
    private Label btn_exit;

    public void setLocation(int sceneNo) {
        switch (sceneNo) {
            case 0:
            case 1:
                System.out.println("Invalid access to map");
                System.out.println("No map is able to show at the moment");
            case 2:
                player_token.setTranslateX(400);
                player_token.setTranslateY(300);
            default:
        }
    }

    public void exitButtonOnAction(MouseEvent event){
//        Stream<Window> open = Stage.getWindows().stream().filter(Window::isShowing);
//        System.out.println(Arrays.toString(open.toArray()));

        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }

}
