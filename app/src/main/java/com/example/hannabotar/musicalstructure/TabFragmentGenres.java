package com.example.hannabotar.musicalstructure;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.hannabotar.musicalstructure.adapter.GenreAdapter;
import com.example.hannabotar.musicalstructure.model.Genre;
import com.example.hannabotar.musicalstructure.util.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragmentGenres extends Fragment {

    @BindView(R.id.genre_grid_view)
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_fragment_genres, container, false);
        ButterKnife.bind(this, view);

        List<Genre> genreList = Util.getGenres();

        GenreAdapter adapter = new GenreAdapter(view.getContext(), genreList);

        gridView.setAdapter(adapter);

        return view;
    }
}
