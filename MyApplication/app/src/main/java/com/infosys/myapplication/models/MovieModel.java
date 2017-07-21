package com.infosys.myapplication.models;

/**
 * Created by GrimReaper on 7/13/2017.
 */

public class MovieModel {

    private String title;
    private String subTitle;
    private String director;
    private String likes;
    private int thumnailIdz;

    public int getThumnailIdz() {
        return thumnailIdz;
    }

    public void setThumnailIdz(int thumnailIdz) {
        this.thumnailIdz = thumnailIdz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
