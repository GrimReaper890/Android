package com.grimreaper.dbBackend;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by grimReaper on 8/1/2017.
 */

public class DBMS extends SQLiteOpenHelper {


    public static String DBNAME = "UserDb";
    public static int DBVersion = 1;

    public String CreateRegTableQuery  = "CREATE TABLE  reg_user_table(pName TEXT,pFname TEXT,pPassword TEXT,pADDRESS TEXT)";

    public DBMS(Context context) {
        super(context,DBNAME,null,DBVersion);
        Log.e("DBMS=>","DB bn gai ha");
    }

    //    ONCREATE ALWAYS RUN ONCE IN APPLICATION LIFECYCLE ON A DEVICE
//    IT CREATES DB STRUCTURE
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateRegTableQuery);
        Log.e("ONCREATE=>","yes ma chl geya tbl bn geya");
    }
//ONUPGRADE ONLY RUNS WHEN DB STRUCTURE Is Updated....

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    insert a new USER into database
    public void regNewUser(String Name,String FName,String Passsword,String Address,SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put("pName",Name);
        cv.put("pFname",FName);
        cv.put("pPassword",Passsword);
        cv.put("pADDRESS",Address);
        db.insert("reg_user_table",null,cv);
        Log.e("regNewUser=>","yes we added a new user Successfully");
    }
}
