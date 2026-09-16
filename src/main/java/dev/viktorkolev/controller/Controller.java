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

    public static void saveToTXT(WorkItem item, int type) {
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter("/home/vixata/Desktop/text" + fileCount++ + ".txt"));

            if (type == 1) {
                writer.write(item.getSiteHTML().html());
            } else {
                writer.write(item.getSiteHTML().body().text());
            }

            writer.close();
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
