package com.example.hannabotar.musicalstructure.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.hannabotar.musicalstructure.R;
import com.example.hannabotar.musicalstructure.SongActivity;
import com.example.hannabotar.musicalstructure.model.Song;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongAdapter extends ArrayAdapter<Song> {

    @BindView(R.id.song_title_text)
    TextView songTitle;
    @BindView(R.id.song_artist_text)
    TextView songArtist;
    @BindView(R.id.song_duration_text)
    TextView songDuration;
    @BindView(R.id.play_song_btn)
    Button playSongBtn;

    public SongAdapter(@NonNull Context context, @NonNull List<Song> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        ButterKnife.bind(this, listItemView);

        final Song currentSong = getItem(position);

        songTitle.setText(currentSong.getName());
        if (currentSong.getArtist() != null) {
            songArtist.setText(currentSong.getArtist().getName());
        } else {
            songArtist.setText("Unknown artist");
        }

        String duration = getDuration(currentSong.getSeconds());
        songDuration.setText(duration);

        playSongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SongActivity.class);
                intent.putExtra("song_id", currentSong.getId());
                getContext().startActivity(intent);
            }
        });

        return listItemView;

    }

    private String getDuration(Long songSeconds) {
        if (songSeconds == null) {
            return "--:--";
        }
        Long minutes = songSeconds / 60;
        Long seconds = songSeconds % 60;
        String secondsString = seconds.toString();
        if (seconds  < 10) {
            secondsString = "0" + seconds;
        }
        return "(" + minutes + ":" + secondsString + ")";
    }
    
}
