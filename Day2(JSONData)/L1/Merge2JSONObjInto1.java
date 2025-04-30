package javaJSONHandling;

import org.json.JSONObject;

public class Merge2JSONObjInto1 {
    public static void main(String[] args) {

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Vachan");
        obj1.put("age", 20);

        JSONObject obj2 = new JSONObject();
        obj2.put("email", "vachan@example.com");
        obj2.put("city", "Chengalpattu");

        JSONObject merged = new JSONObject(obj1, JSONObject.getNames(obj1));
        for (String key : JSONObject.getNames(obj2)) {
            merged.put(key, obj2.get(key));
        }

        System.out.println(merged.toString(4));

    }
}

