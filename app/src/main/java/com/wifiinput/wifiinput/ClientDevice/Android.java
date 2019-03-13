package com.wifiinput.wifiinput.ClientDevice;

import com.wifiinput.wifiinput.ClientDevice.JavascriptBuilder.JavascriptHelper;
import com.wifiinput.wifiinput.Utils.Utils;

public class Android {

    public static String getContent() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(JavascriptHelper.HeaderInfo);

        StringBuffer bodyBuffer = new StringBuffer();
        bodyBuffer.append("<style>");
        bodyBuffer.append("*{margin: auto;padding: 0;-webkit-box-sizing: border-box;box-sizing: border-box;}.center{margin-top: 100px;height: 200px;width: 400px;position: relative;}.crossCenter{background-color: #333333;width: 80px;height: 80px;margin-top: 110px;margin-left: 100px;position: relative;}#crossCircle{background-color: #333333;width: 65px;height: 65px;position: absolute;border-radius: 100%;margin-top: 10px;margin-left: 5px;}#crossTop{background-color: #333333;width: 80px;height: 80px;position: absolute;border-radius: 15%;margin-top: -70px;}#crossBottom{background-color: #333333;width: 80px;height: 80px;position: absolute;border-radius: 15%;margin-top: 70px;}#crossLeft{background-color: #333333;width: 110px;height: 80px;position: absolute;border-radius: 15%;margin-left: -70px;}#crossRight{background-color: #333333;width: 110px;height: 80px;position: absolute;border-radius: 15%;margin-left: 39px;}");
        bodyBuffer.append("</style>");

        bodyBuffer.append("<script>var pressTimer; $(document).on('pageinit', function(){$('#test').on('input',function(e){$.ajax({url:'");
        bodyBuffer.append(Utils.ipAdd);
        bodyBuffer.append(Utils.port);
        bodyBuffer.append("/', type: 'POST', data:{ charValue: $('#test').val().charCodeAt(1)}, success: function(data) {$('#test').val('#');$('form').submit( function(){return false;} )}, cache:false, contentType:false,procesData:false })});});");

        bodyBuffer.append("$(document).on('pageshow', function(){ $('#test').focus();");

        bodyBuffer.append("$('#crossTop').on('touchstart mousedown', function(){pressTimer = setInterval(function(){");
        bodyBuffer.append(ajaxBuilder("19"));
        bodyBuffer.append("},200);");
        bodyBuffer.append(ajaxBuilder("19"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append("$('#crossTop').on('touchend mouseup', function(){clearTimeout(pressTimer); $('#test').val('#'); return false;});");

        bodyBuffer.append("$('#crossBottom').on('touchstart mousedown', function(){pressTimer = setInterval(function(){");
        bodyBuffer.append(ajaxBuilder("20"));
        bodyBuffer.append("},200);");
        bodyBuffer.append(ajaxBuilder("20"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append("$('#crossBottom').on('touchend mouseup', function(){clearTimeout(pressTimer); $('#test').val('#'); return false;});");

        bodyBuffer.append("$('#crossLeft').on('touchstart mousedown', function(){pressTimer = setInterval(function(){");
        bodyBuffer.append(ajaxBuilder("21"));
        bodyBuffer.append("},200);");
        bodyBuffer.append(ajaxBuilder("21"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append("$('#crossLeft').on('touchend mouseup', function(){clearTimeout(pressTimer); $('#test').val('#'); return false;});");

        bodyBuffer.append("$('#crossRight').on('touchstart mousedown', function(){pressTimer = setInterval(function(){");
        bodyBuffer.append(ajaxBuilder("22"));
        bodyBuffer.append("},200);");
        bodyBuffer.append(ajaxBuilder("22"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append("$('#crossRight').on('touchend mouseup', function(){clearTimeout(pressTimer); $('#test').val('#'); return false;});");

        bodyBuffer.append("$('#crossCircle').on('touchstart mousedown', function(){pressTimer = setInterval(function(){");
        bodyBuffer.append(ajaxBuilder("-5"));
        bodyBuffer.append("},200);");
        bodyBuffer.append(ajaxBuilder("-5"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append("$('#crossCircle').on('touchend mouseup', function(){clearTimeout(pressTimer); $('#test').val('#'); return false;});");

        bodyBuffer.append("});</script>");
        stringBuffer.append(bodyBuffer);

        String FootInfo = "</head><body><textarea rows='2' cols = '50' autocomplete='off' class = 'test1' type='text' id='test' name='foo' value='#'>#</textarea><div class='center'><div class='crossCenter'><Button id='crossTop'></Button><Button id='crossBottom'></Button><Button id='crossLeft'></Button><Button id='crossRight'></Button><Button id='crossCircle'></Button></div></div></body></html>";

        stringBuffer.append(FootInfo);
        Utils.printLog(stringBuffer.toString());

        return stringBuffer.toString();
    }

    private static StringBuffer ajaxBuilder(String value){
        StringBuffer result = new StringBuffer();
        result.append("$.ajax({url:'");
        result.append(Utils.ipAdd);
        result.append(Utils.port);
        result.append("/', type: 'POST', data:{ charValue: '");
        result.append(value);
        result.append("'},cache:false, contentType:false, procesData:false});");
        return result;
    }
}
