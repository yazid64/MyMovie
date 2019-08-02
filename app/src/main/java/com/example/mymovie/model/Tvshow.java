package com.example.mymovie.model;

public class Tvshow {

    private String Name;
    private String Orginal_name;
    private String Popularity;
    private String First_air_date;
    private String Original_language;
    private String Overview;
    private int Poster_path;

    public Tvshow(String name, String orginal_name, String popularity, String first_air_date, String original_language, String overview, int poster_path) {
        Name = name;
        Orginal_name = orginal_name;
        Popularity = popularity;
        First_air_date = first_air_date;
        Original_language = original_language;
        Overview = overview;
        Poster_path = poster_path;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOrginal_name() {
        return Orginal_name;
    }

    public void setOrginal_name(String orginal_name) {
        Orginal_name = orginal_name;
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

    public int getPoster_path() {
        return Poster_path;
    }

    public void setPoster_path(int poster_path) {
        Poster_path = poster_path;
    }
}
