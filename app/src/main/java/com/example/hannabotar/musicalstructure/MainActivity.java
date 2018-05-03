package com.example.hannabotar.musicalstructure;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hannabotar.musicalstructure.model.Song;
import com.example.hannabotar.musicalstructure.util.NowPlaying;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.now_playing_text)
    TextView nowPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setup();
    }

    private void setup() {

        Song playing = NowPlaying.INSTANCE.getSong();
        if (playing == null) {
            nowPlaying.setVisibility(View.INVISIBLE);
        } else {
            nowPlaying.setVisibility(View.VISIBLE);
            nowPlaying.setText(playing.getName());
        }

        tabLayout.addTab(tabLayout.newTab().setText(R.string.artists_fragment));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.albums_fragment));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.songs_fragment));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.genres_fragment));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
