package com.example.hannabotar.musicalstructure.model;

public class Song {

    private Long id;
    private Artist artist;
    private Album album;
    private Genre genre;
    private String name;
    private Long seconds;

    public Song(Long id, Artist artist, Album album, String name, Long seconds, Genre genre) {
        this.id = id;
        this.artist = artist;
        this.album = album;
        this.name = name;
        this.seconds = seconds;
        this.genre = genre;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSeconds() {
        return seconds;
    }

    public void setSeconds(Long seconds) {
        this.seconds = seconds;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
