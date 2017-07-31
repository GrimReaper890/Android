package com.infosys.myapplication.models;

/**
 * Created by GrimReaper on 7/13/2017.
 */

public class MovieModel {

    public String title;
    public String subTitle;
    public String director;
    public String likes;
    public int thumnailIdz;

    public MovieModel(String title, String subTitle, String director, String likes, int thumnailIdz) {
        this.title = title;
        this.subTitle = subTitle;
        this.director = director;
        this.likes = likes;
        this.thumnailIdz = thumnailIdz;
    }
}
