package com.grimreaper.serverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btnGetDataFromServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetDataFromServer = (Button) findViewById(R.id.btn_get_server_data);

        btnGetDataFromServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromServer();
            }
        });

    }



//    we made a method with a request and  a qaeue in it
    private void getDataFromServer(){
//        METHOD TYPES TO GET DATA FROM SERVER ARE MAJOR OF TWO TYPEs
//        POST ===1 AND GET ===0
//        POST IS SECURE AND GET IS LESS SECURE
//        in get Request all parameters are attached/concatenated with the web URL
//        while in case of POST ALL PARAMS GO IN BODY TAGS not in the url
//        "URL RULES"==>  no localhost in andorid
//                        port is necessary only in localhost case
//        in android 127.0.0.1 or localhost are EQUAL TO ==> 10.0.2.2 in case of emulator
//        IPCONFIG YOUR SYSTEM URL
//        getApplicationContext().getResources().getString(R.string.get_from_server_url) ===> equals to writing  "http://10.0.2.2:8080/voley/testfile.php"
        StringRequest stringRequest = new StringRequest(Request.Method.POST, getApplicationContext().getResources().getString(R.string.get_from_server_url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                how to convert something into a string
//                number one CLASSic thing is toString()
//                String.valueOf(5055);
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

    }
}
