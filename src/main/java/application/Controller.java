package application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import model.Input;
import model.config.Config;
import model.output.Output;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    public static void main(String[] args) {
        new Controller().run();
    }

    public void run() {
        /* setup */
        Config config = Files.readConfig();
        OutputGenerator generator = new OutputGenerator();
        generator.setConfig(config);

        /* input */
        List<Input> inputs = Files.readInput();

        /* process */
        List<Output> outputs = inputs.stream()
                .map(generator::generateOutput)
                .collect(Collectors.toList());

        // output
        Files.write(outputs);



    }
}
