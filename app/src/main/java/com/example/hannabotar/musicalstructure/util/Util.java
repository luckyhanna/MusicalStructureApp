package com.example.hannabotar.musicalstructure.util;

import com.example.hannabotar.musicalstructure.R;
import com.example.hannabotar.musicalstructure.model.Album;
import com.example.hannabotar.musicalstructure.model.Artist;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static Artist mumford = new Artist(1L, "Mumford & Sons", R.drawable.mumford);
    public static Artist rudimental = new Artist(2L, "Rudimental", R.drawable.rudimental);
    public static Artist lost_frequencies = new Artist(3L, "Lost Frequencies", null);
    public static Artist sigma = new Artist(4L, "Sigma", R.drawable.sigma);
    public static Artist gramatik = new Artist(5L, "Gramatik", R.drawable.gramatik);
    public static Artist netsky = new Artist(6L, "Netsky", R.drawable.netsky);
    public static Artist george_ezra = new Artist(7L, "George Ezra", null);
    public static Artist gregory_porter = new Artist(8L, "Gregory Porter", R.drawable.porter);


    public static List<Artist> getArtists() {
        List<Artist> artistList = new ArrayList<>();
        artistList.add(mumford);
        artistList.add(rudimental);
        artistList.add(lost_frequencies);
        artistList.add(sigma);
        artistList.add(gramatik);
        artistList.add(netsky);
        artistList.add(george_ezra);
        artistList.add(gregory_porter);

        return artistList;
    }

    public static List<Album> getAlbums() {

        List<Album> albumList = new ArrayList<>();
        albumList.add(new Album(1L, mumford, "Wilder mind", null));
        albumList.add(new Album(2L, mumford, "Babel", null));

        albumList.add(new Album(3L, george_ezra, "Wanted on Voyage", null));
        albumList.add(new Album(4L, netsky, "Netsky", null));

        return albumList;
    }

}
