package com.company;

import BrokenLinks.AnalyzeCommand;
import BrokenLinks.Parse.Csv;
import BrokenLinks.Parse.ParseHtml;
import BrokenLinks.Parse.RequestHtml;
import org.jsoup.nodes.Document;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        ArrayList<String> StringParsed =  AnalyzeCommand.ParseCommand(args);
        ArrayList<String> StringWrtiateFileCsv = AnalyzeCommand.ParseWritableFiles(args);
        if (args[0].equals("--files")) {
            ParseHtml parse = new ParseHtml();
            ArrayList<String> content = parse.parserContent(StringParsed);
            Csv csv = new Csv();
            csv.csvWriter(StringWrtiateFileCsv, content);
        }

        if (args[0].equals("--urls")) {
            ParseHtml parse = new ParseHtml();
            ArrayList<String> content = parse.parserURLContent(StringParsed);
            Csv csv = new Csv();
            csv.csvWriter(StringWrtiateFileCsv, content);
        }
    }

}
