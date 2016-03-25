package com.example.quan_bui.cardviewandrecyclerview;

/**
 * Created by Quan Bui on 3/25/16.
 */
public class Task {
    private String title;
    private String details;

    public Task() { }

    public Task(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getTitle() {
        return title;
    }
}
