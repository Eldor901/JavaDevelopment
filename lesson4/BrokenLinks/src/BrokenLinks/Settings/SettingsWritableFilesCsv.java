package BrokenLinks.Settings;

import java.util.ArrayList;

public class SettingsWritableFilesCsv {
    private ArrayList<String> files = new ArrayList<>();

    public void addFile(String str)
    {
        if (str.contains("csv"))
            files.add(str);
    }

    public ArrayList<String> getAllWritableFiles()
    {
        return files;
    }
}
