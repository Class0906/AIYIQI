package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.FragmentMain;
import com.bwf.aiyiqi.gui.fragment.FragmentMein;
import com.bwf.aiyiqi.gui.fragment.FragmentMessage;
import com.bwf.aiyiqi.gui.fragment.FragmentOwner;


public class MainActivity extends FragmentActivity {
    //定义FragmentTabHost对象
    private FragmentTabHost mTabHost;

    //定义一个布局
    private LayoutInflater layoutInflater;

    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {FragmentMain.class,FragmentOwner.class,FragmentMessage.class,FragmentMein.class};

    //定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.tab_home_icon,R.drawable.tab_community_icon,R.drawable.tab_msg_icon,
            R.drawable.tab_my_icon};

    //Tab选项卡的文字
    private String mTextviewArray[] = {"首页", "业主说","消息","我的"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView(){
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost)findViewById(R.id.fragment_tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.framelayout_mian);
        //得到fragment的个数
        int count = fragmentArray.length;

        for(int i = 0; i < count; i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //消除分割线
            mTabHost.getTabWidget().setDividerDrawable(R.color.white);
        }
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_tab);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview_tab);
        textView.setText(mTextviewArray[index]);

        return view;
    }


}
