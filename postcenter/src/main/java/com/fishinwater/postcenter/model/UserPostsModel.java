package com.fishinwater.postcenter.model;

import android.util.Log;

import com.fishinwater.base.common.ApiUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * @author fishinwater-1999
 * @version 2019-12-12
 */
public class UserPostsModel {

    public void getUserPosts(String user_id, final StringCallback callback) {
        OkHttpUtils.post()
                .url(ApiUtils.GET_USER_POSTS)
                .addParams("user_id", user_id)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(call, e, id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        callback.onResponse(response, id);
                    }
                });
    }

    public void getUserFavorites(String user_id, final StringCallback callback) {
        OkHttpUtils.post()
                .url(ApiUtils.GET_USER_FAVORITE_POSTS)
                .addParams("user_id", user_id)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(call, e, id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        callback.onResponse(response, id);
                    }
                });
    }

    public void getUserCollections(String user_id, final StringCallback callback) {
        OkHttpUtils.post()
                .url(ApiUtils.GET_USER_COLLECT_POSTS)
                .addParams("user_id", user_id)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(call, e, id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        callback.onResponse(response, id);
                    }
                });
    }
}
