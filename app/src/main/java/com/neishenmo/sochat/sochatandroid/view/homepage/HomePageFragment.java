package com.neishenmo.sochat.sochatandroid.view.homepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.adapter.HomeOthersMessageAdapter;
import com.neishenmo.sochat.sochatandroid.base.BaseFragment;
import com.neishenmo.sochat.sochatandroid.bean.ColourBean;
import com.neishenmo.sochat.sochatandroid.bean.HomeListBean;
import com.neishenmo.sochat.sochatandroid.bean.HomeOthers;
import com.neishenmo.sochat.sochatandroid.bean.LogOut;
import com.neishenmo.sochat.sochatandroid.bean.Thumbs;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.HomeRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.MoneyListRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.RelationShipRequest;
import com.neishenmo.sochat.sochatandroid.utils.LogUtils;
import com.neishenmo.sochat.sochatandroid.utils.ToastUtils;
import com.neishenmo.sochat.sochatandroid.view.particular.ParticularActivity;
import com.neishenmo.sochat.sochatandroid.view.signin.SplaActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018-04-24.
 */

public class HomePageFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout mLlLable;
    private ImageView mIvLove;
    private ImageView mIvMoney;
    private SharedPreferences sp;
    private RecyclerViewPager mRecycleViewPage;
    private ServiceApi serviceApi;
    private View view;
    private SharedPreferences user;
    private List<HomeOthers.DataBean.OnlineUserListBean> list;
    private List<HomeListBean.DataBean.OnlineUserListBean> mHomeList;
    private Thumbs thumbs;
    private RelativeLayout mRlHome;

    private int count = 0;
    private long firstTime = 0;
    private Timer delayTimer;
    private TimerTask task;
    private long interval = 500;


    int color = 0;

    private List<ColourBean> colorBean;

    private int r1 = 0;
    private int g1 = 0;
    private int b1 = 0;

    private String CLICK = "点击";

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            ToastUtils.makeText(getActivity(),msg.arg1+"arg1",1);

            if ((String.valueOf(msg.what)) != null){
                String rgb = "#" + checkColorValue(msg.arg1) + checkColorValue(msg.arg2) + checkColorValue(msg.what);
                  getActivity().findViewById(R.id.home_layout).setBackgroundColor(Color.parseColor(rgb));
                 mRlHome.setBackgroundColor(Color.parseColor(rgb));
                 sleep();
            }
            if (msg.obj == CLICK){
                if (count == 1) {
                    ToastUtils.makeText(getActivity(),"单击事件",1);
                } else if (count > 1) {
                    ToastUtils.makeText(getActivity(),"连续点击事件，共点击了 " + count + " 次",1);
                }
                delayTimer.cancel();
                count = 0;
            }
            if (msg.what == 666){
                getActivity().findViewById(R.id.home_layout).setBackgroundColor(Color.parseColor("#333232"));
                mRlHome.setBackgroundColor(Color.parseColor("#333232"));
            }

        }
    };

    private void sleep() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = 666;
                handler.sendMessage(message);
            }
        }).start();
    }


    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homepage_layout, container, false);

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
        list = new ArrayList<>();
        colorBean = new ArrayList<>();
        initAddList();
        thumbs = new Thumbs();
        sp = getActivity().getSharedPreferences("user", getActivity().MODE_PRIVATE);
        mIvLove = view.findViewById(R.id.iv_love);
        mIvMoney = view.findViewById(R.id.iv_money);
        mRecycleViewPage = view.findViewById(R.id.rl_user);
        view = view.findViewById(R.id.rl_home);
        mRlHome = view.findViewById(R.id.rl_home);
        mIvLove.setOnClickListener(this);
        mIvMoney.setOnClickListener(this);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecycleViewPage.setLayoutManager(layout);
        user = getActivity().getSharedPreferences("user", 0);
        MoneyListRequst request = new MoneyListRequst(user.getString("token", ""), "");
        serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.getHomeOthers(request).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeOthers>() {
                    @Override
                    public void accept(HomeOthers homeOthers) throws Exception {

                        list = homeOthers.getData().getOnlineUserList();
                        HomeOthersMessageAdapter homeOthersMessageAdapter = new HomeOthersMessageAdapter(getActivity(), list, false);
                homeOthersMessageAdapter.setOnItemClickListener(new HomeOthersMessageAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(int position) {
                       // Toast.makeText(getActivity(),position+"",Toast.LENGTH_SHORT).show();

                        HomeOthers.DataBean.OnlineUserListBean onlineUserListBean = list.get(position);
                        Intent intent = new Intent(getActivity(), ParticularActivity.class);
                        Bundle mBundle = new Bundle();
                        mBundle.putSerializable("home",onlineUserListBean);
                        intent.putExtras(mBundle);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongClick(int position) {

                    }
                });
                        mRecycleViewPage.setAdapter(homeOthersMessageAdapter);


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });


    }

    @Override
    protected void setDefaultFragmentTitle(String title) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_love:
                if (sp.getString("token", "") == "") {
                    Intent intent = new Intent(getActivity(), SplaActivity.class);
                    startActivity(intent);
                } else {

//                    long secondTime = System.currentTimeMillis();
//                    // 判断每次点击的事件间隔是否符合连击的有效范围
//                    // 不符合时，有可能是连击的开始，否则就仅仅是单击
//                    if (secondTime - firstTime <= interval) {
//                        ++count;
//                    } else {
//                        count = 1;
//                    }
//                    // 延迟，用于判断用户的点击操作是否结束
//                    delay();
//                    firstTime = secondTime;
//                    ColorChange();

                    //  ToastUtils.makeText(getActivity(),"您已登录",1);
                    RecyclerView.LayoutManager layoutManager = mRecycleViewPage.getLayoutManager();
                    //判断是当前layoutManager是否为LinearLayoutManager
                    // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                    if (layoutManager instanceof LinearLayoutManager) {
                        LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                        //获取第一个可见view的位置
                        int firstItemPosition = linearManager.findFirstVisibleItemPosition();

                        // Toast.makeText(getActivity(),firstItemPosition+"",Toast.LENGTH_SHORT).show();
                        //  LogUtils.d("ssssss",firstItemPosition+"");
                        HomeOthers.DataBean.OnlineUserListBean onlineUserListBean = list.get(firstItemPosition);
                        //设置点赞参数并调用点赞接口
                        thumbs.setAmount("1");
                        thumbs.setTelephone(onlineUserListBean.getTelephone());
                        thumbs.setToken(user.getString("token", ""));
                        serviceApi.setThumbs(thumbs).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<LogOut>() {
                                    @Override
                                    public void accept(LogOut logOut) throws Exception {
                                        Toast.makeText(getActivity(), "点赞成功", Toast.LENGTH_SHORT).show();
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {

                                    }
                                });
                    }
                }
                break;
            case R.id.iv_money:
                break;
        }
    }
    private void initAddList() {
        colorBean = new ArrayList<>();
        ColourBean bean = new ColourBean(138,160,255 );
        colorBean.add(bean);
        ColourBean bean1 = new ColourBean(221,118,255 );
        colorBean.add(bean1);
        ColourBean bean2 = new ColourBean(254,115,168  );
        colorBean.add(bean2);
        ColourBean bean3 = new ColourBean(113,73,255);
        colorBean.add(bean3);
        ColourBean bean4 = new ColourBean(102,255,253 );
        colorBean.add(bean4);
        ColourBean bean5 = new ColourBean(254,211,108 );
        colorBean.add(bean5);
        ColourBean bean6 = new ColourBean(253,123,52 );
        colorBean.add(bean6);
        ColourBean bean7 = new ColourBean(205,255,157 );
        colorBean.add(bean7);
        ColourBean bean8 = new ColourBean(199,126,255 );
        colorBean.add(bean8);
        ColourBean bean9 = new ColourBean(55,255,255 );
        colorBean.add(bean9);
    }

    // 延迟时间是连击的时间间隔有效范围
    private void delay() {
        if (task != null)
            task.cancel();

        task = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = CLICK;
                // message.what = 0;
                handler.sendMessage(message);
            }
        };
        delayTimer = new Timer();
        delayTimer.schedule(task, interval);
    }
    private void ColorChange() {
        color ++;
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    if (color<colorBean.size() - 1){
                        if (colorBean.get(color).getR() > colorBean.get(color+1).getR()){
                            int r = (colorBean.get(color).getR() - colorBean.get(color+1).getR()) / 10;
                            r1 = colorBean.get(color).getR() - r;
                        }
                        else if (colorBean.get(color).getR()<colorBean.get(color+1).getR()){
                            int r = (colorBean.get(color + 1).getR() - colorBean.get(color).getR()) / 10;
                            r1 = colorBean.get(color).getR() + r;
                        }
                        else {

                        }
                        if (colorBean.get(color).getG() > colorBean.get(color+1).getG()){
                            int g = (colorBean.get(color).getG() - colorBean.get(color+1).getG()) / 10;
                            g1 = colorBean.get(color).getG() - g;
                        }
                        else if (colorBean.get(color).getG() < colorBean.get(color+1).getG()){
                            int g = (colorBean.get(color+1).getG() - colorBean.get(color).getG()) / 10;
                            g1 = colorBean.get(color).getG() + g;
                        }
                        else {

                        }
                        if (colorBean.get(color).getB() > colorBean.get(color+1).getB()){
                            int b = (colorBean.get(color).getB() - colorBean.get(color+1).getB()) / 10;
                            b1 = colorBean.get(color).getB() - b;
                        }
                        else if (colorBean.get(color).getG() < colorBean.get(color+1).getG()){
                            int b = colorBean.get(color+1).getB() - colorBean.get(color).getB();
                            b1 = colorBean.get(color).getB() + b;
                        }
                        else {

                        }
                    }


                    else {
                        color = 0;
                        if (colorBean.get(color).getR() > colorBean.get(colorBean.size() - 1).getR()){
                            int r = (colorBean.get(color).getR() - colorBean.get(colorBean.size() - 1).getR()) / 10;
                            r1 = colorBean.get(color).getR() - r;
                        }
                        else if (colorBean.get(color).getR()<colorBean.get(colorBean.size() - 1).getR()){
                            int r = (colorBean.get(colorBean.size() - 1).getR() - colorBean.get(color).getR()) / 10;
                            r1 = colorBean.get(color).getR() + r;
                        }
                        else {

                        }
                        if (colorBean.get(color).getG() > colorBean.get(colorBean.size() - 1).getG()){
                            int g = (colorBean.get(color).getG() - colorBean.get(colorBean.size() - 1).getG()) / 10;
                            g1 = colorBean.get(color).getG() - g;
                        }
                        else if (colorBean.get(color).getG() < colorBean.get(colorBean.size() - 1).getG()){
                            int g = (colorBean.get(colorBean.size() - 1).getG() - colorBean.get(color).getG()) / 10;
                            g1 = colorBean.get(color).getG() + g;
                        }
                        else {

                        }
                        if (colorBean.get(color).getB() > colorBean.get(colorBean.size() - 1).getB()){
                            int b = (colorBean.get(color).getB() - colorBean.get(colorBean.size() - 1).getB()) / 10;
                            b1 = colorBean.get(color).getB() - b;
                        }
                        else if (colorBean.get(color).getG() < colorBean.get(colorBean.size() - 1).getG()){
                            int b = colorBean.get(colorBean.size() - 1).getB() - colorBean.get(color).getB();
                            b1 = colorBean.get(color).getB() + b;
                        }
                        else {

                        }
                    }
                    Message message = new Message();
                    message.arg1 = r1;
                    message.arg2 = g1;
                    message.what = b1;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }

    //rgb转二进制
    private String checkColorValue(int value){
        String str = "";
        if(value<16){
            str ="0" + Integer.toHexString(value);
            return str;
        }
        return Integer.toHexString(value);
    }




}
