package dev.viktorkolev.controller;

import dev.viktorkolev.items.WorkItem;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    private static int fileCount = 1;
    private static final String homeDir = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();

    public static boolean fetchHTML(WorkItem item) {
        try {
            Document doc = Jsoup.connect(item.getURL()).get();
            item.setSiteHTML(doc);

            return true;
        } catch (HttpStatusException e) {
            System.out.println("HTTP error: " + e.getStatusCode());
            return false;
        } catch (IOException e) {
            if (e.getMessage() == null) {
                System.out.println("Request failed: Empty or nonexistent site");
            } else {
                System.out.println("Request failed: " + e.getMessage());
            }
            return false;
        }
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
            String filename = "SavedFile_" + fileCount++;

            writer = new BufferedWriter( new FileWriter(homeDir + File.separatorChar + filename + suffix));
            writer.write(container);
            writer.close();
            System.out.println("File " + filename + " saved to Desktop successfully!");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
