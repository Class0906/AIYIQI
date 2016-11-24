package com.bwf.aiyiqi.gui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.MainActivity;
import com.bwf.aiyiqi.R;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lmw on 2016/11/23.
 */

public class GuideActivity extends BaseActivity {
    @BindView(R.id.text_cancel)
    TextView textCancel;
    @BindView(R.id.datePicker)
    DatePicker datePicker;
    @BindView(R.id.radio_state)
    RadioGroup radioState;
    @BindView(R.id.btn_goto_main)
    Button btnGotoMain;
    @BindView(R.id.radio_sex)
    RadioGroup radioSex;

    private SharedPreferences sp;
    private String sex;
    private int year = 1985;
    private int month = 6;
    private int day = 24;
    private String fitmentPlan;
    private boolean isSexChecked = false;
    private boolean isFitmentPlanChecked= false;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Log.d("GuideActivity", "btnGotoMain:" + btnGotoMain);
        btnGotoMain.setEnabled(false);
        btnGotoMain.getBackground().setAlpha(125);
        //初始化datepicker
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                year = i;
                month = i1;
                day = i2;
            }
        });
        radioSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                isSexChecked = true;
                if(isFitmentPlanChecked){
                    btnGotoMain.setEnabled(true);
                    btnGotoMain.getBackground().setAlpha(255);
                }
                switch (i) {
                    case 0:
                        sex = "男";
                        break;
                    case 1:
                        sex = "女";
                        break;
                }
            }
        });
        radioState.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                isFitmentPlanChecked = true;
                if(isSexChecked){
                    btnGotoMain.setEnabled(true);
                    btnGotoMain.getBackground().setAlpha(255);
                }
                switch (i) {
                    case 0:
                        fitmentPlan = "正在装修";
                        break;
                    case 1:
                        fitmentPlan = "计划装修";
                        break;
                    case 2:
                        fitmentPlan = "已经入住";
                        break;
                    case 3:
                        fitmentPlan = "暂无计划";
                        break;
                }
            }
        });

    }

    @Override
    protected void initData() {
        sp = getSharedPreferences("userInfo", MODE_PRIVATE);

    }


    @OnClick({R.id.text_cancel, R.id.btn_goto_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_cancel:
                finish();
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                break;
            case R.id.btn_goto_main:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
