package java_csv_dataHandling;

import java.io.*;
import java.util.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\java_csv_dataHandling\\employees.csv"; // Replace with your CSV file path

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            List<String[]> records = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                records.add(line.split(","));
            }

            records.sort((a, b) -> Double.compare(Double.parseDouble(b[2]), Double.parseDouble(a[2]))); // Sort by salary (3rd column)

            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(String.join(", ", records.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
