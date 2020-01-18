package test.Parse;

import main.java.BrokenLinks.Parse.RequestHtmlFile;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import javax.print.Doc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RequestHtmlFileTest {
    @Test void getContent()
    {
        final String root = "files/html/";
        final String page = "page.html";
        RequestHtmlFile requestHtmlFile = new RequestHtmlFile();
        Document doc =  requestHtmlFile.getHtmlContent(page);
        assertNotNull(doc);
    }
}
