package com.example.myapplication;

// todo: change
public class Powerpoint {
    private long mId; private String mTitle; private String mDescription; private String mPowerPointUrl; private String mCardImageUrl;
    private int mNumberOfPages; private String [] mImagesURLs; private String [] mDescriptionURLs; private int mTrialImage;

    public Powerpoint(){}
    public Powerpoint(String mTitle, String mDescription, String mPowerPointUrl) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mPowerPointUrl = mPowerPointUrl;
    }
    public Powerpoint(int mTrialImage) {
        this.mTrialImage = mTrialImage;
    }
    public Powerpoint(String mTitle, String mDescription, String mPowerPointUrl, int mNumberOfPages, String [] mImagesURLs, String [] mDescriptionsURLs) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mPowerPointUrl = mPowerPointUrl;
        this.mNumberOfPages = mNumberOfPages;
        this.mImagesURLs = mImagesURLs;
        this.mDescriptionURLs = mDescriptionsURLs;
    }
    public long getId() {
        return this.mId;
    }
    public String getTitle() {
        return this.mTitle;
    }
    public String getDescription() {
        return this.mDescription;
    }
    public String getPowerPointUrl() {
        return this.mPowerPointUrl;
    }
    public String getCardImageUrl() { return this.mCardImageUrl; }
    public int getTrialImage() { return R.drawable.ppt_image; }
    public void setId(Long mId) {
        this.mId = mId;
    }
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
    public void setPowerPointUrl(String mUrl) {
        this.mPowerPointUrl = mUrl;
    }
    public void setCardImageUrl(String mCardImageUrl) {
        this.mCardImageUrl = mCardImageUrl;
    }

    @Override
    public String toString() {
        return "Powerpoint{" +
                "type = powerpoint" +
                ", id=" + mId +
                ", title='" + mTitle + '\'' +
                ", description='" + mDescription +
                ", powerPointUrl='" + mPowerPointUrl +
                ", cardImageUrl='" + mCardImageUrl + '\'' +
                '}';
    }
}

