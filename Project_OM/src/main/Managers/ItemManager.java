package main.Managers;

import main.info.Item;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ItemManager {

    private Item item;
    private String source;

    public ItemManager(String item_code) throws Exception {
        source = getItemSource(item_code);
        item = new Item(source);
    }

    public String getSource() { return source; }

    public String getItemSource(String item_code) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("./src/etc/itemList.json"));
        JSONObject itemList = (JSONObject) object;
        JSONObject itemObject = (JSONObject) itemList.get(item_code);
        source = (String) itemObject.get("itemRoute");

        System.out.println(source);

        return source;

    }
}
