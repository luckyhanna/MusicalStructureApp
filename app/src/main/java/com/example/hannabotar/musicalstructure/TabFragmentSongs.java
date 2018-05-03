package com.example.hannabotar.musicalstructure;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hannabotar.musicalstructure.adapter.SongAdapter;
import com.example.hannabotar.musicalstructure.model.Song;
import com.example.hannabotar.musicalstructure.util.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragmentSongs extends Fragment {

    @BindView(R.id.song_list_view)
    ListView listView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_fragment_songs, container, false);
        ButterKnife.bind(this, view);

        List<Song> songList = Util.getSongs();

        SongAdapter adapter = new SongAdapter(view.getContext(), songList);

        listView.setAdapter(adapter);

        return view;
    }
}
