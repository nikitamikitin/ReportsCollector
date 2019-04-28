package model;

import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "Data")
public class Data extends BaseEntity {

    String user_key;
    String media_name;
    String duration;
    int displayed_at;


    public Data(String id,String media_name, String duration, int displayed_at) {
        super(id);
        this.media_name = media_name;
        this.duration = duration;
        this.displayed_at = displayed_at;

    }


    public void setUserKey(String user_key) {
        this.user_key = user_key;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
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

    public Integer getDisplayed_at() {
        return displayed_at;
    }

    public void setDisplayed_at(int displayed_at) {
        this.displayed_at = displayed_at;
    }

    public String toString() {
        return " Data MediaName:" + media_name + " Duration:" + duration + "Displayed at: "+displayed_at;
    }

}