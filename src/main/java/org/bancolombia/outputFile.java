package org.bancolombia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class outputFile {

    public static void outputNotInPilotFile(List<String> values) throws IOException, InterruptedException {
        String outputPathFile = System.getProperty("user.dir");
        String outputNameFile = "notInPilotFile.csv";

        String finallyPath = outputPathFile+outputNameFile;
        System.out.println("File with id not in pilot file in: "+finallyPath);
        //String finallyPath = outputNameFile;


        FileWriter fileWriter = new FileWriter(finallyPath);


        for (String value: values){
            fileWriter.write(value);
            fileWriter.write("\n");
        }
        Thread.sleep(1000);
        fileWriter.close();

    }
}
