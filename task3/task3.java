import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class task3 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Пожалуйста, укажите пути для values.json, tests.json, и report.json");
            return;
        }
        String valuesFilePath = args[0];
        String testsFilePath = args[1];
        String reportFilePath = args[2];

        try {
            ObjectMapper mapper = new ObjectMapper();

            // Чтение values.json
            JsonNode valuesNode = mapper.readTree(new File(valuesFilePath));
            Map<Integer, String> valuesMap = new HashMap<>();

            for (JsonNode valueNode : valuesNode.get("values")) {
                int id = valueNode.get("id").asInt();
                String value = valueNode.get("value").asText();
                valuesMap.put(id, value);
            }

            // Чтение tests.json
            JsonNode testsNode = mapper.readTree(new File(testsFilePath));
            JsonNode reportNode = fillTestValues(testsNode, valuesMap);

            // Запись в report.json
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportFilePath), reportNode);
            System.out.println("Report generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JsonNode fillTestValues(JsonNode testsNode, Map<Integer, String> valuesMap) {
        for (JsonNode testNode : testsNode.get("tests")) {
            int id = testNode.get("id").asInt();
            ((ObjectNode) testNode).put("value", valuesMap.getOrDefault(id, ""));

            // Рекурсивно обходим вложенные тесты
            if (testNode.has("values")) {
                fillTestValues(testNode.get("values"), valuesMap);
            }
        }
        return testsNode;
    }
}