package com.bwf.aiyiqi.gui.fragment.effectpicturefragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectbeutiPicture;
import com.bwf.aiyiqi.gui.adpter.MyEffectAdpter;
import com.bwf.aiyiqi.mvp.presenter.EffectPicturebeuPresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.EffectPicturebeuPresenterImpl;
import com.bwf.aiyiqi.mvp.view.EffectPicturebeuView;
import com.bwf.aiyiqi.view.AutoLoadListener;
import com.bwflmw.framwork.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/12/2.
 * 美图
 */

public class EffectPicturesedFirtment extends BaseFragment implements EffectPicturebeuView, RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.effect_picture_activity_life_radiogroup)
    RadioGroup effectPictureActivityLifeRadiogroup;
    @BindView(R.id.rbt_pretty_interspace)
    RadioButton rbtPrettyInterspace;
    @BindView(R.id.rbt_pretty_style)
    RadioButton rbtPrettyStyle;
    @BindView(R.id.rbt_pretty_locality)
    RadioButton rbtPrettyLocality;
    @BindView(R.id.rbt_pretty_color)
    RadioButton rbtPrettyColor;
    @BindView(R.id.effect_picture_activity_gridview)
    GridView effectPictureActivityGridview;

    @Override
    protected int getContentViewResId() {
        return R.layout.effect_picture_activity_pretty;
    }

    private EffectPicturebeuPresenter presenter;
    private MyEffectAdpter adpter;

    @Override
    protected void initView() {
        //初始化适配器
        adpter = new MyEffectAdpter(getContext());
        effectPictureActivityGridview.setAdapter(adpter);

        effectPictureActivityLifeRadiogroup.setOnCheckedChangeListener(this);

        inflater = LayoutInflater.from(getContext());
    }

    @Override
    protected void initData() {
        //实现网络请求展示
        presenter = new EffectPicturebeuPresenterImpl(this);
        presenter.EffectPicturebeuData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showEffectPicturebeugridView(ResponseEffectbeutiPicture data) {
        //动态添加数据到适配器
        adpter.addList(data.getData().getList());
        //添加自动读页事件处理
        AutoLoadListener autoLoadListener = new AutoLoadListener(callback);
        effectPictureActivityGridview.setOnScrollListener(autoLoadListener);
        //添加消息处理
        effectPictureActivityGridview.setOnItemClickListener(new ItemClickListener());
    }

    /**
     * 回调事件
     */
    AutoLoadListener.AutoLoadCallBack callback = new AutoLoadListener.AutoLoadCallBack() {
        @Override
        public void excute() {
            Toast.makeText(getContext(), "正在加载下一页，请稍等", Toast.LENGTH_SHORT).show();
            presenter.EffectPicturebeuData();
            //  Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
        }
    };
    private List<Map<String, Object>> listS = new ArrayList<Map<String, Object>>();
    private boolean isVishboole;

    //点击事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == rbtPrettyInterspace.getId()) {
            Toast.makeText(getContext(), "空间", Toast.LENGTH_SHORT).show();
            String listda[] = {"全部", "客厅", "玄关", "起居室", "厨房", "餐厅", "衣帽间", "庭院",
                    "卫生间", "阳台", "儿童房", "露台", "卧室", "书房", "娱乐室"};
            this.listDatas = listIntenone(listda);
            Log.e("EffectPicturesedFirtmen", "listDatas:" + listDatas);
            //判断获取popuwindow
            initPopuptWindow(listDatas);

        } else if (checkedId == rbtPrettyStyle.getId()) {
            Toast.makeText(getContext(), "风格", Toast.LENGTH_SHORT).show();
            String listda[] = {"全部", "现代", "简欧", "简约", "欧式", "田园", "中式", "欧式古典",
                    "北欧", "小资", "新中式", "混搭", "乡村", "美式", "宜家", "日式", "新古典", "地中海", "东南亚"};
            this.listDatas = listIntenone(listda);
            Log.e("EffectPicturesedFirtmen", "listDatas:" + listDatas);
            //判断获取popuwindow
            initPopuptWindow(listDatas);

        } else if (checkedId == rbtPrettyLocality.getId()) {
            Toast.makeText(getContext(), "局部", Toast.LENGTH_SHORT).show();
            String listda[] = {"全部", "背景墙", "收纳", "照片墙", "墙面", "窗帘", "餐台", "储物区",
                    "隔断", "飘窗", "楼梯", "门窗", "吧台", "工作区", "吊顶", "地面", "灯具", "过道", "地台", "壁炉"};
            this.listDatas = listIntenone(listda);
            Log.e("EffectPicturesedFirtmen", "listDatas:" + listDatas);
            //判断获取popuwindow
            initPopuptWindow(listDatas);
        } else if (checkedId == rbtPrettyColor.getId()) {
            Toast.makeText(getContext(), "颜色", Toast.LENGTH_SHORT).show();
            String listda[]={"全部","红色","白色","绿色","黑色","原木","紫色","粉色","春色","黄色","蓝色",};
            this.listDatas = listIntenone(listda);
            //判断获取popuwindow
            initPopuptWindow(listDatas);
        }
    }


    // 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        }
    }

    @Override
    public void showFailed() {

    }

    /*************************************************************************
     * 创建popwindow
     */
    private PopupWindow popupWindow;
    private LayoutInflater inflater;
    private List<Map<String, Object>> listDatas;

    private void initPopuptWindow(List<Map<String, Object>> listS) {
        View view = View.inflate(getContext(), R.layout.eff_popwindow_list, null);
        GridView list_view = (GridView) view.findViewById(R.id.eff_picture_popuwindow_gridview_list);
        //加载适配器数据
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                getContext(),
                listS,
                R.layout.eff_picture_dialog_gridview_adpter,
                new String[]{"buton"},
                new int[]{R.id.eff_picture_dialog_gridview_adpter_btn}
        );
        list_view.setAdapter(simpleAdapter);
        final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popupWidth = view.getMeasuredWidth();
        int popupHeight = view.getMeasuredHeight();
        int[] location = new int[2];
        // 允许点击外部消失
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xaa000000));//设置背景
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        // 获得位置
        effectPictureActivityLifeRadiogroup.getLocationOnScreen(location);
        popupWindow.setAnimationStyle(R.style.AnimationFade);
        popupWindow.showAtLocation(effectPictureActivityLifeRadiogroup, Gravity.NO_GRAVITY, (location[0] + effectPictureActivityLifeRadiogroup.getWidth() / 2) / 2, location[1] + popupHeight - 5);
    }

    public List<Map<String, Object>> listIntenone(String[] nextText) {
        listDatas = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < nextText.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("buton", nextText[i]);
            listDatas.add(map);
        }

        return listDatas;
    }
}
