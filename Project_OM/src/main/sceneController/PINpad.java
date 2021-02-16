package main.sceneController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PINpad {

    @FXML
    public Label no_1, no_2, no_3, no_4, no_5, no_6, no_7, no_8, no_9, no_0;
    private String input_pass = new String();
    @FXML
    private Label pass_slot;


    public void PINpadButtonOnClick(MouseEvent event) throws InterruptedException {
        Label clicked = (Label) event.getSource();
        String clicked_id = clicked.getId().toString();

        switch (clicked_id){
            case "no_1":
                input_pass+="1";
                break;
            case "no_2":
                input_pass+="2";
                break;
            case "no_3":
                input_pass+="3";
                break;
            case "no_4":
                input_pass+="4";
                break;
            case "no_5":
                input_pass+="5";
                break;
            case "no_6":
                input_pass+="6";
                break;
            case "no_7":
                input_pass+="7";
                break;
            case "no_8":
                input_pass+="8";
                break;
            case "no_9":
                input_pass+="9";
                break;
            case "no_0":
                input_pass+="0";
                break;
        }

        System.out.println(input_pass);

        changeLabel(input_pass);

        if(input_pass.length()==4){
            Thread.sleep(1000);
            Stage stage = (Stage) pass_slot.getScene().getWindow();
            stage.close();
        }




    }

    public void changeLabel (String input_pass){
        switch (input_pass.length()){
            case 1:
                pass_slot.setText("* _ _ _");
                break;
            case 2:
                pass_slot.setText("* * _ _");
                break;
            case 3:
                pass_slot.setText("* * * _");
                break;
            case 4:
                pass_slot.setText("* * * *");
                break;
        }
    }
}
