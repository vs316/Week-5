package java_csv_dataHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_file.csv"; // Replace with your CSV file path
        int chunkSize = 100;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;

            while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
                System.out.println(line);

                if (lineCount % chunkSize == 0) {
                    System.out.println("Processed " + lineCount + " lines...");
                }
            }

            System.out.println("Total lines processed: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}