package com.example.myapplication;

import java.net.URI;
import java.net.URISyntaxException;

public class Video {

    private static final String TAG = Video.class.getSimpleName();

    static final long serialVersionUID = 727566175075960653L;
    private long id;
    private String title;
    private String description;
    private String videoUrl;
    private String cardImageUrl;

    public Video(){}

    public Video(String title, String description, String videoUrl) {
        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
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

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public URI getVideoURI() {
        try {
            return new URI(getVideoUrl());
        } catch (URISyntaxException e) {
            return null;
        }
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

    public void setVideoUrl(String url) {
        this.videoUrl = url;
    }

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "type=video" +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description +
                ", videoUrl='" + videoUrl +
                ", cardImageUrl='" + cardImageUrl + '\'' +
                '}';
    }
}
