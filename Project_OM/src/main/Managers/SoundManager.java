package main.Managers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class SoundManager {

    private MediaPlayer mediaPlayer;

    public SoundManager(String sound_code) throws IOException, ParseException {
        mediaPlayer = new MediaPlayer(FileLoader(JSONLoader(sound_code)));
    }

    public Media FileLoader(String source){
        String musicFile = source;     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        return sound;
    }

    public void PlaySound(){
        mediaPlayer.play();
    }
    public void StopSound(){
        mediaPlayer.stop();
    }


    public String JSONLoader(String sound_code) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        Object object = parser.parse(new FileReader("./src/etc/soundList.json"));
        JSONObject soundList = (JSONObject)object;
        JSONObject soundObject = (JSONObject) soundList.get(sound_code);
        String source = (String) soundObject.get("source");

        return source;



//        JSONArray sound = (JSONArray)soundList.json.get("items");
//
//        Iterator<JSONObject> iterator = post.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next().get("itemNo"));
//        }

    }
}
