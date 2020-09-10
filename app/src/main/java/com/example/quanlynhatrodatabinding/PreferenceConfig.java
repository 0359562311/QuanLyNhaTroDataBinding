package com.example.quanlynhatrodatabinding;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceConfig {
    private static SharedPreferences sp;

    public static void putAccount(Context context, String account){
        sp = context.getSharedPreferences(context.getApplicationInfo().name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("account",account);
        editor.apply();
    }

    public static String getAccount(Context context){
        sp = context.getSharedPreferences(context.getApplicationInfo().name,Context.MODE_PRIVATE);
        return sp.getString("account",null);
    }

    public static SharedPreferences getInstance(Context context){
        return context.getSharedPreferences(context.getApplicationInfo().name,Context.MODE_PRIVATE);
    }
}
