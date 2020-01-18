package test.Parse;

import main.java.BrokenLinks.Parse.ParseHtml;
import main.java.BrokenLinks.Parse.RequestHtmlFile;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParseHtmlTest {
    @Test
    void parserContent()
    {
        final String page = "page.html";
        final String page1 = "page1.html";
        ArrayList<String> arrHtml = new ArrayList<>();
        arrHtml.add(page);
        arrHtml.add(page1);
        ParseHtml parseHtml = new ParseHtml();
        ArrayList<String>  links =  parseHtml.parserHtmlContent(arrHtml);
        assertEquals(5, links.size());
    }
}
