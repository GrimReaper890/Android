package com.grimreaper.fragmentbasics;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.grimreaper.fragmentbasics.frag_pkg.FirstFragment;
import com.grimreaper.fragmentbasics.frag_pkg.SecondFragment;

public class MainActivity extends AppCompatActivity {
LinearLayout linLayFragmentContainer;
    FirstFragment mFirstFragment;
    SecondFragment mSecondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linLayFragmentContainer = (LinearLayout) findViewById(R.id.frag_basic_container);
        mSecondFragment = new SecondFragment();
        mFirstFragment = new FirstFragment();

    }

    public void LoadFirstFragment(View v) {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_basic_container,mFirstFragment);
        fragmentTransaction.commit();

    }

    public void LoadSecondFragment(View v) {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_basic_container,mSecondFragment);
        fragmentTransaction.commit();
    }
}
