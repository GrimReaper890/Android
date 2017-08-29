package com.grimreaper.addandsessionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
Button btnShowAdz;
    AdRequest mAdRequest;
InterstitialAd minterstitialAd;


    EditText edtTxtEmail,edtTxtPass;
    String incomingEmail,incomingPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowAdz = (Button) findViewById(R.id.btn_show_adz);
        edtTxtEmail = (EditText) findViewById(R.id.edt_txt_email);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_pass);


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
              if(minterstitialAd.isLoaded()){
                  minterstitialAd.show();
              }else{
                  Toast.makeText(MainActivity.this, "add will be loaded in a sec", Toast.LENGTH_SHORT).show();
                  minterstitialAd.loadAd(mAdRequest);
              }

              incomingEmail=edtTxtEmail.getText().toString();
              incomingPass=edtTxtPass.getText().toString();


            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(minterstitialAd.isLoaded()){
            minterstitialAd.show();
        }
    }
}
