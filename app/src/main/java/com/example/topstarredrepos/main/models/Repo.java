package com.example.topstarredrepos.main.models;

public class Repo {

    private String title, username, description, avatarUrl, rating;

    public Repo(String title, String username, String description, String avatarUrl, String rating) {
        this.title = title;
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.description = description;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAvatarUrl() { return avatarUrl; }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }
}
