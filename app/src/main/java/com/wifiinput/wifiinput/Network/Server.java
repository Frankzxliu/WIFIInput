package com.wifiinput.wifiinput.Network;

import com.wifiinput.wifiinput.ActionListener.KeyboardActionListener;
import com.wifiinput.wifiinput.ClientDevice.Android;
import com.wifiinput.wifiinput.ClientDevice.Windows;
import com.wifiinput.wifiinput.Utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

import static com.wifiinput.wifiinput.Utils.Utils.getDeviceType;
import static com.wifiinput.wifiinput.Utils.Utils.printLog;

public class Server extends NanoHTTPD{

    private KeyboardActionListener keyboardActionListener;

    public Server(int port) {
        super(port);
    }

    public void setKeyboardActionListener(KeyboardActionListener keyboardActionListener){
        this.keyboardActionListener = keyboardActionListener;
    }

    @Override
    public Response serve(IHTTPSession session) {

        //TODO: Let user to pick input or play mode
        Method method = session.getMethod();

        String msg = null;
        String mode = null;
        String userAgent = null;

        StringBuffer sb = new StringBuffer();

        Iterator<Map.Entry<String, String>> iter = session.getHeaders().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if (entry.getKey().equals("user-agent")) {
                userAgent = entry.getValue();
            }
            sb.append(entry.getKey());
            sb.append('=').append('"');
            sb.append(entry.getValue());
            sb.append('"');
            if (iter.hasNext()) {
                sb.append(',').append(' ');
            }
        }

        Utils.gameMode = false;
        String header = sb.toString();
        Utils.printLog(getClass().getName() + " " + header);

        Map<String, String> file = new HashMap<>();
        try {
            session.parseBody(file);
            if (file.toString().contains("=")) {
                if(file.toString().contains("charValue")) {
                    Utils.printLog("value input " + file.toString());
                    String values = file.toString().split("charValue")[1].trim();
                    Utils.printLog("Value is " + values.substring(1, values.length() - 1));
                    int value = Integer.parseInt(values.substring(1, values.length() - 1));
                    Utils.printLog("POST " + value);
                    keyboardActionListener.onKey(value, new int[]{});
                    mode = "";
                }
                else if(file.toString().contains("mode")){
                    Utils.printLog("mode " + file.toString());
                    String values = file.toString().split("mode")[1].trim();
                    Utils.printLog("mode is " + values.substring(1, values.length() - 1));
                    mode = values.substring(1, values.length() - 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ResponseException e) {
            e.printStackTrace();
        }

        /*if(mode == null){
            Utils.printLog("Mode is null, this is called");
            msg = PickMode.getContent();
            Utils.printLog(msg);
            return newFixedLengthResponse(msg);
        }*/

        if (!header.contains("text/html")) {
            Utils.printLog(getClass().getName() + " no text/html is called");
            return newFixedLengthResponse(Response.Status.NO_CONTENT, MIME_HTML, "");
        }

       /* if(mode.equals("GAME")){
            Utils.gameMode = true;
            if (userAgent.contains(getDeviceType()[0])) {
                //Android case
                msg = MobileGameMode.getContent();
            } else if (userAgent.contains(getDeviceType()[1])) {
                //Windows case
                msg = GameMode.getContent();
            }
            else if(userAgent.contains(getDeviceType()[2])){
                //Apple case
                msg = MobileGameMode.getContent();
            }
            printLog("GameMode " + msg);
            return newFixedLengthResponse(msg);
        }*/
        //else if(mode.equals("KEYBOARD")){ //keyboard mode
            if (userAgent.contains(getDeviceType()[0])) {
                //Android case
                msg = Android.getContent();
            } else if (userAgent.contains(getDeviceType()[1])) {
                //Windows case
                msg = Windows.getContent();
            }
            else if(userAgent.contains(getDeviceType()[2])){
                //Apple case
                msg = Android.getContent();
            }
            printLog("Keyboard " + msg);
            return newFixedLengthResponse(msg);
       // }

        /*if (method == Method.GET) {
            // Utils.printLog(Windows.getContent());
            return newFixedLengthResponse(msg);
        }*/

       // return newFixedLengthResponse(Response.Status.NO_CONTENT, MIME_HTML, "");
    }
}
