package javaJSONHandling;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseToJSON {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, name, email FROM users");

        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject obj = new JSONObject();
            obj.put("id", resultSet.getInt("id"));
            obj.put("name", resultSet.getString("name"));
            obj.put("email", resultSet.getString("email"));
            jsonArray.put(obj);
        }

        System.out.println(jsonArray.toString(4));
    }
}