package com.infosys.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.infosys.myapplication.adapters.YoutubeMovieAdapter;
import com.infosys.myapplication.models.MovieModel;

public class MainActivity extends AppCompatActivity {


    YoutubeMovieAdapter ourAdapter;
    ListView youtubeListView;

    MovieModel[] movieModelsData = new MovieModel[]{

            new MovieModel("Mission impossible","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_one),
            new MovieModel("Clown Kill","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_two),
            new MovieModel("Kick","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_three),
            new MovieModel("Mission impossible","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_four),
            new MovieModel("Mission impossible","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_five),
            new MovieModel("Mission impossible","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_six),
            new MovieModel("Mission impossible","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_seven),
            new MovieModel("Mission impossible","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_eight),
            new MovieModel("Mission impossible","JOHN,Rock,Elisha","Tomb Cruise","50M",R.drawable.pic_eight),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        youtubeListView = (ListView) findViewById(R.id.lst_u_tube_movies);
        ourAdapter = new YoutubeMovieAdapter(MainActivity.this, R.layout.dummy_row_style_list,movieModelsData);
        youtubeListView.setAdapter(ourAdapter);


    }
}
