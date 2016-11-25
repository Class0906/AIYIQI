package com.bwflmw.framwork.utils;


/**
 * Created by lmwxq on 2016/10/26.
 * 用来转换url
 */

public class UrlHandler {
    /**
     * @param url http://api.eqingdan.com/v1/categories/nursing/articles?page={0}
     * @param params 10
     * @return  http://api.eqingdan.com/v1/categories/nursing/articles?page=10
     */
    public static final String handleUrl(String url, Object... params){
        for (int i = 0; i < params.length; i++) {
            url = url.replace("{"+i+"}",params[i]+"");
        }
        return url;
    }
}
