package com.grimreaper.sessionmanagerpower;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by grimReaper on 8/22/2017.
 */

public class mySessionManager {

    SharedPreferences.Editor mEditor;
    SharedPreferences mPref;
    public static final String PREF_NAME = "my_login_pref";
    public static final String PREF_KEY = "USER_LOGIN_KEY";
    public static final int PREF_MODE = 0;
    Context mContext;

    public mySessionManager(Context mContext) {
        this.mContext = mContext;
        mPref = mContext.getSharedPreferences(PREF_NAME, PREF_MODE);
        mEditor = mPref.edit();
    }

    public void logTheUser(Boolean islogin, String userName, String Password) {


    }
}
