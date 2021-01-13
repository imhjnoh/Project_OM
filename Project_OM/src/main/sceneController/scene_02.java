package main.sceneController;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.info.Item;
import main.info.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class scene_02 {
    @FXML
    private Label btn_exit, item_slot_1, item_slot_2, item_slot_3, item_slot_4, item_slot_5, item_01, item_02, event_01, lbl_script;
    private Label[] item_slot;
    @FXML
    private ProgressBar bar_sleep = new ProgressBar();
    @FXML
    private ProgressBar bar_hungry, bar_health, bar_temperature, bar_injury;
    @FXML
    private ImageView mapIcon;
    @FXML
    private ImageView ISSMAP;

    private ArrayList<Item> curr_items = new ArrayList<Item>();
    public Queue script = new LinkedList();
    private static MediaPlayer mediaPlayer;
    private static MediaPlayer mp_sfx;


    public Player player;

    @FXML
    void initialize(){
        initItemArray();
    }
    void initItemArray(){
        item_slot = new Label[5];
        item_slot[0] = item_slot_1;
        item_slot[1] = item_slot_2;
        item_slot[2] = item_slot_3;
        item_slot[3] = item_slot_4;
        item_slot[4] = item_slot_5;

    }

    void changeInvent(){
        int itr = 0;
        try{
            if(!curr_items.isEmpty()){
                for(Item i: curr_items){

                    item_slot[itr].setOpacity(1.0);
//                    item_slot[itr].setDisable(false);
                    BackgroundImage backgroundImage = new BackgroundImage( new Image(i.getName()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                    Background background = new Background(backgroundImage);
                    item_slot[itr].setBackground(background);

                    itr++;
                    System.out.print("*");

                }
            }
            System.out.println("-");
        }catch (Exception e){

        }
        return;

    }



    public scene_02() {

        String path = OMstoryController.class.getResource("").getPath();

        String musicFile = "src/etc/bensound-ofeliasdream.mp3";     // For example

//        Media sound = new Media(new File(musicFile).toURI().toString());
//        mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();

        /*

         */
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("src/etc/scene_02.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                script.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 졸려서 아주 약식으로 박아버림.. 아이템은 버튼리스트로 만들어서 셋온액션을 아이템온액션으로 하면 될 것 같다
    // buttonList[i].setOnAction(event -> checkId((Button) event.getSource()));
    public void itemLabelOnClick(MouseEvent e){
//        BackgroundImage item1_image = new BackgroundImage(new Image("./images/item_chip.png",32,32,false,true), BackgroundRepeat.NO_REPEAT, BackgroundSize.AUTO);

//        System.out.println(e.getPickResult().getIntersectedNode().getId());
        Label temlabel = (Label) e.getSource();
        String id = temlabel.getId();
        if(id.equals("item_01") ){

            temlabel.setOpacity(0.0);
            temlabel.setDisable(true);
            curr_items.add(new Item("./imgs/item_coin.png",0,0));
            System.out.println("01");

        }else if(id.equals("item_02")){


            temlabel.setOpacity(0.0);
            temlabel.setDisable(true);
            curr_items.add(new Item("./imgs/item_chip.png",0,0));

        }

        Media sfx = new Media(new File("src/etc/Glitch-button-short-sound-effect.mp3").toURI().toString());
        mp_sfx = new MediaPlayer(sfx);
        mp_sfx.play();


        changeInvent();




//        BackgroundImage backgroundImage = new BackgroundImage( new Image("./imgs/item_chip.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//        Background background = new Background(backgroundImage);
//
//        itmlabel.setBackground(background);
    }

    public void exitOnAction(MouseEvent e){
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }

    public void eventLabelOnClick(MouseEvent e) throws IOException {
        Parent root;
        Stage stage = (Stage) event_01.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../../fxml/scene_02.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void scriptLabelOnClick(MouseEvent e){
        String curr_script = (String) script.poll();
        String sfx_file = new String();

        if(curr_script == null || curr_script.isEmpty() || curr_script == "\n"){
            lbl_script.setOpacity(0.0);
            lbl_script.setDisable(true);
            return;
        }
        else if(curr_script.startsWith("[a]")){
            sfx_file = "src/etc/Glitch-button-short-sound-effect.mp3";
            lbl_script.setTextFill(Color.SKYBLUE);
            curr_script = curr_script.substring(3);
        }else if(curr_script.startsWith("[om]")){
            sfx_file = "src/etc/Error-sound-effect.mp3";
            lbl_script.setTextFill(Color.WHITE);
            curr_script = curr_script.substring(4);
        }

        // 사운드 효과 실행
        if(sfx_file.isEmpty()!=true){
            Media sfx = new Media(new File(sfx_file).toURI().toString());
            mp_sfx = new MediaPlayer(sfx);
            mp_sfx.play();
        }

        lbl_script.setText(curr_script);


    }

    public void mapIconClicked(MouseEvent e) {
        if (ISSMAP.isVisible()) {
            ISSMAP.setVisible(false);
        } else {
            ISSMAP.setVisible(true);
        }
    }

    //아...............게임엔개발팀의애정혹은돈에의한뭐시기가담긴거구나....

}
