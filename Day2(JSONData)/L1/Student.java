package javaJSONHandling;
import org.json.JSONObject;
import org.json.JSONArray;

public class Student {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Vachan");
        student.put("age",22);
        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Science");
        student.put("subjects", subjects);

        System.out.println(student.toString(4));
    }
}
