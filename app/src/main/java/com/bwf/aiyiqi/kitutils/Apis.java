package com.bwf.aiyiqi.kitutils;

/**
 * Created by lmw on 2016/11/24.
 */

public interface Apis {
    /**home page viewpager**/
    String HOME_VIEWPAGER = "http://appapi.17house.com/AppManagerApi.php?version=1&action=getownerinfo&cityId=2&model=android";
    /**home page load first page**/
    String HOME_BBS_BASE = "http://118.178.142.34/YiQiHouse/HomeBBS?page=1";
    /**home page load more gage**/
    String HOME_BBS_MORE = "http://118.178.142.34/YiQiHouse/HomeBBS?page={0}&type={1}&id={2}";

    String HHH = "http://appapi.17house.com/AppManagerApi.php?version=1&action=integratedpackage&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
}
