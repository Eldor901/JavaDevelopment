package main.java.BrokenLinks.Settings;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsProperties {
    public int getNumberOfThreads()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("files/config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return Integer.parseInt(properties.getProperty("threadsAmount"));
        }
        catch (IOException|NumberFormatException e)
        {
            System.out.println(e);
            return 0;
        }
    }
}
