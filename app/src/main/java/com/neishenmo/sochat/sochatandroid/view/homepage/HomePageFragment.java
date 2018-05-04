package com.neishenmo.sochat.sochatandroid.view.homepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.base.BaseFragment;
import com.neishenmo.sochat.sochatandroid.bean.HomeListBean;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.HomeRequst;
import com.neishenmo.sochat.sochatandroid.utils.ToastUtils;
import com.neishenmo.sochat.sochatandroid.view.signin.SplaActivity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018-04-24.
 */

public class HomePageFragment extends BaseFragment implements View.OnClickListener {
    private TextView mTvName;
    private LinearLayout mLlLable;
    private RelativeLayout mRlUser;
    private ImageView mIvLove;
    private ImageView mIvMoney;
    private SharedPreferences sp;
    private ViewPager mViewPager;

    private List<HomeListBean.DataBean.OnlineUserListBean>mHomeList;
    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_layout, container, false);
        sp = getActivity().getSharedPreferences("user",getActivity().MODE_PRIVATE);
        mIvLove = view.findViewById(R.id.iv_love);
        mIvMoney = view.findViewById(R.id.iv_money);
        mViewPager = view.findViewById(R.id.rl_user);
        mIvLove.setOnClickListener(this);
        mIvMoney.setOnClickListener(this);

//        HomeList();

//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //   getActivity().findViewById(R.id.magic_indicator4).setVisibility(View.INVISIBLE);
//                getActivity().findViewById(R.id.home_layout).setBackgroundColor(Color.RED);
//            }
//        });
        return view;
    }

    /**
     * 获取首页列表
     */
//    private void HomeList() {
//        HomeRequst requst;
//        if (sp.getString("token","") == ""){
//            requst = new HomeRequst("","1","1","苏州街","1");
//        }
//        else {
//            requst = new HomeRequst("","1","1","苏州街");
//        }
//        ServiceApi api = RetrofitHelper.getServiceApi();
//        api.getHomeList(requst)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<HomeListBean>() {
//                    @Override
//                    public void accept(HomeListBean homeListBean) throws Exception {
////                        HomeListBean bean = homeListBean;
////                        mHomeList.add(bean);
////                        mViewPager.setAdapter(new HomeAdapter());
//                    }
//                });
//
//    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setDefaultFragmentTitle(String title) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_love:
                if (sp.getString("token","") == ""){
                    Intent intent = new Intent(getActivity(), SplaActivity.class);
                    startActivity(intent);
                }
                else {
                    ToastUtils.makeText(getActivity(),"您已登录",1);
                }
                break;
            case R.id.iv_money:
                break;
        }
    }
}
