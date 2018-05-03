package com.example.hannabotar.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hannabotar.musicalstructure.model.Song;
import com.example.hannabotar.musicalstructure.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongActivity extends AppCompatActivity {

    @BindView(R.id.song_artist_text_view)
    TextView songArtist;
    @BindView(R.id.song_title_text_view)
    TextView songTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        ButterKnife.bind(this);

        Long songId = getIntent().getLongExtra("song_id", 0);

        Song song = Util.getSongById(songId);

        if (song.getArtist() != null) {
            songArtist.setText(song.getArtist().getName());
        } else {
            songArtist.setText("Unknown artist");
        }
        songTitle.setText(song.getName());
    }
}
