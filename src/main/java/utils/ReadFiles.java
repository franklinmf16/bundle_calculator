package utils;

import com.google.gson.Gson;
import model.config.Config;
import model.Input;
import model.config.Item;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadFiles {
    public Config readConfig() {
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

    public ArrayList<Input> readInput(){
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

    public HashMap<String, Item> ItemMapper(Config config){
        HashMap<String, Item> itemMapper = new HashMap<String, Item>();
        for (Item item : config.getFormats()) {
            itemMapper.put(item.getCode(), item);
        }
        return itemMapper;
    }

}
