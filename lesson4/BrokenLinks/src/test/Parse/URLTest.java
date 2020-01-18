package test.Parse;

import main.java.BrokenLinks.Parse.RequestHtmlFile;
import main.java.BrokenLinks.Parse.URL;
import org.junit.jupiter.api.Test;

import javax.swing.text.Document;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class URLTest {

    @Test void addHrefToList(){
        final String root = "files/html/";
        final String page = "page.html";

        RequestHtmlFile requestHtmlFile = new RequestHtmlFile();
        org.jsoup.nodes.Document doc =  requestHtmlFile.getHtmlContent(page);

        URL url = new URL();
        ArrayList<String> links =  url.getAllLinks(doc);
        assertNotNull(doc);
    }

}
