package test.Settings;

import main.java.BrokenLinks.Settings.SettingsUrls;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingUrlsTest {

    @Test
    public void SettingHtml()
    {
        SettingsUrls SettingsUrls = new SettingsUrls();
        SettingsUrls.addURl("https://httpstat.us/");
        SettingsUrls.addURl("adveture.com");
        ArrayList<String> allhtml = SettingsUrls.getAllURls();

        assertEquals(1, allhtml.size());
        assertTrue(allhtml.contains("https://httpstat.us/"));
    }


}

