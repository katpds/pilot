package org.bancolombia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class json {

    public static String read_json(String path) {

        String outputPathJsonFile = System.getProperty("user.dir");
        String outputNameJsonFile = "outputJsonFile.csv";

        String finallyPathJson = outputPathJsonFile+outputNameJsonFile;
        //String finallyPathJson =outputNameJsonFile;
        System.out.println("File Json: "+finallyPathJson);

        File file = new File(path);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(file);

            FileWriter fileWriter = new FileWriter(finallyPathJson);

            JsonNode valuesNode = rootNode.path("value"); // Reemplaza "clave" por el nombre de la clave que deseas extraer

            for (JsonNode valueNode : valuesNode) {
                String value = valueNode.path("definitionEnvironmentId").asText();
                fileWriter.write(value);
                fileWriter.write("\n");
            }

            fileWriter.close();
            //String valor = rootNode.path("releaseDefinitionName").asText();
            //System.out.println("Valor del campo: " + valor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(finallyPathJson);
        return finallyPathJson;
    }
}
