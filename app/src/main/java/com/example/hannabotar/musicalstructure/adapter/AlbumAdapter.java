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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hannabotar.musicalstructure.AlbumActivity;
import com.example.hannabotar.musicalstructure.R;
import com.example.hannabotar.musicalstructure.model.Album;

import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumAdapter extends ArrayAdapter<Album> {

    @BindView(R.id.album_img)
    ImageView imageView;
    @BindView(R.id.album_title_text)
    TextView albumTitle;
    @BindView(R.id.album_artist_text)
    TextView albumArtist;

    @BindView(R.id.album_item)
    RelativeLayout albumItem;

    public AlbumAdapter(@NonNull Context context, @NonNull List<Album> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }

        ButterKnife.bind(this, gridItemView);

        final Album currentAlbum = getItem(position);
        if (currentAlbum.getImageId() == null) {
            imageView.setImageResource(R.drawable.album_default_2);
        } else {
            imageView.setImageResource(currentAlbum.getImageId());
        }
        int itemWidth = getColumnWidth(((GridView) parent));
        imageView.getLayoutParams().height = itemWidth;

        albumTitle.setText(currentAlbum.getName());
        albumArtist.setText(currentAlbum.getArtist().getName());

        albumItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AlbumActivity.class);
                intent.putExtra("album_id", currentAlbum.getId());
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
