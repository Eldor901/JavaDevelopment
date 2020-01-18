package test.Parse;

import main.java.BrokenLinks.Parse.Csv;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

 public class CsvTest {
     @Test    void csvWriter() {
        ArrayList<String> links = new ArrayList<>();
        links.add("http://52.136.215.164/links/un503availible.php, 503");
        links.add("http://52.136.215.164/links/found302.php, 302");
        ArrayList<String> csvFiles = new ArrayList<>();
        csvFiles.add("test.csv");

        Csv csv = new Csv();
        csv.csvWriter(csvFiles, links);
    }
}
