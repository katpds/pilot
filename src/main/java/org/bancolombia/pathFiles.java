package org.bancolombia;

import java.io.IOException;
import java.util.Scanner;

import static org.bancolombia.compareFile.path_in_list;

public class pathFiles {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello world!");
        enter_paths();
    }

    public static String[] enter_paths() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type the path file: ");
        String pathPilot = scanner.nextLine();
        String escape_path_pilot= scape_path(pathPilot);

        System.out.print("Type the path json file: ");
        String pathJson = scanner.nextLine();
        String escape_path_json= scape_path(pathJson);
        String pathJsonFinally= json.read_json(escape_path_json);

        String[] paths = new String[2];
        paths[0] = escape_path_pilot;
        paths[1] = pathJsonFinally;

        path_in_list(paths);
        scanner.close();
        return paths;
    }

    public static String scape_path(String path){
        String scape_path= path.replace("//","////");
        return scape_path;
    }
}
