package com.example.hannabotar.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hannabotar.musicalstructure.adapter.SongAdapter;
import com.example.hannabotar.musicalstructure.model.Album;
import com.example.hannabotar.musicalstructure.model.Song;
import com.example.hannabotar.musicalstructure.util.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumActivity extends AppCompatActivity {

    @BindView(R.id.songs_img)
    ImageView imageView;

    @BindView(R.id.songs_title)
    TextView titleText;

    @BindView(R.id.songs_list_view)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_layout);

        ButterKnife.bind(this);

        Long albumId = getIntent().getLongExtra("album_id", 0);

        Album album = Util.getAlbumById(albumId);
        if (album.getImageId() == null) {
            imageView.setImageResource(R.drawable.album_default_2);
        } else {
            imageView.setImageResource(album.getImageId());
        }
        titleText.setText(album.getName());
        List<Song> songList = Util.getSongsByAlbum(albumId);

        SongAdapter adapter = new SongAdapter(this, songList);

        listView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }
}