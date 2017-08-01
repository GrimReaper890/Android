package com.grimreaper;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.grimreaper.dbBackend.DBMS;

public class MainActivity extends AppCompatActivity {
    // for database helper
    SQLiteDatabase db;
    DBMS dbms;

    EditText edtTxtName, edtTxtFName, edtTxtPass, edtTxtAddress;
    String pName, pFName, pPass, pAddress;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbms = new DBMS(MainActivity.this);

        edtTxtName = (EditText) findViewById(R.id.edt_txt_name);
        edtTxtFName = (EditText) findViewById(R.id.edt_txt_fname);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_pass);
        edtTxtAddress = (EditText) findViewById(R.id.edt_txt_adress);

        btnRegister = (Button) findViewById(R.id.btn_register);

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
                    db = dbms.getWritableDatabase();
                    dbms.regNewUser(pName,pFName,pPass,pAddress,db);
                    Toast.makeText(MainActivity.this, "Yes you are Register my BOY!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
