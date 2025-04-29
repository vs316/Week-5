package java_csv_dataHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int age;
    private int marks;

    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }
}

public class ConvertCSVToObjects {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\java_csv_dataHandling\\students.csv"; // Replace with your CSV file path
        List<Student> students = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                String[] values = line.split(",");
                students.add(new Student(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }
}
