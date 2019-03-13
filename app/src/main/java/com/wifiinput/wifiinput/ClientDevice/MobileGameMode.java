package com.wifiinput.wifiinput.ClientDevice;

import com.wifiinput.wifiinput.ClientDevice.JavascriptBuilder.JavascriptHelper;
import com.wifiinput.wifiinput.Utils.Utils;

public class MobileGameMode {

    public static String getContent() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(JavascriptHelper.HeaderInfo);

        StringBuffer bodyBuffer = new StringBuffer();
        bodyBuffer.append("<script src='//yoannmoinet.github.io/nipplejs/javascripts/nipplejs.js'></script>");
        bodyBuffer.append("<style>");
        bodyBuffer.append("*{margin: auto;padding: 0;webkit-box-sizing: border-box;box-sizing: border-box;}body{background-color: #FEFEFE;}.controller{margin-top: 100px;height: 200px;width: 400px;background-color: #E6E6E6;position: relative;box-shadow: 15px 15px 15px rgba(0,0,0,0.2);}.controllerLeft{height: 250px;width: 250px;background-color: #E6E6E6;position: absolute;border-radius: 100%;margin-left: -125px;box-shadow: -15px 8px 15px rgba(0,0,0,0.2);}.controllerRight{height: 250px;width: 250px;background-color: #B8B8B8;position: relative;border-radius: 100%; margin-right:-125px;border: solid 15px rgba(230, 230, 230,1);box-shadow: 15px 8px 15px rgba(0,0,0,0.2);}.circle{height: 150px;width: 150px;background-color: #E6E6E6;position: absolute;border-radius: 100%;border: solid 5px rgba(184, 184, 184, 1);margin-left: 42px;margin-top:52px;}.crossCenter{background-color: #333333;width: 35px;height: 35px;margin-top: 110px;margin-left: 100px;position: relative;}.crossCircle{background-color: #292929;width: 25px;height: 25px;position: absolute;border-radius: 100%;margin-top: 5px;margin-left: 5px;}.crossTop{background-color: #333333;width: 35px;height: 35px;position: absolute;border-radius: 15%;margin-top: -30px;}.crossBottom{background-color: #333333;width: 35px;height: 35px;position: absolute;border-radius: 15%;margin-top: 30px;}.crossLeft{background-color: #333333;width: 35px;height: 35px;position: absolute;border-radius: 15%;margin-left: -30px;}.crossRight{background-color: #333333;width: 35px;height: 35px;position: absolute;border-radius: 15%;margin-left: 30px;}.centerHome{  position: absolute;width: 50px;height: 20px;margin-left: 175px;margin-top: 30px;background-color: #0099FF;}.centerLeft{  position: absolute;width: 20px;height: 20px;margin-left: -10px;margin-top: 0px;background-color: #0099FF;border-radius: 100%;}.centerRight{position: absolute;width: 20px;height: 20px;margin-left: 40px;margin-top: 0px;background-color: #0099FF;border-radius: 100%;}.backButton1Center{position: absolute;width: 80px;height: 50px;background-color: #E6E6E6;-webkit-transform: rotate(-30deg);margin-top: 60px;margin-left: 45px;}.backButton2Center{position: absolute;width: 80px;height: 50px;background-color: #E6E6E6;-webkit-transform: rotate(-30deg);margin-top: 115px;margin-left: 90px;}.cornerLeftX{position: absolute;width: 50px;height: 50px;background-color: #00B800;border-radius: 100%;margin-left: -20px;border: solid 5px rgba(230, 230, 230, 1)}.cornerRightY{position: absolute;width: 50px;height: 50px;background-color: #6699FF;border-radius: 100%;margin-left: 60px;border: solid 5px rgba(230, 230, 230, 1)}.cornerLeftA{position: absolute;width: 50px;height: 50px;background-color: #CFCF00;border-radius: 100%;margin-left: -20px;border: solid 5px rgba(230, 230, 230, 1)}.cornerRightB{position: absolute;width: 50px;height: 50px;background-color: #7D230D;border-radius: 100%;margin-left: 60px;border: solid 5px rgba(230, 230, 230, 1)}.centerSelect{background-color: #B8B8B8;position: absolute;height: 35px;width: 60px;margin-left: 130px;margin-top: 110px;}.centerStart{background-color: #B8B8B8;position: absolute;height: 35px;width: 60px;margin-left: 205px;margin-top: 110px;}.SLeft{background-color: #B8B8B8;position: absolute;border-radius: 100%;height: 10px;width: 10px;margin-top: 30px;}.SRight{background-color: #B8B8B8;position: absolute;border-radius: 100%;height: 10px;width: 10px;margin-top: -5px;}.cable{background-color: black;width: 10px;height: 150px;position: absolute;margin-left: 49.7%;margin-top: -100px;box-shadow: 7px 8px 15px rgba(0,0,0,0.2);}");
        bodyBuffer.append("</style><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'>");
        bodyBuffer.append("<script>$(document).on('pageshow', function(){");

