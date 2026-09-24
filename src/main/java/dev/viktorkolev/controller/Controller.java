package dev.viktorkolev.controller;

import dev.viktorkolev.items.WorkItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    private static int fileCount = 1;

    public static void fetchHTML(WorkItem item) throws IOException {
        // ADD TRY / CATCH LATER ON + REMOVE "throws IOException"
        Document doc = Jsoup.connect(item.getURL()).get();

        item.setSiteHTML(doc);
    }

    public static void saveToFile(WorkItem item, int type) {
        BufferedWriter writer;
        String container, suffix;

        if (type == 1) {
            container = item.getSiteHTML().html();
            suffix = ".html";
        } else {
            container = item.getSiteHTML().body().text();
            suffix = ".txt";
        }

        try
        {
            writer = new BufferedWriter( new FileWriter("/home/vixata/Desktop/text" + fileCount++ + suffix));
            writer.write(container);
            writer.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
