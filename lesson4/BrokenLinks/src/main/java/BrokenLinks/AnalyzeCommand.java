package main.java.BrokenLinks;

import main.java.BrokenLinks.Settings.SettingsHtml;
import main.java.BrokenLinks.Settings.SettingsWritableFilesCsv;
import main.java.BrokenLinks.Settings.SettingsUrls;



import java.util.ArrayList;

public class AnalyzeCommand{

    public static ArrayList<String> ParseCommand(String[] args)
    {
        if (args[0].equals("--files"))
        {
            SettingsHtml settingsHtml = new SettingsHtml();
            for (int i = 1; i < args.length; i++)
            {
                settingsHtml.addHtml(args[i]);
            }

            return  settingsHtml.getAllHtml();
        }
        else if(args[0].equals("--urls"))
        {
            SettingsUrls settingsUrls = new SettingsUrls();
            for (int i = 1; i < args.length; i++)
            {
                settingsUrls.addURl(args[i]);
            }
            return  settingsUrls.getAllURls();
        }
        else
        {
            throw new IllegalArgumentException("Command Arguments should be: --files page1.html page2.html --out report.csv or \n" +
                    "--urls url1 url2 --out report.csv");
        }
    }

    public static ArrayList<String> ParseWritableFiles(String[] args)
    {
        SettingsWritableFilesCsv  settingsWritableFilesCsv = new SettingsWritableFilesCsv();
        boolean isOut = false;

        for (int i = 0; i < args.length; i++)
        {
            if (args[i].equals("--out"))
                isOut = true;

            if (isOut) {
                settingsWritableFilesCsv.addFile(args[i]);
            }
        }
        if (!isOut)
            throw new IllegalArgumentException("outputs not specified. Please specify by: --out report.csv");

        return settingsWritableFilesCsv.getAllWritableFiles();
    }
}
