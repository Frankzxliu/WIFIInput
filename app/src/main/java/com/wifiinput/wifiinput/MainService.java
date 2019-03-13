package com.wifiinput.wifiinput;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.wifiinput.wifiinput.ActionListener.KeyboardActionListener;
import com.wifiinput.wifiinput.ClientDevice.GameMode;
import com.wifiinput.wifiinput.Network.Server;
import com.wifiinput.wifiinput.Utils.Utils;

import java.io.IOException;

public class MainService extends InputMethodService{

    Server androidWebServer;

    public MainService(){
        super();
        Utils.printLog(GameMode.getContent());
        final KeyboardActionListener keyboardActionListener = new KeyboardActionListener(this);
        final Utils utils = new Utils();
        final Context context = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Utils.ipAdd = getIpAccess();

                androidWebServer = new Server(Utils.port);
                androidWebServer.setKeyboardActionListener(keyboardActionListener);
                try {
                    androidWebServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Utils.printLog(getClass().getName() + " " + Utils.ipAdd);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainService.this.getApplicationContext(),Utils.ipAdd+Utils.port,Toast.LENGTH_LONG).show();
                    }
                });
            }
        },1000);
    }

    private String getIpAccess() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
        final String formatedIpAddress = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
        return "http://" + formatedIpAddress + ":";
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopAndroidWebServer();
    }

    private boolean stopAndroidWebServer() {
        if (androidWebServer != null) {
            androidWebServer.stop();
            return true;
        }
        return false;
    }
}
