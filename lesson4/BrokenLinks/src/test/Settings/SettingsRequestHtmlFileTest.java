package test.Settings;
import main.java.BrokenLinks.Settings.SettingsHtml;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsRequestHtmlFileTest {

    @Test
    public void SettingHtml()
    {
       SettingsHtml settingsHtml = new SettingsHtml();
       settingsHtml.addHtml("index.html");
       settingsHtml.addHtml("index.text");
       ArrayList<String> allhtml = settingsHtml.getAllHtml();

        assertEquals(1, allhtml.size());
        assertTrue(allhtml.contains("index.html"));

    }
}
