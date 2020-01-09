package BrokenLinks.Parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class RequestHtml {
    public Document RequestHtmlContent(String str)
    {
        try {
            return Jsoup.connect(str).get();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
