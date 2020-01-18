package test;
import main.java.BrokenLinks.AnalyzeCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class AnalyzeCommandTest {


   @Test
   public void AnalayzeCommandFiles()
   {
       String file1 = "index.html";
       String file2 = "index2.html";
       ArrayList<String> ParsedCommand = AnalyzeCommand.ParseCommand(new String[]{"--files",
               file1, file2});
       assertEquals(2, ParsedCommand.size());
       assertTrue(ParsedCommand.contains(file1));
       assertTrue(ParsedCommand.contains(file2));
   }

   @Test void AnalayzeCommandUrl()
   {
       String file1 = "https://httpstat.us/";
       String file2 = "https://hello.com";
       String file3 = "httK://dot.js";
       ArrayList<String> ParsedCommand = AnalyzeCommand.ParseCommand(new String[]{"--urls",
               file1, file2, file3});
       assertEquals(2, ParsedCommand.size());
       assertTrue(ParsedCommand.contains(file1));
       assertTrue(ParsedCommand.contains(file2));
   }

    @Test void AnalayzeWritableFiles()
    {
        String file1 = "https://httpstat.csv";
        String file2 = "https://hello.csv";
        String file3 = "httpK://dot.txt";
        ArrayList<String> ParsedCommand = AnalyzeCommand.ParseWritableFiles(new String[]{"--out",
                file1, file2, file3});
        assertEquals(2, ParsedCommand.size());
        assertTrue(ParsedCommand.contains(file1));
        assertTrue(ParsedCommand.contains(file2));
    }

}
