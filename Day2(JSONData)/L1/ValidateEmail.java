package javaJSONHandling;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;

public class ValidateEmail {
    public static void main(String[] args) throws Exception {
        String schemaString = "{ \"type\": \"object\", \"properties\": { \"email\": { \"type\": \"string\", \"format\": \"email\" } }, \"required\": [\"email\"] }";
        String jsonString = "{ \"email\": \"vachan.kumar@example.com\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode schemaNode = objectMapper.readTree(schemaString);
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);
        JsonSchema schema = factory.getSchema(schemaNode);

        Set<ValidationMessage> errors = schema.validate(jsonNode);
        if (errors.isEmpty()) {
            System.out.println("Valid email!");
        } else {
            errors.forEach(System.out::println);
        }
    }
}
