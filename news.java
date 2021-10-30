package com.examplenishad.NewsApp;

import java.util.ArrayList;

public class news {

    private String status;
    private String totalResults;
    private ArrayList<modelclass> articles;

    public news(String status, String totalResults, ArrayList<modelclass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<modelclass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<modelclass> articles) {
        this.articles = articles;
    }
}
