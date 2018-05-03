package com.example.hannabotar.musicalstructure.util;

import com.example.hannabotar.musicalstructure.model.Song;

public enum NowPlaying {

    INSTANCE;

    Song song = new Song(20L, null, null, "My melody", null, null);

    public void setSong(Song song) {
        this.song = song;
    }

    public Song getSong() {
        return this.song;
    }
}
