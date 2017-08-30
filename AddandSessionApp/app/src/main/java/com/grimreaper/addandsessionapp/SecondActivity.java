package com.grimreaper.addandsessionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    SessionManger mSessionManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSessionManger = new SessionManger(SecondActivity.this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                boolean incominguserType = mSessionManger.checkUserLogin();
//                String.valueOf(incominguserType); <===>  ""+incominguserType
                Toast.makeText(SecondActivity.this, "" + incominguserType, Toast.LENGTH_SHORT).show();

//                get the registered value in the session manager
                String registeredEmail = mSessionManger.checkUserLoggedEmail();
                Toast.makeText(SecondActivity.this, registeredEmail, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int  id  = item.getItemId();

        switch (id){
            case R.id.opt_menu_logout:

//                this will log the user out of the session and will open the login page
                mSessionManger.logoutOldValues();
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
                finish();


                break;
        }

        return true;
    }
}
