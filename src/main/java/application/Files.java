package application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.config.Config;
import model.Input;
import model.output.Output;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Files {
    public static Config readConfig() {
        File file = new File("src/main/resources/formats.json");
        String content = null;
        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Config config = new Gson().fromJson(content, Config.class);
        return config;
    }

    public static ArrayList<Input> readInput(){
        String dataSource = "src/main/resources/input.csv";
        File file = new File(dataSource);
        ArrayList<Input> inputs = new ArrayList<Input>();
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                if (data.length() > 1) {
                    String[] s = data.split(" ");
                    inputs.add(new Input(Integer.valueOf(s[0]), s[1]));
                }
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return inputs;
    }

    public static void write(List<Output> outputs) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson(outputs);
        File file = new File("src/main/resources/output.json");
        try {
            FileUtils.write(file, string, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
