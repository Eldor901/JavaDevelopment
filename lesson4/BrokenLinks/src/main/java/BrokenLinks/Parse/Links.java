package main.java.BrokenLinks.Parse;

import main.java.BrokenLinks.Threads.LinkStorage;
import main.java.BrokenLinks.Threads.ThreadWork;
import main.java.BrokenLinks.Settings.SettingsProperties;


import java.util.ArrayList;

public class Links {

    private LinkStorage linkStorage = new LinkStorage();
    private int amoutOfThreads = new SettingsProperties().getNumberOfThreads();


    public ArrayList<String> RunRequest(ArrayList<String> allLinks)
    {

        ArrayList<Thread> threads = new ArrayList<>();
            for (String link : allLinks) {
                if (Thread.activeCount() < amoutOfThreads) {
                    Thread thread = new Thread(new ThreadWork(link, linkStorage));
                    threads.add(thread);
                    thread.start();
                }
                else
                {
                    Thread thread = new ThreadWork(link, linkStorage);
                    thread.run();
                }

            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        return linkStorage.getAllLinks();
    }

}
