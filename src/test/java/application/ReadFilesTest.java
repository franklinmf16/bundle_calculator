package application;

import model.Input;
import org.junit.Assert;
import org.junit.Test;
import utils.ReadFiles;

import java.util.ArrayList;

public class ReadFilesTest {

    @Test
    public void readConfig() {
    }

    @Test
    public void readInput() {
        ReadFiles readFiles = new ReadFiles();
        ArrayList<Input> acutal = readFiles.readInput();
        ArrayList<Input> expect = new ArrayList<Input>();
        expect.add(new Input(10,"IMG"));
        expect.add(new Input(15,"FLAC"));
        expect.add(new Input(13,"VID"));
        Assert.assertEquals(acutal, expect);
    }
}