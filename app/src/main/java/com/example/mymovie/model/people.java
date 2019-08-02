package com.example.mymovie.model;

public class people {

    private String Name;
    private String Popularity;
    private int Profile_path;
    private String name;

    public people(String name, String popularity, int profile_path, String name1) {
        Name = name;
        Popularity = popularity;
        Profile_path = profile_path;
        this.name = name1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPopularity() {
        return Popularity;
    }

    public void setPopularity(String popularity) {
        Popularity = popularity;
    }

    public int getProfile_path() {
        return Profile_path;
    }

    public void setProfile_path(int profile_path) {
        Profile_path = profile_path;
    }
}
