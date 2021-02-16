package main.Managers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.info.ISS;
import main.info.Item;
import main.info.Player;
import main.sceneController.scene_00;
import main.sceneController.scene_01;
import main.sceneController.scene_02;

import java.io.IOException;
import java.util.ArrayList;

/*
    원하는 씬을 로드하는 씬로더

    < 파라미터 설명 >
    - ISS iss                       : 다음 씬으로 넘겨야 하는 ISS
    - Player p                      : 다음 씬으로 넘겨야 하는 플레이어
    - ArrayList<Item> curr_items    : 다음 씬으로 넘겨야 하는 curr_items 리스트
    - Node node                     : 현재 씬의 윈도우를 구하기 위한 노드. 현재 씬 상의 모든 id가 있는 요소를 사용 가능하나,
                                      명확성을 위해 다음 씬으로 넘어가게 하는 트리거 요소를 넘긴다.
    - String fxmlLoc                : fxml 파일의 위치 String
    - int sceneNo                   : 다음 씬의 숫자

    < 호출 예시 > - scene_01.java
    new LoadScene(iss, player, curr_items, event_01, "../../fxml/scene_02.fxml", 2);

    < 유지 관리 >
    아래와 같이 N번째 씬이 추가될 때마다 else if 블록의 추가가 필요함.
    else if(sceneNo == N){
            scene_0N controller = loader.<scene_0N>getController();
            controller.initPlayer(p);
        }

     */

public class LoadScene {

    public LoadScene(ISS iss, Player p, ArrayList<Item> curr_items, Node node, String fxmlLoc, int sceneNo) throws IOException {
        p.setInventory(curr_items);

        Parent root;
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlLoc));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        if (sceneNo == 0){
            scene_00 controller = loader.<scene_00>getController();
        }else if(sceneNo == 1){
            scene_01 controller = loader.<scene_01>getController();
            controller.initPlayer(p);
            controller.initISS(iss);
        }else if(sceneNo == 2){
            scene_02 controller = loader.<scene_02>getController();
            controller.initPlayer(p);
//            controller.initISS(iss);
        }

        stage.show();
    }
}
