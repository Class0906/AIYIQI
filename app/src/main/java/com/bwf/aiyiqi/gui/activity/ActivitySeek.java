package com.bwf.aiyiqi.gui.activity;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSearch;
import com.bwf.aiyiqi.gui.adapter.SearchRecyclerAdapter;
import com.bwf.aiyiqi.kitutils.Constant;
import com.bwf.aiyiqi.mvp.presenter.SearchPresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.SearchPresenterImpl;
import com.bwf.aiyiqi.mvp.view.SearchView;
import com.bwflmw.framwork.BaseActivity;
import com.bwflmw.framwork.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Zoulin on 2016/11/24.
 * 搜索界面
 */

public class ActivitySeek extends BaseActivity implements SearchView {
    @BindView(R.id.Z_ed_seek_text)
    EditText etSeekText;
    @BindView(R.id.seek_titile_text)
    TextView seekTitileText;
    @BindView(R.id.ll_search_can_hide)
    LinearLayout llSearchCanHide;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.image_clear)
    ImageView imageClear;
    @BindView(R.id.ll_search_no_more)
    LinearLayout llSearchNoMore;

    private SearchRecyclerAdapter adapter;
    private SearchPresenter presenter;
    private LinearLayoutManager manager;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_mian_seek;
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        adapter = new SearchRecyclerAdapter(ActivitySeek.this);
        adapter.setOnItemClickListener(new SearchRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onclick(int position) {
                ResponseSearch.DataBean itemData = adapter.getItemData(position);
                Intent intent = new Intent(ActivitySeek.this, BBSActivity.class);
                intent.putExtra(Constant.INTENT_ID_KEY, itemData.getTid());
                startActivity(intent);
            }
        });
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(adapter);
        etSeekText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("ActivitySeek", "before:" + charSequence + " " + i + " " + i1 + " " + i2);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("ActivitySeek", "on:" + charSequence + " " + i + " " + i1 + " " + i2);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("ActivitySeek", "after:" + editable);
                if (TextUtils.isEmpty(editable)) {
                    llSearchCanHide.setVisibility(View.VISIBLE);
                    recyclerview.setVisibility(View.GONE);
                    imageClear.setVisibility(View.GONE);
                    llSearchNoMore.setVisibility(View.GONE);
                } else {
                    imageClear.setVisibility(View.VISIBLE);
                    llSearchCanHide.setVisibility(View.GONE);
                    recyclerview.setVisibility(View.VISIBLE);
                    llSearchNoMore.setVisibility(View.GONE);
                    if (editable.toString().trim().equals("")) {
                        ToastUtil.toToast("搜索条件不能为空");
                    } else {
                        //todo search
                        Log.d("ActivitySeek", "load");
                        presenter = new SearchPresenterImpl(ActivitySeek.this);
                        presenter.loadSearchData(editable.toString());
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    public void showSearchData(ResponseSearch data) {
        if (data.getData() != null)
            adapter.setData(data.getData());
        else {
            recyclerview.setVisibility(View.GONE);
            llSearchNoMore.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showSearchFailed() {
        ToastUtil.toToast("加载失败");
    }

    @OnClick({R.id.image_clear, R.id.seek_titile_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_clear:
                etSeekText.setText("");
                break;
            case R.id.seek_titile_text:
                finish();
                break;
        }
    }
}
