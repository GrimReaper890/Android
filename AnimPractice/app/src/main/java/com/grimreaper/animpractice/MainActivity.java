package com.grimreaper.animpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView animImageView;
    Button btnPlayAnim;
    Animation alPhAnim,rotateAnim,translateAnim,ScaleAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animImageView = (ImageView) findViewById(R.id.anim_image_view);
        btnPlayAnim = (Button) findViewById(R.id.btn_anim_player);

        btnPlayAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                alPhAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_anim);
 //               rotateAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_anim);
 //               translateAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.translater_anim);
                ScaleAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_animation);
//                animImageView.startAnimation(alPhAnim);
//                animImageView.startAnimation(rotateAnim);
//                btnPlayAnim.startAnimation(rotateAnim);
                btnPlayAnim.startAnimation(ScaleAnim);
            }
        });
    }
}
