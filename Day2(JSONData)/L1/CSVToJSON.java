package javaJSONHandling;

import com.opencsv.CSVReader;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;

public class CSVToJSON {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
        String[] headers = reader.readNext();
        JSONArray jsonArray = new JSONArray();

        String[] line;
        while ((line = reader.readNext()) != null) {
            JSONObject obj = new JSONObject();
            for (int i = 0; i < headers.length; i++) {
                obj.put(headers[i], line[i]);
            }
            jsonArray.put(obj);
        }

        System.out.println(jsonArray.toString(4));
    }
}