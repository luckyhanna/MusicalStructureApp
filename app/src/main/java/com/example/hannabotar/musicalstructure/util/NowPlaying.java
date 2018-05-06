package com.example.hannabotar.musicalstructure.util;

import com.example.hannabotar.musicalstructure.model.Song;

public enum NowPlaying {

    INSTANCE;

    Song song; //= new Song(20L, null, null, "My melody", null, null);
    Boolean paused = Boolean.FALSE;

    public void setSong(Song song) {
        this.song = song;
    }

    public Song getSong() {
        return this.song;
    }

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public void switchPaused() {
        paused = !paused;
    }
}
