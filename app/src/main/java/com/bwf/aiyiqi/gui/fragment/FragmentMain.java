package com.bwf.aiyiqi.gui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseHomeAD;
import com.bwf.aiyiqi.entity.ResponseHomeBBS;
import com.bwf.aiyiqi.gui.activity.ActivitySeek;
import com.bwf.aiyiqi.gui.activity.BBSActivity;
import com.bwf.aiyiqi.gui.activity.NewsActivity;
import com.bwf.aiyiqi.gui.adapter.MainRecyclerViewAdapter;
import com.bwf.aiyiqi.gui.adapter.UnlimitPagerAdapter;
import com.bwf.aiyiqi.kitutils.Constant;
import com.bwf.aiyiqi.mvp.presenter.MainPresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.MainPresenterImpl;
import com.bwf.aiyiqi.mvp.view.MainView;
import com.bwf.aiyiqi.view.AutoScorllViewPager;
import com.bwf.aiyiqi.view.NestingRefreshLayout;
import com.bwf.aiyiqi.view.ViewPagerIndicator;
import com.bwflmw.framwork.BaseFragment;
import com.bwflmw.framwork.utils.ToastUtil;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Zoulin on 2016/11/23.
 */

public class FragmentMain extends BaseFragment implements MainView {
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    private MainPresenter presenter;
    @BindView(R.id.viewpager_home_title)
    AutoScorllViewPager viewpagerHomeTitle;
    @BindView(R.id.container_viewpager_indicator)
    LinearLayout containerViewpagerIndicator;
    @BindView(R.id.image_scan)
    ImageView imageScan;
    @BindView(R.id.image_home_flag)
    ImageView imageHomeFlag;
    @BindView(R.id.text_city)
    TextView textCity;
    @BindView(R.id.layout_home_title_search)
    LinearLayout layoutHomeTitleSearch;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshlayout)
    NestingRefreshLayout refreshlayout;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {
        presenter = new MainPresenterImpl(this);
        isLoading = true;
        presenter.firstLoadData();
    }

    private MainRecyclerViewAdapter adapter;
    private ViewPagerIndicator indicator;
    private boolean isLoading;
    private String[] cities = {"北京", "上海", "天津", "石家庄", "西安", "武汉", "成都", "哈尔滨", "大连", "济南"};

    @Override
    protected void initView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        adapter = new MainRecyclerViewAdapter(getActivity());
        recyclerview.setAdapter(adapter);
        //下拉刷新
        refreshlayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter = new MainPresenterImpl(FragmentMain.this);
                adapter.clearData();
                presenter.firstLoadData();
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0)
                    refreshlayout.setisCanPull(true);
                else
                    refreshlayout.setisCanPull(false);

            }
        });
        //自动加载下一页
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isLoading && layoutManager.findLastVisibleItemPosition() == adapter.getItemCount() - 1) {
                    isLoading = true;
                    presenter.loadMoreData();
                }
            }
        });
        //设置recycler的item点击监听
        adapter.setOnItemClickListener(new MainRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int itemViewType = adapter.getItemViewType(position);
                String id = adapter.getItem(position).getId();
                if (itemViewType == MainRecyclerViewAdapter.TYPE_ARTICLE) {
                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                    intent.putExtra(Constant.INTENT_ID_KEY, id);
                    startActivity(intent);
                } else if (itemViewType == MainRecyclerViewAdapter.TYPE_BBS) {
                    Intent intent = new Intent(getActivity(), BBSActivity.class);
                    intent.putExtra(Constant.INTENT_ID_KEY, id);
                    intent.putExtra(Constant.INTENT_TITLE_KEY, adapter.getItem(position).getTitle());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.image_scan, R.id.image_home_flag, R.id.text_city, R.id.layout_home_title_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_scan:
                Intent intent1 = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent1,0);
                break;
            case R.id.image_home_flag:
                break;
            case R.id.text_city:
                View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.layou_city, null);
                ListView listView = (ListView) contentView.findViewById(R.id.list_view);
                final PopupWindow cityList = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                listView.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1, cities));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textCity.setText(cities[i]);
                        cityList.dismiss();
                    }
                });
                cityList.setTouchable(true);//可以点触
                cityList.setTouchInterceptor(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return false;
                    }
                });
                cityList.setBackgroundDrawable(getResources().getDrawable(R.color.white));
                cityList.showAsDropDown(view);
                break;
            case R.id.layout_home_title_search:
                Intent intent = new Intent(getActivity(), ActivitySeek.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void showMainViewPager(ResponseHomeAD data) {
        refreshlayout.finishRefresh(); //刷新完成
        viewpagerHomeTitle.setAdapter(new UnlimitPagerAdapter(getActivity(), data.getData()));
        LinearLayout container = (LinearLayout) getView().findViewById(R.id.container_viewpager_indicator);
        indicator = new ViewPagerIndicator(getActivity(), container, data.getData().size());
        indicator.setupWithViewPager(viewpagerHomeTitle);
        viewpagerHomeTitle.setAdapter(new UnlimitPagerAdapter(getActivity(), data.getData()));
    }

    @Override
    public void showMainRecyclerView(ResponseHomeBBS data) {
        isLoading = false;
        adapter.addData(data.getData());
    }

    @Override
    public void showViewpagerFailed() {
        refreshlayout.finishRefresh();//刷新失败
        ToastUtil.toToast("加载失败，请检查网络");
    }

    @Override
    public void showRecyclerFailed() {
        isLoading = false;
    }

}
