package main.java.BrokenLinks.Parse;

import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class ParseHtml {
    private ArrayList<String> linkData = new ArrayList<>();

    public ArrayList<String> parserHtmlContent(ArrayList<String> Arstr)
    {
        for (String str : Arstr)
        {
            RequestHtmlFile requestHtmlFile = new RequestHtmlFile();
            URL url = new URL();
            Links link = new Links();
            Document doc = requestHtmlFile.getHtmlContent(str);
            ArrayList<String> allLinks = url.getAllLinks(doc);
            linkData = link.RunRequest(allLinks);

        }

        return linkData;
    }

    public ArrayList<String> parserURLContent(ArrayList<String> Arstr)
    {
        for (String str : Arstr)
        {
            RequestHtmlURL html = new RequestHtmlURL();
            URL url = new URL();
            Links link = new Links();
            Document doc = html.RequestHtmlContent(str);
            ArrayList<String> allLinks = url.getAllLinks(doc);
            linkData = link.RunRequest(allLinks);
        }
        return linkData;
    }
}
