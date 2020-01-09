package BrokenLinks.Parse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class ParseHtml {
    private ArrayList<String> linkData = new ArrayList<>();

    public ArrayList<String> parserContent(ArrayList<String> Arstr)
    {
        for (String str : Arstr)
        {
            Html html = new Html();
            URL url = new URL();
            Links link = new Links();
            Document doc = html.getHtmlContent(str);
            ArrayList<String> allLinks = url.getAllLinks(doc);
            link.StoreLinks(allLinks, linkData);
            link.run();
        }
        return linkData;
    }

    public ArrayList<String> parserURLContent(ArrayList<String> Arstr)
    {
        for (String str : Arstr)
        {
            RequestHtml html = new RequestHtml();
            URL url = new URL();
            Links link = new Links();
            Document doc = html.RequestHtmlContent(str);
            ArrayList<String> allLinks = url.getAllLinks(doc);
            link.StoreLinks(allLinks, linkData);
        }
        return linkData;
    }
}
