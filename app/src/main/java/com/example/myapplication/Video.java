package com.example.myapplication;

import android.net.Uri;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

public class Video implements Serializable, DisplayObject {

    private static final String TAG = Video.class.getSimpleName();

    static final long serialVersionUID = 727566175075960653L;
    private long id;
    private String title;
    private String description;
    private String YouTubeID;
    private String cardUrl;

    public Video(){}

    public Video(String title, String description, String youTubeID, String cardUrl) {
        this.title = title;
        this.description = description;
        this.YouTubeID = youTubeID;
        this.cardUrl = cardUrl;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getYouTubeID() {
        return YouTubeID;
    }

    public void setYouTubeID(String youTubeID) {
        YouTubeID = youTubeID;
    }

    @Override
    public String getCardUrl() {
        return cardUrl;
    }

    public URI getCardURI() {
        try {
            return new URI(getCardUrl());
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", YouTubeID='" + YouTubeID + '\'' +
                ", cardUrl='" + cardUrl + '\'' +
                '}';
    }


}
