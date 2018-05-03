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

import com.example.hannabotar.musicalstructure.GenreActivity;
import com.example.hannabotar.musicalstructure.R;
import com.example.hannabotar.musicalstructure.model.Genre;

import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenreAdapter extends ArrayAdapter<Genre> {

    @BindView(R.id.genre_img)
    ImageView imageView;
    @BindView(R.id.genre_title_text)
    TextView genreTitle;

    @BindView(R.id.genre_item)
    RelativeLayout genreItem;

    public GenreAdapter(@NonNull Context context, @NonNull List<Genre> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.genre_item, parent, false);
        }

        ButterKnife.bind(this, gridItemView);

        final Genre currentGenre = getItem(position);

        int itemWidth = getColumnWidth(((GridView) parent));
        imageView.getLayoutParams().height = itemWidth;

        genreTitle.setText(currentGenre.getName());

        genreItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GenreActivity.class);
                intent.putExtra("genre_id", currentGenre.getId());
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
