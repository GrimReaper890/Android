package com.grimreaper.addandsessionapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by grimReaper on 8/29/2017.
 */

public class SessionManger {

    SharedPreferences mPref;
    SharedPreferences.Editor mPrefEditor;

    public static final String mPrefLabel = "userLoginPref";
    public static final int mPrefMode = 0;

    public SessionManger(Context mContext) {
        mPref = mContext.getSharedPreferences(mPrefLabel, mPrefMode);
        mPrefEditor = mPref.edit();
    }


    // this opens the editor and writes the userType and Emial etc
    public void logNewuser(boolean userPresent, String Email) {
        mPrefEditor.putString("inComingEmail", Email);
        mPrefEditor.putBoolean("incomingUserType", userPresent);
        mPrefEditor.commit();
    }

//    it will return true or false  iski byu default value false
    public boolean checkUserLogin(){
       boolean userPresent =  mPref.getBoolean("incomingUserType",false);
        return userPresent;
    }

//    this will return the user name/email etc if there is none to then ""
    public String checkUserLoggedEmail(){
        String RegisterdValue =    mPref.getString("inComingEmail","");
        return  RegisterdValue;
    }

//    for logout Control we use to revert all the editor's newly entered values to DEFAULT
    public void logoutOldValues(){
        mPrefEditor.putString("inComingEmail", "");
        mPrefEditor.putBoolean("incomingUserType", false);
        mPrefEditor.commit();
    }
}
