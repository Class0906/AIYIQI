package com.bwf.aiyiqi.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseNews;
import com.bwf.aiyiqi.entity.ResponseNewsComments;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.NewsModel;
import com.bwflmw.framwork.utils.UrlHandler;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by lmw on 2016/12/1.
 */

public class NewsModelImpl implements NewsModel {
    @Override
    public void loadNewsData(String newsId, final NewsCallback callback) {
        OkHttpUtils
                .get()
                .url(UrlHandler.handleUrl(Apis.NEWS,newsId))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseNews data = JSON.parseObject(response, ResponseNews.class);
                        if (data.getError() == 0) {
                            data.getData().setTags(getTags(response));
                            List<ResponseNews.RelatedNewsBean> list = new ArrayList<>();
                            try {
                                JSONObject object = new JSONObject(response);
                                JSONObject object1 = object.getJSONObject("data");
                                JSONArray array = object1.getJSONArray("relatedNews");
                                for (int i=0;i<array.length();i++){
                                    JSONObject obj = (JSONObject) array.get(i);
                                    ResponseNews.RelatedNewsBean bean = new ResponseNews.RelatedNewsBean();
                                    bean.setTitle(obj.getString("title"));
                                    bean.setThumb(obj.getString("thumb"));
                                    bean.setClick(obj.getInt("click"));
                                    bean.setComment_count(obj.getString("comment_count"));
                                    bean.setFavNums(obj.getInt("favNums"));
                                    list.add(bean);
                                }
                                data.setRelatedNews(list);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            callback.onSuccess(data);
                        }else
                            callback.onFailed();
                    }
                });
    }

    @Override
    public void loadNewsCommentsData(String newsId, final NewsCommentCallback callback) {
        OkHttpUtils
                .get()
                .url(UrlHandler.handleUrl(Apis.NEWS_COMMENTS,newsId))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseNewsComments data = JSON.parseObject(response, ResponseNewsComments.class);
                        if (data.getError()==0){
                            callback.onSuccess(data);
                        }else
                            callback.onFailed();
                    }
                });
    }
    /**
     * 提取动态tags
     */
    private Map<String,String> getTags(String data){
        Map<String ,String> tagsMap = new HashMap<>();
        try {
            JSONObject tags = new JSONObject(data)
                    .getJSONObject("data")
                    .getJSONObject("tags");
            Iterator<String> keys = tags.keys();
            while (keys.hasNext()){
                String key = keys.next();
                JSONObject o = tags.getJSONObject(key);
                String value = o.getString("name");
                tagsMap.put(key,value);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tagsMap;
    }
}
