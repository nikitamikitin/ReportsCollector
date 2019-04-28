package com.reportscollector.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Data")
public class Data{


    @JsonProperty(value = "user_key")
    String userKey;

    @JsonProperty(value = "media_name")
    String media_name;

    @JsonProperty(value = "duration")
    String duration;
    @JsonProperty(value = "displayed_at")
    int displayed_at;

    public Data(String user_key, String media_name, String duration, int displayed_at) {
        this.userKey = user_key;
        this.media_name = media_name;
        this.duration = duration;
        this.displayed_at = displayed_at;
    }


    public String getUser_key() {
        return userKey;
    }

    public void setUser_key(String user_key) {
        this.userKey = user_key;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getDisplayed_at() {
        return displayed_at;
    }

    public void setDisplayed_at(int displayed_at) {
        this.displayed_at = displayed_at;
    }

    public Data() {

    }


    public String toString() {
        return " Data MediaName:" + media_name + " Duration:" + duration + "Displayed at: " + displayed_at;
    }

}