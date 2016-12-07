package com.bwf.aiyiqi.kitutils;

/**
 * Created by lmw on 2016/11/24.
 */

public interface Apis {
    /**
     * home page viewpager
     **/
    String HOME_VIEWPAGER = "http://appapi.17house.com/AppManagerApi.php?version=1&action=getownerinfo&cityId=2&model=android";
    /**home page load first page**/
    String HOME_BBS_BASE = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id=1218226&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type=3&page=1&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    /**home page load more gage**/
    String HOME_BBS_MORE = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id={0}&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type={1}&page={2}&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";

    /**帖子详情**/
    String BBS = "http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=330&uuid=86305803367590&tid={0}&m=forum&haspermission=yes&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
    /**帖子赞列表**/
    String BBS_LICKED = "http://bbs.17house.com/motnt/index.php?a=threadZan&c=forumThread&uuid=86305803367590&tid={0}&uid=1633055&m=forum&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    /**帖子评论列表**/
    String BBS_COMMENTS = "http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=270&uuid=86305803367590&pageSize=10&tid={0}&uid=1633055&m=forum&type=post&page={1}&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    /**新闻详情**/
    String NEWS = "http://appapi.17house.com/NewsApi.php?version=1&newsId={0}&page=1&action=newsDetail&relatedNum=3&model=android";
    /**新闻评论**/
    String NEWS_COMMENTS = "http://appapi.17house.com/newsApi.php?version=1&page=1&dataId={0}&action=commentList&limit=10&model=android";
    /**搜索**/
    String SEARCH = "http://bbs.17house.com/motnt/index.php?a=searchForum&c=search&uuid=86305803367590&pageSize=10&m=search&page={0}&haspermission=yes&kw={1}&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";

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
