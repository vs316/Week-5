package java_csv_dataHandling;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSVFile {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\java_csv_dataHandling\\employees.csv"; // Replace with your CSV file path
        String outputFilePath = "updated_employees.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            boolean isHeader = true;
            List<String> updatedRecords = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Copy header row
                    updatedRecords.add(line);
                    continue;
                }

                String[] values = line.split(",");
                if (values[1].equalsIgnoreCase("IT")) { // Assuming department is in the 2nd column
                    double salary = Double.parseDouble(values[2]); // Assuming salary is in the 3rd column
                    salary *= 1.10; // Increase salary by 10%
                    values[2] = String.valueOf(salary);
                }
                updatedRecords.add(String.join(",", values));
            }

            for (String record : updatedRecords) {
                bufferedWriter.write(record);
                bufferedWriter.newLine();
            }

            System.out.println("Updated records saved to: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
