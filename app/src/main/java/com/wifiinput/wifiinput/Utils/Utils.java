package com.wifiinput.wifiinput.Utils;

import android.util.Log;

import java.util.HashMap;

public class Utils {
    private static final String TAG = "WIFI_INPUT";
    private static boolean debug = true;
    private static String[] deviceType;
    public static int port = 3232;
    public static String ipAdd;
    public static boolean gameMode = false;

    public Utils(){
        deviceType = new String[]{"Android","Windows","Apple"};
    }

    public static void printLog(String msg){
        if(debug) {
            int maxLogSize = 1000;
            for(int i = 0; i <= msg.length() / maxLogSize; i++) {
                int start = i * maxLogSize;
                int end = (i+1) * maxLogSize;
                end = end > msg.length() ? msg.length() : end;
                Log.v(TAG, msg.substring(start, end));
            }
        }
    }

    public static String[] getDeviceType(){
        return deviceType;
    }
}
