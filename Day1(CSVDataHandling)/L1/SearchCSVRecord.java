package java_csv_dataHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchCSVRecord {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\java_csv_dataHandling\\employes.csv"; // Replace with your CSV file path
        String searchName = "John Doe"; // Replace with the name to search

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase(searchName)) { // Assuming name is in the 1st column
                    System.out.println("Department: " + values[1] + ", Salary: " + values[2]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
