package com.infosys.myapplication.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.infosys.myapplication.MainActivity;
import com.infosys.myapplication.R;

import java.util.zip.Inflater;

/**
 * Created by GrimReaper on 7/13/2017.
 */

public class YoutubeMovieAdapter extends ArrayAdapter {
    Context context;
    //    public YoutubeMovieAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Object[] objects) {
//        super(context, resource, objects);
//        this.context = context;
//    }
    String[] movieNames;
    String[] directorNames;
    String[] subTitle;
    String[] likes;
    int[] thumnailIDs;


    public YoutubeMovieAdapter(Context context, int resource, String[] movieNames, String[] directorNames, String[] subTitle, String[] likes, int[] thumnailIDs) {
        super(context, resource);
        this.context = context;
        this.movieNames = movieNames;
        this.directorNames = directorNames;
        this.subTitle = subTitle;
        this.likes = likes;
        this.thumnailIDs = thumnailIDs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflator.inflate(R.layout.dummy_row_style_list, null);

        TextView movTitle = (TextView) convertView.findViewById(R.id.dummy_row_title_tv);
        TextView DirectorTitle = (TextView) convertView.findViewById(R.id.dummy_row_director_tv);
        TextView CastTitle = (TextView) convertView.findViewById(R.id.dummy_row_subtitle_tv);
        TextView Likes = (TextView) convertView.findViewById(R.id.dummy_row_likes_tv);
        ImageView thumnailImg = (ImageView) convertView.findViewById(R.id.dummy_row_thumnail_imgvu);

        movTitle.setText(movieNames[position]);
        DirectorTitle.setText(directorNames[position]);
        CastTitle.setText(subTitle[position]);
        Likes.setText(likes[position]);
        thumnailImg.setImageResource(thumnailIDs[position]);
        return convertView;
    }

    @Override
    public int getCount() {
        return movieNames.length;

    }
}
