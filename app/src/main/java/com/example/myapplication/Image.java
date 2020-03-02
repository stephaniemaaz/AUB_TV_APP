package com.example.myapplication;

import java.net.URI;
import java.net.URISyntaxException;

public class Image {

    private static final String TAG = Video.class.getSimpleName();

    static final long serialVersionUID = 727566175075960653L;
    private long id;
    private String ImageUrl;
    private String title;

    public Image(){}

    public Image(String url, String title) {
        this.ImageUrl = url;
        this.title = title;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImageUrl() {
        return this.ImageUrl;
    }

    public URI getImageURI() {
        try {
            return new URI(getImageUrl());
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

    public void setUrl(String url) {
        this.ImageUrl = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "type=image" +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + ImageUrl + '\'' +
                '}';
    }
}
