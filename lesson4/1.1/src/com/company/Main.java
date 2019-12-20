package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static List<Path> getFileRouts(List<Path> listPaths)
    {
        Iterator<Path> it = listPaths.iterator();
        while (it.hasNext()) {
            Path paths = it.next();
            File file = paths.toFile();
            if(!file.isFile())
                it.remove();
        }
        return listPaths;
    }


    private static void getSumHashOfFiles(List<Path> routs, FileWriter fileOut) throws Exception
    {
        int FNV_32_PRIME = 0x01000193;

        for (Path path: routs)
        {
            int hval = 0x811c9dc5;

            File file = path.toFile();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
                for (int i = 0; i < str.length(); i++) {
                    hval ^= str.charAt(i);
                    hval *= FNV_32_PRIME;
                }
            }

            fileOut.write(Integer.toHexString(hval) + "/" +path.toString()+"\n");

        }

    }

    public static void main(String[] args) throws Exception {
        FileReader fileIn = new FileReader(args[0]);
        FileWriter fileOut = new FileWriter(args[1]);
        Scanner sc = new Scanner(fileIn);
        while(sc.hasNextLine())
        {
            String wayPath = sc.nextLine();

            if(!wayPath.isEmpty()){
                Path path = Paths.get(wayPath);

                if(path.toFile().exists()) {
                    Stream<Path> StreamPaths = Files.walk(path);
                    List<Path> listPaths = StreamPaths.collect(Collectors.toList());
                    List<Path> routs = getFileRouts(listPaths);
                    getSumHashOfFiles(routs, fileOut);
                }else
                {
                    fileOut.write("00000000/" + path.toString() + "\n");
                }
                fileOut.flush();
            }
        }
    }
}

