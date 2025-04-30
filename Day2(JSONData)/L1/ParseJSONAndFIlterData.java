package javaJSONHandling;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ParseJSONAndFIlterData {

    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"Vachan\",\"age\":20},{\"name\":\"Ananya\",\"age\":30}]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        List<JsonNode> filtered = new ArrayList<>();
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                filtered.add(node);
            }
        }

        System.out.println(filtered);
    }
}