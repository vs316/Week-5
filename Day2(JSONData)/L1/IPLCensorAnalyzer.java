package javaJSONHandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IPLCensorAnalyzer {

    public static void main(String[] args) throws IOException {
        // Input files
        String jsonInputFile = "ipl_data.json";
        String csvInputFile = "ipl_data.csv";

        // Output files
        String jsonOutputFile = "censored_ipl_data.json";
        String csvOutputFile = "censored_ipl_data.csv";

        // Process JSON data
        processJson(jsonInputFile, jsonOutputFile);

        // Process CSV data
        processCsv(csvInputFile, csvOutputFile);
    }

    private static void processJson(String inputFile, String outputFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = mapper.readTree(new File(inputFile));

        for (JsonNode node : jsonArray) {
            // Mask team names
            String team1 = node.get("team1").asText();
            String team2 = node.get("team2").asText();
            ((ObjectNode) node).put("team1", maskTeamName(team1));
            ((ObjectNode) node).put("team2", maskTeamName(team2));

            // Redact player of the match
            ((ObjectNode) node).put("player_of_match", "REDACTED");
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), jsonArray);
    }

    private static void processCsv(String inputFile, String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String header = reader.readLine();
        writer.write(header + "\n"); // Write header row

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");

            // Mask team names
            fields[1] = maskTeamName(fields[1]);
            fields[2] = maskTeamName(fields[2]);

            // Redact player of the match
            fields[6] = "REDACTED";

            writer.write(String.join(",", fields) + "\n");
        }

        reader.close();
        writer.close();
    }

    private static String maskTeamName(String teamName) {
        int spaceIndex = teamName.lastIndexOf(" ");
        return spaceIndex != -1 ? teamName.substring(0, spaceIndex) + " ***" : teamName + " ***";
    }
}