package com.bwf.aiyiqi.kitutils;

/**
 * Created by lmw on 2016/11/24.
 */

public interface Apis {
    /**
     * home page viewpager
     **/
    String HOME_VIEWPAGER = "http://appapi.17house.com/AppManagerApi.php?version=1&action=getownerinfo&cityId=2&model=android";
    /**
     * home page load first page
     **/
    String HOME_BBS_BASE = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id=1218226&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type=3&page=1&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    /**
     * 2
     * home page load more gage
     **/
    String HOME_BBS_MORE = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id=1218226&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type=3&page=2&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";

    /**装修界面数据接口*/
    /**
     * 轮播
     */
    String FITMENT_VIEWPAGER = " http://appapi.17house.com/AppManagerApi.php?version=1&action=integratedpackage&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
    /**
     * 装修直播
     */
    String FITMENT_SEEDING = "  http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites";
    /**
     * H5新房整装
     */
    String FITMENT_NEWHOSE = "http://hui.17house.com/svc/payment-facade/h5/activity677/index.html?model=android";

    /**
     * 老方整装
     */
    String FITMENT_OLDHOUSE = "http://hui.17house.com/svc/payment-facade/h5/activity177/index.html?model=android";
    /**
     * 工地直播
     */
    String FITMENT_LIVE = "http://hui.17house.com/svc/payment-facade/housekeep/getLiveBuildingSite";
    /**
     * 一起团队
     */
    String FITMENT_TEAM = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors";
    /**
     * 同城活动
     */
    String THE_SAME = "http://bbs.17house.com/motnt/index.php?a=activityThreadlist&c=forumThreadList&uuid=a444d1b2af4f&pageSize=10&uid=1633055&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    /**
     * 设计量房
     */
    String DESIGN_ROOM_FIRST = " http://hui.17house.com/svc/payment-facade/h5/measureDesignFree/measureFree.html?model=android";
    /**
     * 设计量房
     */
    String DESIGN_ROOM_SEND = "http://hui.17house.com/svc/payment-facade/h5/measureDesignFree/designFree.html?model=android";
    /**
     * 效果图专题
     */
    String EFFECT_SPECOAL = "http://appapi.17house.com/xiaoguotuApi.php?version=1&page=1&action=albumList2&pageSize=10&tagid=1&model=android";
    /**
     * 效果图美图
     */
    String EFFECT_PICTURE = "http://appapi.17house.com/xiaoguotuApi.php?version=1&page=1&action=imageList2&pageSize=10&tagid=0&model=android";
    /**
     * 建材家居
     */
    String HOME_FURNITURE = "http://bbs.17house.com/motnt/index.php?a=product&m=misc&model=android&uuid=a444d1b2af4f&app_version=android_com.aiyiqi.galaxy_1.1";

    /**
     * 装修报价
     */
    String BUDGET_SPECOAL = "http://m.beijing.17house.com/baojia/?sem=android&model=android";
}
