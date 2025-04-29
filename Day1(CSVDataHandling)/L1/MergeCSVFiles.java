package java_csv_dataHandling;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            Map<String, String> dataMap = new HashMap<>();
            String line;

            // Read first file
            br1.readLine(); // Skip header
            while ((line = br1.readLine()) != null) {
                String[] values = line.split(",");
                dataMap.put(values[0], line); // Use ID as key
            }

            // Write header
            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();

            // Read second file and merge
            br2.readLine(); // Skip header
            while ((line = br2.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                if (dataMap.containsKey(id)) {
                    writer.write(dataMap.get(id) + "," + values[1] + "," + values[2]);
                    writer.newLine();
                }
            }

            System.out.println("Merged file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
