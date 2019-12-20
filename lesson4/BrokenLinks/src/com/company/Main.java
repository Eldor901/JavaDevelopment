package com.company;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    final static String Url = "http://52.136.215.164:9000/";

    private  static  Document getHtmlContent(String url) throws IOException
    {
        return Jsoup.connect(url).get();
    }

    private static  void addHrefToList(ArrayList<String> allLinks, Elements hrefs,  String type)
    {
        for (Element element: hrefs){
            String absHref = element.attr("abs:" + type);
            if (!absHref.equals(""))
                 allLinks.add(absHref);
        }
    }

    private static ArrayList<String> getAllLinks(Document doc)
    {

        ArrayList<String> allLinks = new ArrayList<String>();

        Elements links =  doc.select("a[href]");
        Elements imports = doc.select("link[href]");
        Elements media = doc.select("[src]");

        addHrefToList(allLinks, links, "href");
        //addHrefToList(allLinks, imports, "href");
        //addHrefToList(allLinks, media, "src");

        return allLinks;
    }


    public static void main(String[] args) throws IOException {
        Document html = getHtmlContent(Url);
        ArrayList<String> allLinks = getAllLinks(html);

        for (String link: allLinks) {
            if (link.contains("http")) {
                Connection.Response res = Jsoup.connect(link).ignoreHttpErrors(true).execute();
                if (res.statusCode() != 200) {
                    System.out.println(link);
                    System.out.println(res.statusCode());
                }
            }
        }
    }
}
