package java_csv_dataHandling;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateCSVReport {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Replace with your database URL
        String username = "your_username"; // Replace with your database username
        String password = "your_password"; // Replace with your database password
        String csvFilePath = "employees.csv";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {

            String query = "SELECT employee_id, name, department, salary FROM employees"; // Replace with your table and column names
            ResultSet resultSet = statement.executeQuery(query);

            // Write headers
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Write data rows
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                writer.write(employeeId + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV report generated: " + csvFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
