package com.example.hannabotar.musicalstructure.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hannabotar.musicalstructure.ArtistActivity;
import com.example.hannabotar.musicalstructure.R;
import com.example.hannabotar.musicalstructure.model.Artist;

import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    @BindView(R.id.artist_img)
    ImageView imageView;
    @BindView(R.id.artist_title_text)
    TextView artistTitle;
    /*@BindView(R.id.artist_play_btn)
    Button artistPlay;*/

    @BindView(R.id.artist_item)
    RelativeLayout artistItem;

    public ArtistAdapter(@NonNull Context context, @NonNull List<Artist> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.artist_item, parent, false);
        }

        ButterKnife.bind(this, gridItemView);

        final Artist currentArtist = getItem(position);
        if (currentArtist.getImageId() == null) {
            imageView.setImageResource(R.drawable.album_default);
        } else {
            imageView.setImageResource(currentArtist.getImageId());
        }
        int itemWidth = getColumnWidth(((GridView) parent));
        imageView.getLayoutParams().height = itemWidth;

        artistTitle.setText(currentArtist.getName());

        /*artistPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ArtistActivity.class);
                intent.putExtra("artist_id", currentArtist.getId());
                getContext().startActivity(intent);
            }
        });*/
        artistItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ArtistActivity.class);
                intent.putExtra("artist_id", currentArtist.getId());
                getContext().startActivity(intent);
            }
        });

        return gridItemView;

    }

    private int getColumnWidth(GridView gridView){
        if (Build.VERSION.SDK_INT >= 16)
            return gridView.getColumnWidth();
        else {
            try {
                Field mField = GridView.class.getDeclaredField("mColumnWidth");
                mField.setAccessible(true);
                Integer wid = (Integer) mField.get(this);
                mField.setAccessible(false);

                return wid.intValue();
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
