package com.example.lenovo.mediaplayer_udacity.Music;

/**
 * Created by Lenovo on 03/04/2018.
 */

public class Music {
    private final int NO_IMAGE = -1;
    private String mName;
    private String mArtist;
    private String mTime;
    private int mImageResourceId = NO_IMAGE;

    public Music(String name, String artist, String time) {
        mName = name;
        mArtist = artist;
        mTime = time;
    }

    public Music(String name, String artist, String time, int imageResourceId) {
        mName = name;
        mArtist = artist;
        mTime = time;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getTime() {
        return mTime;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
