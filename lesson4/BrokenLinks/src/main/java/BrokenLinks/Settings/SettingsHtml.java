package main.java.BrokenLinks.Settings;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SettingsHtml {
    private ArrayList<String> inputFiles = new ArrayList<>();

    public void addHtml(String str)
    {
        if (str.contains(".html"))
            inputFiles.add(str);
    }

    public ArrayList<String> getAllHtml()
    {
        return inputFiles;
    }

}
