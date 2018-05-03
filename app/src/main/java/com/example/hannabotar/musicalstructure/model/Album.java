package com.example.hannabotar.musicalstructure.model;

public class Album {

    private Long id;
    private Artist artist;
    private String name;
    private Integer imageId;

    public Album(Long id, Artist artist, String name, Integer imageId) {
        this.id = id;
        this.artist = artist;
        this.name = name;
        this.imageId = imageId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
