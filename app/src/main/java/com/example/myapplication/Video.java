package com.example.myapplication;

import android.net.Uri;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

public class Video implements Serializable {

    private static final String TAG = Video.class.getSimpleName();

    static final long serialVersionUID = 727566175075960653L;
    private long id;
    private String title;
    private String description;
    private String YouTubeID;
    private String cardImageUrl;

    public Video(){}

    public Video(String title, String description, String youTubeID) {
        this.title = title;
        this.description = description;
        this.YouTubeID = youTubeID;
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

    public String getCardImageUrl() {
        return cardImageUrl;
    }

    public URI getCardImageURI() {
        try {
            return new URI(getCardImageUrl());
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

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", YouTubeID='" + YouTubeID + '\'' +
                ", cardImageUrl='" + cardImageUrl + '\'' +
                '}';
    }
}
