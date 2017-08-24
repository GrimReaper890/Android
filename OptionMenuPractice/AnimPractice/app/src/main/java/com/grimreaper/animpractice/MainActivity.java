package com.grimreaper.animpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imgViewTest;
    Animation alphaAnim, rotateAnim, scaleAnim, translateAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgViewTest = (ImageView) findViewById(R.id.img_vu_test);
        alphaAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha_anim);
        rotateAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_anim);
        scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_anim);
        translateAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_anim);
    }

    public void RotateImage(View v) {
        imgViewTest.startAnimation(rotateAnim);
    }

    public void ScaleImage(View v) {
        imgViewTest.startAnimation(scaleAnim);

    }

    public void AlphaImage(View v) {
        imgViewTest.startAnimation(alphaAnim);
    }

    public void TranslateImage(View v) {
        imgViewTest.startAnimation(translateAnim);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_main_menu, menu);
        return true;
    }

//    for the clickListner on the menu Items


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        geeting the id of the menu item clicked
        int id = item.getItemId();

        switch (id) {
            case R.id.opt_menu_settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            case R.id.opt_menu_profile:
                Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
            case R.id.opt_menu_logout:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
