package com.wifiinput.wifiinput.ActionListener;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

import com.wifiinput.wifiinput.Utils.Utils;

public class KeyboardActionListener implements KeyboardView.OnKeyboardActionListener{

    InputMethodService inputMethodService;

    public KeyboardActionListener(InputMethodService inputMethodService){
        this.inputMethodService = inputMethodService;
    }

    @Override
    public void onPress(int i) {}

    @Override
    public void onRelease(int i) {}

    @Override
    public void onKey(int primaryCode, int[] codes) {
        Utils.printLog(getClass().getName() + " is called");
        InputConnection inputConnection = inputMethodService.getCurrentInputConnection();
        if(inputConnection != null){
            switch (primaryCode){
                case Keyboard.KEYCODE_DELETE :
                    CharSequence selectedText = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                    break;
                case Keyboard.KEYCODE_DONE:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case KeyEvent.KEYCODE_DPAD_LEFT :
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_LEFT));
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_RIGHT));
                    break;
                case KeyEvent.KEYCODE_DPAD_UP:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_UP));
                    break;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_DOWN));
                    break;
                case KeyEvent.KEYCODE_BUTTON_START:
                    if(Utils.gameMode) {
                        inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_START));
                        break;
                    }
                case KeyEvent.KEYCODE_BUTTON_Y:
                    if(Utils.gameMode) {
                        inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_Y));
                        break;
                    }
                case KeyEvent.KEYCODE_BUTTON_A:
                    if(Utils.gameMode) {
                        inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_A));
                        break;
                    }
                case KeyEvent.KEYCODE_BUTTON_X:
                    if(Utils.gameMode) {
                        inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_X));
                        break;
                    }
                case KeyEvent.KEYCODE_BUTTON_B:
                    if(Utils.gameMode) {
                        inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_B));
                        break;
                    }
                default :
                    char code = (char) primaryCode;
                    Utils.printLog("what is the code " + code);
                    inputConnection.commitText(String.valueOf(code), 1);
            }
        }
    }

    @Override
    public void onText(CharSequence charSequence) {}

    @Override
    public void swipeLeft() {}

    @Override
    public void swipeRight() {}

    @Override
    public void swipeDown() {}

    @Override
    public void swipeUp() {}
}
