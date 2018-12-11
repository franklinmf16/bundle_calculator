import com.google.gson.Gson;
import model.Config;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("resources/formats.json");
        String content = FileUtils.readFileToString(file, "utf-8");
        Config config = new Gson().fromJson(content, Config.class);
        System.out.println(config.getFormats().get(0));

    }

}
