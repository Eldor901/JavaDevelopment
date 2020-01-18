package test.Parse;

import main.java.BrokenLinks.Parse.RequestHtmlURL;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RequestRequestHtmlFileURLTest {

    @Test void RequestHtmlTest()
    {
        RequestHtmlURL requestHtmlURL = new RequestHtmlURL();
        Document doc = requestHtmlURL.RequestHtmlContent("https://httpstat.us/");
        assertNotNull(doc);
    }
}
