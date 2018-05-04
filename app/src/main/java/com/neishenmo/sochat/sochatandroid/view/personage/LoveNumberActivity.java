package com.neishenmo.sochat.sochatandroid.view.personage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.adapter.LoveNumberAdapter;
import com.neishenmo.sochat.sochatandroid.bean.LoveListBean;
import com.neishenmo.sochat.sochatandroid.listview.PullListView;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.LoveListRequst;
import com.neishenmo.sochat.sochatandroid.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018\5\2 0002.
 */

public class LoveNumberActivity extends Activity {
    private PullListView mPullListView;
    private TextView mLoveNumber;
    private List<LoveListBean.DataMapBean.ThumbsUpListBean> mList;
    private List<LoveListBean.DataMapBean.ThumbsUpListBean> mData;
    private LoveNumberAdapter adapter;
    private SharedPreferences sharedPreferences;
    private int pagenumber =  1;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovenumber);
        initView();
    }

    private void initView() {
        sharedPreferences = this.getSharedPreferences("user",MODE_PRIVATE);
        mPullListView = findViewById(R.id.plv_love);
        mLoveNumber = findViewById(R.id.love_number);
        mList = new ArrayList<>();

        mPullListView.setOnRefreshListener(new PullListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mList.clear();
                pagenumber = 1;
                LoveList();
                Log.d("TAG","---------------------下拉刷新");
            }
        });
        mPullListView.setOnGetMoreListener(new PullListView.OnGetMoreListener() {
            @Override
            public void onGetMore() {
                pagenumber++;
                LoveList();
                Log.d("TAG","---------------------上啦加载");
            }
        });

        adapter = new LoveNumberAdapter(LoveNumberActivity.this,mList);
        mPullListView.setAdapter(adapter);
        mPullListView.performRefresh();
    }

    private void LoveList() {
        LoveListRequst requst = new LoveListRequst(sharedPreferences.getString("token",""),String.valueOf(pagenumber));
        ServiceApi api = RetrofitHelper.getServiceApi();
        api.getLoveList(requst)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoveListBean>() {
                    @Override
                    public void accept(LoveListBean loveListBean) throws Exception {
                        LoveListBean bean = loveListBean;
                        mLoveNumber.setText(String.valueOf(bean.getDataMap().getCountThumbsUp()));
                        if (bean.getCode() == 200) {
                            mData = bean.getDataMap().getThumbsUpList();
                            if (mData.size() == 0){
                                mPullListView.setNoMore();
                            }
                            mList.addAll(mData);
                            mData.clear();
                        }
                        mPullListView.refreshComplete();
                        mPullListView.getMoreComplete();
                    }
                });
    }
}
