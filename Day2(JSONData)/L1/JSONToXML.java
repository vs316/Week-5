package javaJSONHandling;

import org.json.JSONObject;
import org.json.XML;

public class JSONToXML {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Vachan\",\"age\":20,\"city\":\"Chengalpattu\"}";
        JSONObject jsonObject = new JSONObject(jsonString);
        String xml = XML.toString(jsonObject);

        System.out.println(xml);
    }
}
