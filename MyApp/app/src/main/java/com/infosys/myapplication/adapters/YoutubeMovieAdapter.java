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
import com.infosys.myapplication.models.MovieModel;

import java.util.zip.Inflater;

/**
 * Created by GrimReaper on 7/13/2017.
 */

public class YoutubeMovieAdapter extends ArrayAdapter {
    Context context;

    MovieModel[] mData;
    int[] thumnailIDs;


    public YoutubeMovieAdapter(Context context, int resource, MovieModel[] mData) {
        super(context, resource);
        this.context = context;
        this.mData = mData;

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

        movTitle.setText(mData[position].title);
        DirectorTitle.setText(mData[position].director);
        CastTitle.setText(mData[position].subTitle);
        Likes.setText(mData[position].likes);
        thumnailImg.setImageResource(mData[position].thumnailIdz);
        return convertView;
    }

    @Override
    public int getCount() {
        return mData.length;

    }
}
