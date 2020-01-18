package main.java.BrokenLinks.Parse;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Csv {

    final String root = "files/csv/";

    public void csvWriter(ArrayList<String> csv, ArrayList<String> str) {
        try {
            for (String csvW : csv) {

                FileWriter fileWriter = new FileWriter(root + csvW);

                String collect = str.stream().collect(Collectors.joining(""));
                fileWriter.write(collect);
                
                fileWriter.flush();
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            System.out.println(e.getMessage());
        }

    }
}