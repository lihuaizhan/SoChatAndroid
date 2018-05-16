package com.neishenmo.sochat.sochatandroid.view.homepage;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
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

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.utils.EaseUserUtils;
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
import com.neishenmo.sochat.sochatandroid.view.MainActivity;
import com.neishenmo.sochat.sochatandroid.view.particular.ParticularActivity;
import com.neishenmo.sochat.sochatandroid.view.signin.SplaActivity;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    //  private HiPraiseAnimationView mHiPraiseAnimationView;

    private int count = 0;
    private long firstTime = 0;
    private Timer delayTimer;
    private TimerTask task;
    private long interval = 500;

    private static long lastClickTime;
    Random random = new Random();
    Random random1 = new Random();
    private int r = random.nextInt(256);
    private int g = random.nextInt(256);
    private int b = random.nextInt(256);
    private int r1 = random1.nextInt(256);
    private int g1 = random1.nextInt(256);
    private int b1 = random1.nextInt(256);

    private HomeOthers.DataBean.OnlineUserListBean onlineUserListBean;
    private String nickName;
//页面标识
    private int page = 0;

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
        //  colorBean = new ArrayList<>();
        // initAddList();
        thumbs = new Thumbs();
        sp = getActivity().getSharedPreferences("user", getActivity().MODE_PRIVATE);
        user = getActivity().getSharedPreferences("user", 0);
        serviceApi = RetrofitHelper.getServiceApi();
        //获取控件id
        mIvLove = view.findViewById(R.id.iv_love);
        mIvMoney = view.findViewById(R.id.iv_money);
        mRecycleViewPage = view.findViewById(R.id.rl_user);
        view = view.findViewById(R.id.rl_home);
        mRlHome = view.findViewById(R.id.rl_home);
        // mHiPraiseAnimationView = view.findViewById(R.id.praise_animation);


        //点击监听
        mIvLove.setOnClickListener(this);
        mIvMoney.setOnClickListener(this);


        LinearLayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecycleViewPage.setLayoutManager(layout);
        //首页请求参数
        HomeRequst request = new HomeRequst();
        if(user.getString("token","")=="")
        {
            page = 1;
        }
        request.setPageNo(page+"");
        request.setToken(user.getString("token",""));

        //请求首页数据
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
                                mBundle.putSerializable("home", onlineUserListBean);
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
                        String s = throwable.getMessage().toString();
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
                r = random.nextInt(256);
                g = random.nextInt(256);
                b = random.nextInt(256);
                r1 = random1.nextInt(256);
                g1 = random1.nextInt(256);
                b1 = random1.nextInt(256);
                if (sp.getString("token", "") == "") {
                    Intent intent = new Intent(getActivity(), SplaActivity.class);
                    startActivity(intent);
                } else {
                    if (list.size() != 0) {
                        boolean fastClick = isFastClick(200);
                        if (fastClick) {
                            //  Toast.makeText(getActivity(), "快", Toast.LENGTH_SHORT).show();
                            int rgb = Color.rgb(150, 11, 208);
                            //mRxHeartLayout.addHeart(rgb);
                            //调用点赞飘心动画
                            // addPraise();
                            animationColorGradient(Color.rgb(r, g, b), Color.rgb(r1, g1, b1));
                        } else {
                            //Toast.makeText(getActivity(), "不快", Toast.LENGTH_SHORT).show();
                            getActivity().findViewById(R.id.home_layout).setBackgroundColor(Color.rgb(r, g, b));
                            //  animationColorGradient(Color.rgb(r,g,b),Color.parseColor("#333232"));


                        }
                        RecyclerView.LayoutManager layoutManager = mRecycleViewPage.getLayoutManager();
                        //判断是当前layoutManager是否为LinearLayoutManager
                        // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                        if (layoutManager instanceof LinearLayoutManager) {
                            LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                            //获取第一个可见view的位置
                            int firstItemPosition = linearManager.findFirstVisibleItemPosition();

                            // Toast.makeText(getActivity(),firstItemPosition+"",Toast.LENGTH_SHORT).show();
                            //  LogUtils.d("ssssss",firstItemPosition+"");
                            onlineUserListBean = list.get(firstItemPosition);
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
                    } else {
                        Toast.makeText(getActivity(), "目前没有推荐用户", Toast.LENGTH_SHORT).show();
                    }
                    //  nickName = onlineUserListBean.getUserId();
                }
                break;
            case R.id.iv_money:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理

        //  mHiPraiseAnimationView.start(); //添加点赞动画之前要先开始启动绘制，如果没有，是添加不了任何的动画对象
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理

        //  mHiPraiseAnimationView.stop(); //停止绘制点赞动画，停止后会clear掉整个画布和清空掉所有绘制的对象
    }

//    //点赞动画
//    private void addPraise() {
//        final IPraise hiPraise = new HiPraise(BitmapFactory.decodeResource(getResources(), R.drawable.love));
//        mHiPraiseAnimationView.addPraise(hiPraise);
//    }

    public static boolean isFastClick(int millisecond) {
        long curClickTime = System.currentTimeMillis();
        long interval = curClickTime - lastClickTime;
        if (0L < interval && interval < (long) millisecond) {
            return true;
        } else {
            lastClickTime = curClickTime;
            return false;
        }
    }

    //颜色渐变动画
    public void animationColorGradient(int beforeColor, int afterColor) {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(beforeColor), Integer.valueOf(afterColor)}).setDuration(500L);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                int i = ((Integer) animation.getAnimatedValue()).intValue();
                getActivity().findViewById(R.id.home_layout).setBackgroundColor(i);
            }
        });
        valueAnimator.start();
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                getActivity().findViewById(R.id.home_layout).setBackgroundResource(R.color.bg);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
