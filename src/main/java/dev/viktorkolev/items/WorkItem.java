package dev.viktorkolev.items;

import org.jsoup.nodes.Document;

public class WorkItem {
    private final String siteURL;
    private Document siteHTML;

    public WorkItem(String siteURL) {
        // Add validation logic later on
        this.siteURL = siteURL;
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
