package javaJSONHandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractFields {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file
        JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\javaJSONHandling\\data.json"));

        // Iterate through the array
        for (JsonNode node : rootNode) {
            String name = node.get("name").asText();
            String email = node.get("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }
    }
}