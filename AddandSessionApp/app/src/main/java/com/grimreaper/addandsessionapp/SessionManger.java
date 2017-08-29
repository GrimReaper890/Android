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
    public SessionManger(Context mContext){
        mPref = mContext.getSharedPreferences(mPrefLabel,mPrefMode);
        mPrefEditor=  mPref.edit();
    }

}