        bodyBuffer.append(joystick());

//        bodyBuffer.append("$('.crossTop').on('touchstart mousedown', function(){");
//        bodyBuffer.append(ajaxBuilder("19"));
//        bodyBuffer.append("return false;});");
//        bodyBuffer.append(cancelAction("crossTop"));
//
//        bodyBuffer.append("$('.crossBottom').on('touchstart mousedown', function(){");
//        bodyBuffer.append(ajaxBuilder("20"));
//        bodyBuffer.append("return false;});");
//        bodyBuffer.append(cancelAction("crossBottom"));
//
//        bodyBuffer.append("$('.crossLeft').on('touchstart mousedown', function(){");
//        bodyBuffer.append(ajaxBuilder("21"));
//        bodyBuffer.append("return false;});");
//        bodyBuffer.append(cancelAction("crossLeft"));
//
//        bodyBuffer.append("$('.crossRight').on('touchstart mousedown', function(){");
//        bodyBuffer.append(ajaxBuilder("22"));
//        bodyBuffer.append("return false;});");
//        bodyBuffer.append(cancelAction("crossRight"));


        bodyBuffer.append("$('.centerSelect').on('touchstart mousedown', function(){");
        bodyBuffer.append(ajaxBuilder("-4"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append(cancelAction("centerStart"));

        bodyBuffer.append("$('.centerStart').on('touchstart mousedown', function(){");
        bodyBuffer.append(ajaxBuilder("108"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append(cancelAction("centerStart"));

        bodyBuffer.append("$('.cornerLeftA').on('touchstart mousedown', function(){");
        bodyBuffer.append(ajaxBuilder("96"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append(cancelAction("cornerLeftA"));


        bodyBuffer.append("$('.cornerRightB').on('touchstart mousedown', function(){");
        bodyBuffer.append(ajaxBuilder("97"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append(cancelAction("cornerRightB"));


        bodyBuffer.append("$('.cornerLeftX').on('touchstart mousedown', function(){");
        bodyBuffer.append(ajaxBuilder("99"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append(cancelAction("cornerLeftX"));


        bodyBuffer.append("$('.cornerRightY').on('touchstart mousedown', function(){");
        bodyBuffer.append(ajaxBuilder("100"));
        bodyBuffer.append("return false;});");
        bodyBuffer.append(cancelAction("cornerRightY"));

        bodyBuffer.append("})</script></head><body>");

        stringBuffer.append(bodyBuffer);

        String FootInfo = "<div class='controller'><Button class='centerHome'>HOME</Button><Button class='centerSelect'>SELETE</Button><Button class='centerStart'>START</Button> <div id='zone_joystick'></div><div class='controllerLeft'><div class='circle'></div><div class='crossCenter'><Button class='crossTop'></Button><Button class='crossBottom'></Button><Button class='crossLeft'></Button><Button class='crossRight'></Button><div class='crossCircle'></div></div></div><div class='controllerRight'><div class='backButton1Center'><Button class= 'cornerLeftX'>X</Button><Button class= 'cornerRightY'>Y</Button></div><div class='backButton2Center'><Button class= 'cornerLeftA'>A</Button><Button class= 'cornerRightB'>B</Button></div></div></div></body></html>";
        stringBuffer.append(FootInfo);

        Utils.printLog(stringBuffer.toString());

        return stringBuffer.toString();

    }

    private static StringBuffer joystick(){
        StringBuffer result = new StringBuffer();
        //result.append("var radius = 100;var sampleJoystick = {mode: 'static',zone: document.getElementById('zone_joystick'),position: {top: '127px'},size: radius*2,color: 'black'};var joystick;var position;joystick = nipplejs.create(sampleJoystick);joystick.on('start end',function(evt, data) {position = data;}).on('move', function(evt, data) {position = data;}).on('dir:up plain:up dir:left plain:left dir:down' +'plain:down dir:right plain:right',function(evt, data) {position=data;}).on('pressure', function(evt, data) {position=data;});");
        result.append("var radius = 50;var sampleJoystick = {mode: 'static',zone: document.getElementById('zone_joystick'),position: {top: '127px'},size: radius*2,color: 'black'};var joystick;var position;joystick = nipplejs.create(sampleJoystick);joystick");
        result.append(onBuilder("dir:up","19"));
        result.append(onBuilder("dir:down","20"));
        result.append(onBuilder("dir:left","21"));
        result.append(onBuilder("dir:right","22"));
        result.append(onBuilder("end","32"));
        result.append(";");
        return result;
    }

    private static StringBuffer cancelAction(String key){
        StringBuffer result = new StringBuffer();
        result.append("$('.");
        result.append(key);
        result.append("').on('touchend mouseup', function(){");
        result.append(ajaxBuilder("32"));
        result.append("return false;});");

        return result;
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

    private static StringBuffer onBuilder(String key, String value){
        StringBuffer result = new StringBuffer();
        result.append(".on('");
        result.append(key);
        result.append("',function(evt,data){");
        //result.append(ajaxBuilder("32"));//cancel the action before next move
        result.append(ajaxBuilder(value));
        result.append("})");
        return result;
    }
}