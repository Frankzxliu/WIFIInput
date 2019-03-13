package com.wifiinput.wifiinput.ClientDevice;

import com.wifiinput.wifiinput.ClientDevice.JavascriptBuilder.JavascriptHelper;
import com.wifiinput.wifiinput.Utils.Utils;

public class Windows {

    public static String getContent() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(JavascriptHelper.HeaderInfo);

        StringBuffer bodyBuffer = new StringBuffer();
        bodyBuffer.append("<script>$(document).on('pageinit', function(){$('#test').on('textInput',function(e){$.ajax({url:'");
        bodyBuffer.append(Utils.ipAdd);
        bodyBuffer.append(Utils.port);
        bodyBuffer.append("/',type: 'POST', data: {charValue:e.originalEvent.data.charCodeAt(0)}, success: function(data){$('#test').val('')}, cache:false, contentType:false,procesData:false })});");

        bodyBuffer.append("$('#test').on('keyup', function(e){if (e.keyCode == 13){$.ajax({url: '");
        bodyBuffer.append(Utils.ipAdd);
        bodyBuffer.append(Utils.port);
        bodyBuffer.append("/', type: 'POST', data: {charValue:'-4'}, success: function(data) {$('#test').val('')}, error: function(){$('#test').val('')} ,cache:false, contentType:false,procesData:false });}});");

        bodyBuffer.append("$('#test').on('keydown', function(e){var keyAction; if(e.keyCode == 8){keyAction = '-5';}else if(e.keyCode == 37){keyAction='21';}else if(e.keyCode == 38){keyAction='19';}else if(e.keyCode == 39){keyAction='22';}else if(e.keyCode == 40){keyAction='20';}{$.ajax({url: '");
        bodyBuffer.append(Utils.ipAdd);
        bodyBuffer.append(Utils.port);
        bodyBuffer.append("/', type: 'POST', data: {charValue:keyAction}, success: function(data) {$('#test').val('')}, error: function(){$('#test').val('')},cache:false, contentType:false,procesData:false }); }});  }); $(document).on('pageshow', function(){ $('#test').focus();});</script>");

        stringBuffer.append(bodyBuffer);
        stringBuffer.append(JavascriptHelper.FootInfo);

        return stringBuffer.toString();
    }
}
