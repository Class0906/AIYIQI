package com.bwf.aiyiqi.kitutils;

/**
 * Created by lmw on 2016/11/24.
 */

public interface Apis {
    /**home page viewpager**/
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
}
