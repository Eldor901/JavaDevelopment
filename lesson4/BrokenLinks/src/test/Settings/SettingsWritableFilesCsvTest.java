package test.Settings;

import main.java.BrokenLinks.Settings.SettingsWritableFilesCsv;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsWritableFilesCsvTest {
    @Test
    public void SettingHtml()
    {
        SettingsWritableFilesCsv settingsWritableFilesCsv = new SettingsWritableFilesCsv();

        settingsWritableFilesCsv.addFile("links.csv");
        settingsWritableFilesCsv.addFile("links.text");
        ArrayList<String> allhtml = settingsWritableFilesCsv.getAllWritableFiles();

        assertEquals(1, allhtml.size());
        assertTrue(allhtml.contains("links.csv"));
    }
}
