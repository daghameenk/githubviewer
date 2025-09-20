package com.example.githubviewer;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {
    @SerializedName("login")
    private String login;

    @SerializedName("name")
    private String name;

    @SerializedName("followers")
    private int followers;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public int getFollowers() {
        return followers;
    }
}