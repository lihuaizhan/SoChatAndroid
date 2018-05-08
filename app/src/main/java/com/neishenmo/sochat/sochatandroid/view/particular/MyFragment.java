package com.neishenmo.sochat.sochatandroid.view.particular;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.adapter.HomeOthersMessageAdapter;
import com.neishenmo.sochat.sochatandroid.adapter.OthersMesgAdapter;
import com.neishenmo.sochat.sochatandroid.bean.OtherLiveMsg;
import com.neishenmo.sochat.sochatandroid.utils.TimeConvertUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-05-07.
 */

public class MyFragment extends Fragment {
    private String mText;
    private OtherLiveMsg list;
    private List<OtherLiveMsg.DataBean.BListBean> bList;
    private List<OtherLiveMsg.DataBean.BListBean> bLists;

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            mText = getArguments().getString("text");
            list = (OtherLiveMsg) getArguments().getSerializable("list");
            bList = list.getData().getBList();
            bLists = new ArrayList<>();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TextView textView = new TextView(getActivity());
        RecyclerView rc = new RecyclerView(getActivity());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, -1);
        rc.setLayoutParams(params);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rc.setLayoutManager(linearLayoutManager);
        for (int i = 0; i < bList.size(); i++) {
            if (TimeConvertUtil.getTimeInterval(bList.get(i).getBehaviorTime()).equals(mText)) {
                bLists.add(bList.get(i));
            }

        }
        OthersMesgAdapter adapter = new OthersMesgAdapter(getActivity(), bLists, false);
        rc.setAdapter(adapter);
//        textView.setGravity(Gravity.CENTER);
//        textView.setTextColor(Color.RED);
        //textView.setText(mText);

        return rc;

    }
}
