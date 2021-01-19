package main.Managers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class ItemManager {

    public ItemManager() throws Exception{
//        parseJson();
        System.out.println("ItemManager made");
    }

    public void parseJson() throws Exception {

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("./src/etc/itemList.json"));
        JSONObject jsonObject = (JSONObject)obj;
        JSONArray post = (JSONArray)jsonObject.get("items");
        Iterator<JSONObject> iterator = post.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().get("itemNo"));
        }

    }
}
