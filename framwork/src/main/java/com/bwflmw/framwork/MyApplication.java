package com.bwflmw.framwork;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by lmw on 2016/11/23.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        //fresco初始化
        Fresco.initialize(this);
        initOkHttp();
        myApplication = this;
    }

    /**
     * 配置生成OkhttpClient
     */
    private void initOkHttp(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

    public static MyApplication getMyApplication(){
        return myApplication;
    }

    public static Context getAppContext(){
        return myApplication.getApplicationContext();
    }
}
