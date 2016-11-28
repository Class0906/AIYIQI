package com.bwflmw.framwork.utils;

import android.widget.Toast;

import com.bwflmw.framwork.MyApplication;

/**
 * Created by lmw on 2016/11/24.
 */

public class ToastUtil {
    public static void toToast(String message){
        Toast.makeText(MyApplication.getAppContext(),message,Toast.LENGTH_SHORT).show();
    }
}
