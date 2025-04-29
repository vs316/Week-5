package java_csv_dataHandling;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class JSONCSVConverter {
    public static void main(String[] args) throws IOException {
        // Convert JSON to CSV
        String jsonFilePath = "students.json";
        String csvFilePath = "students.csv";
        convertJSONToCSV(jsonFilePath, csvFilePath);

        // Convert CSV back to JSON
        String newJsonFilePath = "students_converted.json";
        convertCSVToJSON(csvFilePath, newJsonFilePath);
    }

    public static void convertJSONToCSV(String jsonFilePath, String csvFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));

        StringBuilder jsonContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonContent.append(line);
        }

        JSONArray jsonArray = new JSONArray(jsonContent.toString());
        writer.write("ID,Name,Age"); // Write headers
        writer.newLine();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            writer.write(jsonObject.getInt("ID") + "," + jsonObject.getString("Name") + "," + jsonObject.getInt("Age"));
            writer.newLine();
        }

        reader.close();
        writer.close();
        System.out.println("Converted JSON to CSV: " + csvFilePath);
    }

    public static void convertCSVToJSON(String csvFilePath, String jsonFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFilePath));

        String line = reader.readLine(); // Skip header
        JSONArray jsonArray = new JSONArray();

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID", Integer.parseInt(values[0]));
            jsonObject.put("Name", values[1]);
            jsonObject.put("Age", Integer.parseInt(values[2]));
            jsonArray.put(jsonObject);
        }

        writer.write(jsonArray.toString(4)); // Pretty print JSON
        reader.close();
        writer.close();
        System.out.println("Converted CSV to JSON: " + jsonFilePath);
    }
}
