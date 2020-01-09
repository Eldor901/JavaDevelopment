package BrokenLinks.Settings;

import java.util.ArrayList;

public class SettingsUrls {
    private ArrayList<String> URls = new ArrayList<>();

    public void addURl(String str)
    {
        if (str.contains("http"))
            URls.add(str);
    }

    public ArrayList<String> getAllURls()
    {
        return URls;
    }
}
