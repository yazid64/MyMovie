package com.example.mymovie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class people implements Parcelable {

    private String Name;
    private String Popularity;
    private String Profile_path;
    private String Media_type;
    private String Title;
    private String Vote_average;
    private String Image_film;
    private String Original_language;
    private String Original_title;
    private String Overview;
    private String Release;
    private String Popularity_film;


    public people(String name,String overview,String release, String popularity, String popularity_film, String profile_path, String media_type, String title, String vote_average, String image_film, String original_language, String original_title) {
        Name = name;
        Overview = overview;
        Release = release;
        Popularity_film = popularity_film;
        Popularity = popularity;
        Profile_path = profile_path;
        Media_type = media_type;
        Title = title;
        Vote_average = vote_average;
        Image_film = image_film;
        Original_language = original_language;
        Original_title = original_title;
    }



    protected people(Parcel in) {
        Popularity_film = in.readString();
        Name = in.readString();
        Release = in.readString();
        Overview = in.readString();
        Popularity = in.readString();
        Profile_path = in.readString();
        Media_type = in.readString();
        Title = in.readString();
        Vote_average = in.readString();
        Image_film = in.readString();
        Original_language = in.readString();
        Original_title = in.readString();
    }

    public static final Creator<people> CREATOR = new Creator<people>() {
        @Override
        public people createFromParcel(Parcel in) {
            return new people(in);
        }

        @Override
        public people[] newArray(int size) {
            return new people[size];
        }
    };

    public people() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPopularity_film() {
        return Popularity_film;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getRelease() {
        return Release;
    }

    public void setRelease(String release) {
        Release = release;
    }

    public void setPopularity_film(String popularity_film) {
        Popularity_film = popularity_film;
    }

    public String getPopularity() {
        return Popularity;
    }

    public void setPopularity(String popularity) {
        Popularity = popularity;
    }

    public String getProfile_path() {
        return Profile_path;
    }

    public void setProfile_path(String profile_path) {
        Profile_path = profile_path;
    }

    public String getMedia_type() {
        return Media_type;
    }

    public void setMedia_type(String media_type) {
        Media_type = media_type;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getVote_average() {
        return Vote_average;
    }

    public void setVote_average(String vote_average) {
        Vote_average = vote_average;
    }

    public String getImage_film() {
        return Image_film;
    }

    public void setImage_film(String image_film) {
        Image_film = image_film;
    }

    public String getOriginal_language() {
        return Original_language;
    }

    public void setOriginal_language(String original_language) {
        Original_language = original_language;
    }

    public String getOriginal_title() {
        return Original_title;
    }

    public void setOriginal_title(String original_title) {
        Original_title = original_title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Popularity);
        parcel.writeString(Profile_path);
        parcel.writeString(Media_type);
        parcel.writeString(Title);
        parcel.writeString(Vote_average);
        parcel.writeString(Image_film);
        parcel.writeString(Original_language);
        parcel.writeString(Original_title);
        parcel.writeString(Popularity_film);
        parcel.writeString(Overview);
        parcel.writeString(Release);
    }
}
