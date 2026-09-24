package dev.viktorkolev.items;

import org.jsoup.nodes.Document;

public class WorkItem {
    private final String siteURL;
    private Document siteHTML;
    //private int itemID;

    public WorkItem(String siteURL) {
        // Add validation logic later on
        this.siteURL = siteURL;
        //this.itemID = *method for getting current last item ID from database*;
    }

    public void setSiteHTML(Document html) {
        this.siteHTML = html;
    }

    public String getURL() {
        return siteURL;
    }

    public Document getSiteHTML() {
        return siteHTML;
    }
}
