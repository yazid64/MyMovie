package com.example.mymovie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Tvshow implements Parcelable {

    private String Name;
    private String Original_name;
    private String Popularity;
    private String First_air_date;
    private String Original_language;
    private String Overview;
    private String Poster_path;
    private String Vote_average;

    public Tvshow(String name, String vote_average, String original_name, String popularity, String first_air_date, String original_language, String overview, String poster_path) {
        Name = name;
        Original_name = original_name;
        Popularity = popularity;
        First_air_date = first_air_date;
        Original_language = original_language;
        Overview = overview;
        Vote_average = vote_average;
        Poster_path = poster_path;
    }

    public Tvshow() {

    }

    protected Tvshow(Parcel in) {
        Name = in.readString();
        Original_name = in.readString();
        Popularity = in.readString();
        First_air_date = in.readString();
        Original_language = in.readString();
        Overview = in.readString();
        Poster_path = in.readString();
        Vote_average = in.readString();
    }

    public static final Creator<Tvshow> CREATOR = new Creator<Tvshow>() {
        @Override
        public Tvshow createFromParcel(Parcel in) {
            return new Tvshow(in);
        }

        @Override
        public Tvshow[] newArray(int size) {
            return new Tvshow[size];
        }
    };

    public String getVote_average() {
        return Vote_average;
    }

    public void setVote_average(String vote_average) {
        Vote_average = vote_average;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOrginal_name() {
        return Original_name;
    }

    public void setOrginal_name(String orginal_name) {
        Original_name = orginal_name;
    }

    public String getPopularity() {
        return Popularity;
    }

    public void setPopularity(String popularity) {
        Popularity = popularity;
    }

    public String getFirst_air_date() {
        return First_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        First_air_date = first_air_date;
    }

    public String getOriginal_language() {
        return Original_language;
    }

    public void setOriginal_language(String original_language) {
        Original_language = original_language;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getPoster_path() {
        return Poster_path;
    }

    public void setPoster_path(String poster_path) {
        Poster_path = poster_path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(Name);
        parcel.writeString(Original_name);
        parcel.writeString(Popularity);
        parcel.writeString(First_air_date);
        parcel.writeString(Original_language);
        parcel.writeString(Overview);
        parcel.writeString(Poster_path);
        parcel.writeString(Vote_average);
    }
}
