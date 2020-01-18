package main.java.BrokenLinks.Threads;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;


public class ThreadWork extends Thread{
    private String link;
    private LinkStorage linkData ;

    public ThreadWork(String link, LinkStorage linkData)
    {
       this.link = link;
       this.linkData = linkData;
    }

    @Override
    public void run() {
        if (link.contains("http")){
            try {
                Connection.Response res = Jsoup.connect(link).ignoreHttpErrors(true).ignoreContentType(true).execute();
                if (res.statusCode() / 100 != 2) {
                    //System.out.println(link + ", " + res.statusCode() + ", " + res.statusMessage() + " " + "\n");
                    linkData.addLinkToStorage(link + ", " + res.statusCode() + ", " + res.statusMessage()  + "\n");
                }
            }catch (IOException e)
            {
                linkData.addLinkToStorage(link + " ," + e.getMessage()   + "\n");
            }
        }
    }

}
