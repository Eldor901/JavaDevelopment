package main.java.BrokenLinks.Threads;

import java.util.ArrayList;

public class LinkStorage {
    private  ArrayList<String> linkData = new ArrayList<>();

    public synchronized void addLinkToStorage(String linkResData)
    {
        linkData.add(linkResData);
    }

    public ArrayList<String> getAllLinks()
    {
        return linkData;
    }
}
