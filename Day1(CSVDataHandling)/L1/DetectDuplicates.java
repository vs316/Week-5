package java_csv_dataHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "data.csv"; // Replace with your CSV file path
        Set<String> ids = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                String id = line.split(",")[0]; // Assuming ID is in the 1st column
                if (!ids.add(id)) {
                    duplicates.add(line);
                }
            }

            System.out.println("Duplicate records:");
            duplicates.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
