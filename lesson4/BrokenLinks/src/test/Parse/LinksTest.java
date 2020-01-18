package test.Parse;

import main.java.BrokenLinks.Parse.Links;
import main.java.BrokenLinks.Parse.ParseHtml;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinksTest {
    @Test
    void RunRequestTest()
    {
        ArrayList<String>  arLinks = new ArrayList<>();
        arLinks.add("http://52.136.215.164/links/un503availible.php");
        arLinks.add("http://52.136.215.164/links/found302.php");


        Links links = new Links();
        ArrayList<String> linksWihthResponse =  links.RunRequest(arLinks);

        assertEquals(2, linksWihthResponse.size());

    }
}
