package com.rian.latihanretrofit.models;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("id")
    private Integer id;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
