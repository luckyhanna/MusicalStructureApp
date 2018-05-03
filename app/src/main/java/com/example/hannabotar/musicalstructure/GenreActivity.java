package com.example.hannabotar.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hannabotar.musicalstructure.adapter.SongAdapter;
import com.example.hannabotar.musicalstructure.model.Genre;
import com.example.hannabotar.musicalstructure.model.Song;
import com.example.hannabotar.musicalstructure.util.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenreActivity extends AppCompatActivity {

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

        Long genreId = getIntent().getLongExtra("genre_id", 0);

        Genre genre = Util.getGenreById(genreId);

        imageView.setImageResource(R.drawable.genre_img);

        titleText.setText(genre.getName());
        List<Song> songList = Util.getSongsByGenre(genreId);

        SongAdapter adapter = new SongAdapter(this, songList);

        listView.setAdapter(adapter);

    }
}