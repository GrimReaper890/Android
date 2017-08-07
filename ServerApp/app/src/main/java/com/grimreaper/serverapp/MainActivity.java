package com.grimreaper.serverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btnGetDataFromServer;
    EditText edtTxtName, edtTxtFName, edtTxtPass, edtTxtAddress;
    String pName, pFName, pPass, pAddress;
    Button btnRegister,btnGetAllusers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetDataFromServer = (Button) findViewById(R.id.btn_get_server_data);

        edtTxtName = (EditText) findViewById(R.id.edt_txt_name);
        edtTxtFName = (EditText) findViewById(R.id.edt_txt_fname);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_pass);
        edtTxtAddress = (EditText) findViewById(R.id.edt_txt_adress);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnGetAllusers = (Button) findViewById(R.id.btn_get_all_users);




        btnGetDataFromServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromServer();
            }
        });



        //        listner on the button
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pName = edtTxtName.getText().toString();
                pFName = edtTxtFName.getText().toString();
                pPass = edtTxtPass.getText().toString();
                pAddress = edtTxtAddress.getText().toString();

                if (pName.isEmpty() || pFName.isEmpty() || pPass.isEmpty() || pAddress.isEmpty()){
                    edtTxtName.setError("Please fill the complete form");
                    edtTxtFName.setError("Please fill the complete form");
                    edtTxtPass.setError("Please fill the complete form");
                    edtTxtAddress.setError("Please fill the complete form");
                }else{
//                    db wala kam
                    RegisterUserOnServer(pName,pFName,pPass,pAddress);
                }

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


    //    we made a method with a request and  a qaeue in it
    private void RegisterUserOnServer(final String pName, final String pFName, final String pPass, final String pAddress){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.0.2.2:8080/voley/registerUser.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params  = new HashMap<>();
                params.put("PersonName",pName);
                params.put("PersonFName",pFName);
                params.put("PpassWord",pPass);
                params.put("PAddress",pAddress);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }
}
