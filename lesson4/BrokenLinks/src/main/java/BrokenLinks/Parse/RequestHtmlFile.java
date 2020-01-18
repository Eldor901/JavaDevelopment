package main.java.BrokenLinks.Parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class RequestHtmlFile {
    final String root = "files/html/";
    public  Document getHtmlContent(String str)
    {
        try {
            File file = new File(root + str);
            if (file.exists()) {
                Document doc = Jsoup.parse(file, "UTF-8");
                return doc;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
       return null;
    }

}
