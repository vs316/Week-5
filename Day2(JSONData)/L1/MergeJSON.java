package javaJSONHandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json1 = objectMapper.readTree(new File("file1.json"));
        JsonNode json2 = objectMapper.readTree(new File("file2.json"));

        ObjectNode merged = (ObjectNode) json1;
        json2.fields().forEachRemaining(field -> merged.set(field.getKey(), field.getValue()));

        System.out.println(merged.toPrettyString());
    }
}
