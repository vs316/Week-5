package javaJSONHandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class ValidateJSONStructure {

        public static boolean isValidJSON(String json) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.readTree(json);
                return true;
            } catch (JsonProcessingException e) {
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void main(String[] args) {
            String json = "{\"name\":\"Vachan\",\"age\":20}";
            System.out.println("Is valid JSON: " + isValidJSON(json));
        }
}
