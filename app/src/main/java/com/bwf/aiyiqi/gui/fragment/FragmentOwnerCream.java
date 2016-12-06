package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class FragmentOwnerCream extends Fragment{
    private static final String ARG_Page = "ARG_Page";
    private List<String> owner_title;
    private List<Fragment> owner_list_fragment;
    private int pageNum;

    public static FragmentOwner newInstance(int pageNum){
        Bundle bundle = new Bundle(  );
        bundle.putInt( ARG_Page,pageNum );
        FragmentOwner fragmentOwner = new FragmentOwner();
        fragmentOwner.setArguments( bundle );
        return fragmentOwner;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        pageNum = getArguments().getInt( ARG_Page );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_owner,container,false );
        TextView textView = (TextView) view;
        textView.setText( "Fragment  #" + pageNum+"  #" );
        return view;
    }

}
