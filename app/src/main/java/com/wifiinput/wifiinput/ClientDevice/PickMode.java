package com.wifiinput.wifiinput.ClientDevice;

import com.wifiinput.wifiinput.ClientDevice.JavascriptBuilder.JavascriptHelper;
import com.wifiinput.wifiinput.Utils.Utils;

public class PickMode {

    public static String getContent() {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(JavascriptHelper.HeaderInfo);
        stringBuffer.append("<style>*{margin: auto;padding: 0;webkit-box-sizing: border-box;box-sizing: border-box;}.center {appearance: none;-moz-appearance: none;-webkit-appearance: none;height: 30px;width: 200px;left:50%;top: 50%;margin-top: -15px;margin-left: -100px;position: absolute;}</style>");

        stringBuffer.append("<script>$(document).on('pageshow', function(){");
        stringBuffer.append(onActionHelper("gameMode","GAME"));
        stringBuffer.append(onActionHelper("keyboardMode","KEYBOARD"));
        stringBuffer.append("});</script>");

        stringBuffer.append("</head><body><div class='center'><Button id='gameMode'>Game Mode</Button><Button id='keyboardMode'>Keyboard Mode</Button></div></body></html>");


        return stringBuffer.toString();
    }

    private  static StringBuffer onActionHelper(String buttonID, String mode){

        StringBuffer result = new StringBuffer();

        result.append("$('#");
        result.append(buttonID);
        result.append("').on('touchstart mousedown',function(){");
        result.append("$.ajax({headers:{Accept:'text/html', 'Content-Type':'text/html'},url:'");
        result.append(Utils.ipAdd);
        result.append(Utils.port);
        result.append("/', type: 'POST', dataType : 'html', data:{mode: '");
        result.append(mode);
        result.append("'},cache:false, procesData:false, success: function(data) {$('html').html(data);}});});");

        return result;
    }
}
