package main.sceneController;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.Managers.LoadScene;
import main.Managers.SoundManager;
import main.info.ISS;
import main.info.Item;
import main.info.Player;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class scene_01 {
    @FXML
    private Label btn_exit, item_slot_1, item_slot_2, item_slot_3, item_slot_4, item_slot_5, item_01, item_02, event_01, lbl_script;
    private Label[] item_slot;
    @FXML
    private ProgressBar bar_sleep = new ProgressBar();
    @FXML
    private ProgressBar bar_hungry, bar_health, bar_temperature, bar_injury;
    @FXML
    private AnchorPane intro;
    private ArrayList<Item> curr_items = new ArrayList<Item>();
    public Queue script = new LinkedList();
    private static MediaPlayer mediaPlayer;
    private static MediaPlayer mp_sfx;

    private SoundManager BGM;


    public Player player;
    public ISS iss;

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
    public void initISS(ISS iss_param){
        iss = iss_param;
    }
    public void initPlayer(Player player_param){
        // OMstartController에서 받아온 player를 할당.
        player = player_param;
        // player의 상태 param으로 초기화.
        bar_sleep.setProgress(player.getSleep() * 0.01);
        bar_hungry.setProgress(player.getHungry() * 0.01);
        bar_health.setProgress(player.getHealth() * 0.01);
        bar_temperature.setProgress(player.getTemperature() * 0.01);
        bar_injury.setProgress(player.getInjury() * 0.01);

//        curr_items = player_param.getInventory();

        int itr = 0;
        try{
            curr_items.addAll(player_param.getInventory());
            if(!curr_items.isEmpty()){
                for(Item i: curr_items){
                    BackgroundImage backgroundImage = new BackgroundImage( new Image(i.getName()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                    Background background = new Background(backgroundImage);
                    item_slot[itr].setBackground(background);
                    itr++;
                }
            }else{
                curr_items = new ArrayList<Item>();
            }
        }catch (Exception e){

        }

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



    public scene_01() throws IOException, ParseException {

        BGM = new SoundManager("main_bgm");
        BGM.PlaySound();

//        String path = scene_01.class.getResource("").getPath();
//
//        String musicFile = "src/etc/bensound-ofeliasdream.mp3";     // For example
//
//        Media sound = new Media(new File(musicFile).toURI().toString());
//        mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();

        /*

        */
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("src/script/scene_01.txt"));
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


//
//        player.setSleep(100);
//        player.setHungry(50);
//        player.setHealth(100);
//        player.setTemperature(100);
//        player.setInjury(100);



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

        new LoadScene(iss, player, curr_items, event_01, "../../fxml/scene_02.fxml", 2);


    }

    public void scriptLabelOnClick(MouseEvent e) throws IOException, ParseException {

        String curr_script = (String) script.poll();
        String sfx_file = new String();

        if(curr_script == null || curr_script.isEmpty() || curr_script == "\n"){
            lbl_script.setOpacity(0.0);
            lbl_script.setDisable(true);
            return;
        }else if(curr_script.startsWith("[a]")){
//            sfx_file = "src/etc/Glitch-button-short-sound-effect.mp3";
            lbl_script.setTextFill(Color.SKYBLUE);
            curr_script = curr_script.substring(3);
            new SoundManager("sfx_glitch_button").PlaySound();
        }else if(curr_script.startsWith("[om]")){
//            sfx_file = "src/etc/Error-sound-effect.mp3";
            lbl_script.setTextFill(Color.WHITE);
            curr_script = curr_script.substring(4);
            new SoundManager("sfx_system_sound").PlaySound();
        }else if(curr_script.startsWith("[m]")){
//            sfx_file = "src/etc/Error-sound-effect.mp3";
            lbl_script.setTextFill(Color.SKYBLUE);
            curr_script = curr_script.substring(3);
            new SoundManager("sfx_system_sound").PlaySound();
        }else if(curr_script.startsWith("[e]")){
//            sfx_file = "src/etc/Error-sound-effect.mp3";
            lbl_script.setTextFill(Color.SKYBLUE);
            curr_script = curr_script.substring(3);
            new SoundManager("sfx_system_sound").PlaySound();

            Parent root1;
            try {
                root1 = FXMLLoader.load(getClass().getClassLoader().getResource("./src/fxml/PINpad.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("My New Stage Title");
                stage.setScene(new Scene(root1, 486, 266));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();

                // Hide this current window (if this is what you want)
//                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException ev) {
                ev.printStackTrace();
            }
        }

        // 사운드 효과 실행
//        if(sfx_file.isEmpty()!=true){
//            Media sfx = new Media(new File(sfx_file).toURI().toString());
//            mp_sfx = new MediaPlayer(sfx);
//            mp_sfx.play();
//        }

        // 문제가 있다.. 중간에 누르면 동시에 실행된다. 메소드든 클래스든 따로 빼는 게 좋을듯
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        String finalCurr_script = curr_script;
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(.05),
                event -> {
                    if (i.get() > finalCurr_script.length()) {
                        timeline.stop();
                    } else {
                        lbl_script.setText(finalCurr_script.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

//        lbl_script.setText(curr_script);


    }

    public void introPressed(MouseEvent e){
        FadeTransition ft = new FadeTransition(Duration.millis(2000),intro);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
//        new Timeline(new KeyFrame(Duration.millis(0),
//                new KeyValue(intro.opacityProperty(),1)),
//                new KeyFrame(Duration.millis(2000),
//                        new KeyValue(intro.opacityProperty(),0)));
//
        intro.setDisable(true);

    }

    //아...............게임엔개발팀의애정혹은돈에의한뭐시기가담긴거구나....

}
