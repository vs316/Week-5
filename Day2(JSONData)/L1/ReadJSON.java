package javaJSONHandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\javaJSONHandling\\data.json"));

        // Iterate through the array
        for (JsonNode node : rootNode) {
            printKeysAndValues(node);
        }
    }

    private static void printKeysAndValues(JsonNode node) {
        node.fields().forEachRemaining(entry -> {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        });
    }
}