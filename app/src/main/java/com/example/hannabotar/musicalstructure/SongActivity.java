package com.example.hannabotar.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hannabotar.musicalstructure.model.Song;
import com.example.hannabotar.musicalstructure.util.NowPlaying;
import com.example.hannabotar.musicalstructure.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongActivity extends AppCompatActivity {

    @BindView(R.id.song_artist_text_view)
    TextView songArtist;
    @BindView(R.id.song_title_text_view)
    TextView songTitle;

    @BindView(R.id.previous_song)
    Button previousBtn;
    @BindView(R.id.play_pause_song)
    Button playPauseSong;
    @BindView(R.id.next_song)
    Button nextBtn;

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
            songArtist.setText(R.string.unknown_artist);
        }
        songTitle.setText(song.getName());

        NowPlaying.INSTANCE.setSong(song);
        NowPlaying.INSTANCE.setPaused(Boolean.FALSE);
        playPauseSong.setText(R.string.pause);

        previousBtn.setEnabled(false);
        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // play previous song
            }
        });
        playPauseSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // play/pause current song
                NowPlaying.INSTANCE.switchPaused();
                playPauseSong.setText(NowPlaying.INSTANCE.getPaused() ? R.string.play : R.string.pause);
            }
        });
        nextBtn.setEnabled(false);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // play next song
            }
        });
    }
}
