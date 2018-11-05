package com.neishenmo.sochat.sochatandroid.view.personage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.adapter.MoneyListAdapter;
import com.neishenmo.sochat.sochatandroid.bean.MoneyListBean;
import com.neishenmo.sochat.sochatandroid.listview.PullListView;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.MoneyListRequst;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018\5\3 0003.
 */

public class MoneyListActivity extends Activity {

    private TextView mMoneyNumber;
    private PullListView mPlvMoney;

    private MoneyListAdapter adapter;

    private int pagenumber = 1;

    private List<MoneyListBean.DataMapBean.RedPacketListBean> mList;
    private List<MoneyListBean.DataMapBean.RedPacketListBean> mData;
    private SharedPreferences sharedPreferences;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneylist);
        initView();
    }

    private void initView() {
        sharedPreferences = this.getSharedPreferences("user",MODE_PRIVATE);
        mList = new ArrayList<>();
        mMoneyNumber = findViewById(R.id.nomey_number);
        mPlvMoney = findViewById(R.id.plv_money);

        mPlvMoney.setOnRefreshListener(new PullListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mList.clear();
                pagenumber = 1;
                moneyList();
                Log.d("TAG","---------------------下拉刷新");
            }
        });
        mPlvMoney.setOnGetMoreListener(new PullListView.OnGetMoreListener() {
            @Override
            public void onGetMore() {
                pagenumber++;
                moneyList();
                Log.d("TAG","---------------------上啦加载");
            }
        });
        adapter = new MoneyListAdapter(MoneyListActivity.this,mList);
        mPlvMoney.setAdapter(adapter);
        mPlvMoney.performRefresh();
    }

    private void moneyList() {
        MoneyListRequst requst = new MoneyListRequst(sharedPreferences.getString("token",""),String.valueOf(pagenumber));
        ServiceApi api = RetrofitHelper.getServiceApi();
        api.getMonet(requst)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoneyListBean>() {
                    @Override
                    public void accept(MoneyListBean moneyListBean) throws Exception {
                        MoneyListBean bean = moneyListBean;
                        mMoneyNumber.setText(String.valueOf(bean.getDataMap().getCountRedPacket()));
                        if (bean.getCode() == 200){
                            mData = bean.getDataMap().getRedPacketList();
                            if (mData.size() == 0){
                                mPlvMoney.setNoMore();
                            }
                            mList.addAll(mData);
                            mData.clear();
                        }
                        mPlvMoney.refreshComplete();
                        mPlvMoney.getMoreComplete();
                    }
                });

    }
}
