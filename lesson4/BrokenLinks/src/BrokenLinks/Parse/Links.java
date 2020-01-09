package BrokenLinks.Parse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class Links implements Runnable{
    private ArrayList<String> allLinks;
    private ArrayList<String> linkData;

    public void StoreLinks(ArrayList<String> allLinks, ArrayList<String> linkData)
    {
        this.allLinks = allLinks;
        this.linkData = linkData;
    }

    @Override
    public void run() {
        for (String link: allLinks) {

            if (link.contains("http")){
                try {
                    Connection.Response res = Jsoup.connect(link).ignoreHttpErrors(true).ignoreContentType(true).execute();
                    if (res.statusCode() != 200) {
                        linkData.add(link + "," + res.statusCode() + "," + res.statusMessage() + " " + "\n");
                    }
                }catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
