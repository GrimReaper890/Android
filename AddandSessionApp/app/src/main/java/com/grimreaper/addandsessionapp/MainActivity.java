package com.grimreaper.addandsessionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    Button btnShowAdz, btnTestPref;
    AdRequest mAdRequest;
    InterstitialAd minterstitialAd;
    //bring that session manager instance here
    SessionManger mSessionManger;

    EditText edtTxtEmail, edtTxtPass;
    String incomingEmail, incomingPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowAdz = (Button) findViewById(R.id.btn_show_adz);
        btnTestPref = (Button) findViewById(R.id.btn_test_pref);
        edtTxtEmail = (EditText) findViewById(R.id.edt_txt_email);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_pass);

//instantiate that session instant always in oNCREATE LIKE THIS
        mSessionManger = new SessionManger(MainActivity.this);


        minterstitialAd = new InterstitialAd(MainActivity.this);

        minterstitialAd.setAdUnitId(getApplicationContext().getResources().getString(R.string.add_unit_id));

        mAdRequest = new AdRequest.Builder().build();

        minterstitialAd.loadAd(mAdRequest);

//        to show in main activity opening page
//        if(minterstitialAd.isLoaded()){
//            minterstitialAd.show();
//        }


        btnShowAdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              if(minterstitialAd.isLoaded()){
//                  minterstitialAd.show();
//              }else{
//                  Toast.makeText(MainActivity.this, "add will be loaded in a sec", Toast.LENGTH_SHORT).show();
//                  minterstitialAd.loadAd(mAdRequest);
//              }

                incomingEmail = edtTxtEmail.getText().toString();
                incomingPass = edtTxtPass.getText().toString();
                if (incomingEmail.isEmpty() || incomingPass.isEmpty()) {
                    edtTxtEmail.setError("fill the form");
                    edtTxtPass.setError("fill the form");

                } else {
                    //this will write the user's email in the editor of prefManager
                    mSessionManger.logNewuser(true, incomingEmail);


                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    finish();
                }

            }
        });


        btnTestPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incominguserType = mSessionManger.checkUserLogin();
//                String.valueOf(incominguserType); <===>  ""+incominguserType
                Toast.makeText(MainActivity.this, "" + incominguserType, Toast.LENGTH_SHORT).show();

//                get the registered value in the session manager
                String registeredEmail = mSessionManger.checkUserLoggedEmail();
                Toast.makeText(MainActivity.this, registeredEmail, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (minterstitialAd.isLoaded()) {
            minterstitialAd.show();
        }
    }
}
