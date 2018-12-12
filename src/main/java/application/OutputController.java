package application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.Input;
import model.config.Config;
import model.config.Item;
import model.output.Output;
import utils.OutputGenerator;
import utils.ReadFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputController {
    public static void main(String[] args) {
        /* read input */
        ReadFiles readFiles = new ReadFiles();
        Config config = readFiles.readConfig();
        HashMap<String, Item> configMapper = readFiles.ItemMapper(config);
        ArrayList<Input> inputs = readFiles.readInput();

        /* output file */
        OutputGenerator outputGenerator = new OutputGenerator();
        ArrayList<Output> outputs = new ArrayList<Output>();
        for (Input input : inputs) {
            Item item = configMapper.get(input.getItem());
            Output output = outputGenerator.generateOutput(item, input);
            outputs.add(output);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            String s = mapper.writeValueAsString(outputs);
            System.out.println(s);
            Gson gson = new Gson();
            gson.toJson(outputs, new FileWriter("src/main/resources/output.json"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(outputs);
    }


}
