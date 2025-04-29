package java_csv_dataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\java_csv_dataHandling\\sample.csv"; // Replace with your CSV file path

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowCount = 0;

            // Read the CSV file line by line
            while ((line = bufferedReader.readLine()) != null) {
                rowCount++;
            }

            // Print the total number of rows
            System.out.println("Total number of rows in the CSV file: " + rowCount);
        } catch (IOException e) {
            System.err.println("Error handling the file: " + e.getMessage());
        }
    }
}