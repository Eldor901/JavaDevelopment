package test.Settings;

import main.java.BrokenLinks.Settings.SettingsProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SettingsPropertiesTest {

    @Test
    public void SettingsProperties()
    {
        SettingsProperties settingsProperties = new SettingsProperties();
        int threadsCount = settingsProperties.getNumberOfThreads();
        assertEquals(30, threadsCount);
    }
}
