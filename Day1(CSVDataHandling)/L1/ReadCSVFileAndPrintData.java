package java_csv_dataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFileAndPrintData {
    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\java_csv_dataHandling\\data.csv"; // Path to your CSV file
        String line;
        String csvSplitBy = ","; // CSV delimiter

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] data = line.split(csvSplitBy);
                for (String value : data) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
