package java_csv_dataHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "data.csv"; // Replace with your CSV file path
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                String[] values = line.split(",");
                String email = values[1]; // Assuming email is in the 2nd column
                String phone = values[2]; // Assuming phone is in the 3rd column

                if (!emailPattern.matcher(email).matches()) {
                    System.err.println("Invalid email: " + line);
                }
                if (!phonePattern.matcher(phone).matches()) {
                    System.err.println("Invalid phone number: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
