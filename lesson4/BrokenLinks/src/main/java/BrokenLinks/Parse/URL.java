package main.java.BrokenLinks.Parse;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class URL {

    private static  void addHrefToList(ArrayList<String> allLinks, Elements hrefs, String type)
    {
        for (Element element: hrefs){
            String absHref = element.attr("abs:" + type);
            if (!absHref.equals(""))
                allLinks.add(absHref);
        }
    }

    public ArrayList<String> getAllLinks(Document doc)
    {
        ArrayList<String> allLinks = new ArrayList<String>();

        Elements links =  doc.select("a[href]");
        Elements imports = doc.select("link[href]");
        Elements media = doc.select("[src]");

        addHrefToList(allLinks, links, "href");
        addHrefToList(allLinks, imports, "href");
        addHrefToList(allLinks, media, "src");

        return allLinks;
    }
}
