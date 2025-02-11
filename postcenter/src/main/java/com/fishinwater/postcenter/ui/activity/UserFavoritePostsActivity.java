package com.fishinwater.postcenter.ui.activity;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fishinwater.base.callback.MyObjCallback;
import com.fishinwater.base.common.RouteUtils;
import com.fishinwater.base.common.preferences.SharedPreferencesUtil;
import com.fishinwater.base.rx.BaseActivity;
import com.fishinwater.postcenter.R;
import com.fishinwater.postcenter.databinding.ActivityUserPostsBinding;
import com.fishinwater.postcenter.model.viewmodel.PostViewModel;
import com.fishinwater.postcenter.model.viewmodel.UserPostsViewModel;
import com.fishinwater.postcenter.ui.recycler.adapter.PostsRecyclerViewAdapter;

@Route(path = RouteUtils.UserFavoritePostsActivity)
public class UserFavoritePostsActivity extends BaseActivity implements MyObjCallback<PostViewModel> {

    ActivityUserPostsBinding binding;

    UserPostsViewModel viewModel;

    PostsRecyclerViewAdapter adapter;

    private static String USER_ID = "user_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_posts);

        binding.pageTitle.setText(R.string.user_favorite);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new UserPostsViewModel(this);
        adapter = new PostsRecyclerViewAdapter(this);
        binding.recycler.setAdapter(adapter);
        String userId = SharedPreferencesUtil.getString(this, SharedPreferencesUtil.PRE_NAME_SITUP,SharedPreferencesUtil.USER_ID);
        viewModel.getUserFavoritePosts(userId, this);
    }

    @Override
    public void action(View view) {

    }

    @Override
    public void onSucceed(PostViewModel bean) {
        adapter.addData(bean);
    }

    @Override
    public void onFailed(String errMsg) {
        Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show();
    }

    public static void actionStart(Context context, String user_id) {
        Intent intent = new Intent();
        intent.setClass(context, UserFavoritePostsActivity.class);
        intent.putExtra(USER_ID, user_id);
        context.startActivity(intent);
    }
}
