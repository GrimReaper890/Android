package com.infosys.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.infosys.myapplication.adapters.YoutubeMovieAdapter;

public class MainActivity extends AppCompatActivity {

    String[] movieNames = {
            "TITANIC",
            "EXCUSE",
            "RACE",
            "RAGE",
            "DEMONICA",
            "GINGA",
            "WAR",
            "LAGAAN",
    };
    String[] DirectorNames = {
            "TITANIC",
            "EXCUSE",
            "RACE",
            "RAGE",
            "DEMONICA",
            "GINGA",
            "WAR",
            "LAGAAN",
    };
    String[] SubTitle = {
            "Cast: angelena,TombCruise",
            "Cast: Julia,TombCruise",
            "Cast: Katrin,TombCruise",
            "Cast: Molly,TombCruise",
            "Cast: Jade,TombCruise",
            "Cast: ava,TombCruise",
            "Cast: janilia,TombCruise",
            "Cast: Rizwana,TombCruise",
    };
    String[] Likes = {
            "Likes:20k",
            "Likes:204k",
            "Likes:205k",
            "Likes:207k",
            "Likes:214k",
            "Likes:10000k",
            "Likes:0k",
            "Likes:0k",
    };
int[] thumnailIDs = {
            R.drawable.pic_one,
            R.drawable.pic_two,
            R.drawable.pic_three,
            R.drawable.pic_four,
            R.drawable.pic_five,
            R.drawable.pic_six,
            R.drawable.pic_seven,
            R.drawable.pic_eight
    };

    YoutubeMovieAdapter ourAdapter;
ListView youtubeListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        youtubeListView = (ListView) findViewById(R.id.lst_u_tube_movies);
        ourAdapter = new YoutubeMovieAdapter(MainActivity.this,R.layout.dummy_row_style_list,movieNames,DirectorNames,SubTitle,Likes,thumnailIDs);
        youtubeListView.setAdapter(ourAdapter);


    }
}
