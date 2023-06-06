package org.bancolombia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static org.bancolombia.outputFile.outputNotInPilotFile;

public class compareFile {

    String pathPilot;
    String pathJson;

    public static void path_in_list(String[] paths) throws IOException, InterruptedException {

        String pathPilot = paths[0];
        String pathJson = paths[1];

        File csv = new File(pathPilot);
        File json = new File(pathJson);

        List<String> valuesCsv = readLines(csv);
        List<String> valuesJson = readLines(json);

        compare(valuesCsv, valuesJson);
    }

    public static List<String> readLines(File file) {
        List<String> values = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                values.add(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return values;
    }

    public static void compare(List<String> valuesCsv, List<String> valuesJson) throws IOException, InterruptedException {
        List<String> notCoincidences = new ArrayList<>();

        for (String valueCsv : valuesCsv) {
            for (String valueJson : valuesJson) {
                if (!valueCsv.equals(valueJson)) {
                    notCoincidences.add(valueJson);
                    System.out.println(valueJson);
                    //break;
                }
            }
        }

        //System.out.println(values);
        List<String> values= removeDuplicates(notCoincidences);
        outputNotInPilotFile(values);

    }
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> withoutDuplicates = new HashSet<>(list);
        return new ArrayList<>(withoutDuplicates);
    }

}
