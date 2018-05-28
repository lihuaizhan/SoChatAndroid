package com.neishenmo.sochat.sochatandroid.view.particular;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.gyf.barlibrary.ImmersionBar;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.BaseData;
import com.neishenmo.sochat.sochatandroid.bean.HomeOthers;
import com.neishenmo.sochat.sochatandroid.bean.OtherLiveMsg;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.GetBaseData;
import com.neishenmo.sochat.sochatandroid.requestbean.LoveListRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.PhoneRequest;
import com.neishenmo.sochat.sochatandroid.utils.GlideCircleTransform;
import com.neishenmo.sochat.sochatandroid.utils.StringUtil;
import com.neishenmo.sochat.sochatandroid.utils.StringUtils;
import com.neishenmo.sochat.sochatandroid.utils.TimeConvertUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ParticularActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 姓名
     */
    private TextView mPartName;
    private ImageView mPartPicture;
    /**
     * 22岁
     */
    private TextView mOthersOld;
    /**
     * 天蝎座
     */
    private TextView mOthersUss;
    private TextView lovesNum;
    private TextView packetNum;
    private int i;
    private HomeOthers.DataBean.OnlineUserListBean home;
    private RequestManager with;
    private ServiceApi serviceApi;
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    /**
     * 返回
     */
    private Button mParyicuFinish;
    private SharedPreferences user;
    private List<OtherLiveMsg.DataBean.BListBean> bList;
    private List<String> list;
    private  List<Fragment> fragments;
    private OtherLiveMsg otherLiveMsgs;
    private ImmersionBar mImmersionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar .statusBarColor(R.color.colorTheme).fitsSystemWindows(true).init();   //所有子类都将继承这些相同的属性
        setContentView(R.layout.activity_particular);
        home = (HomeOthers.DataBean.OnlineUserListBean) getIntent().getSerializableExtra("home");
        serviceApi = RetrofitHelper.getServiceApi();
        user = getSharedPreferences("user", 0);
        bList = new ArrayList<>();
        list = new ArrayList<>();
        initView();


    }

    private void initView() {
        with = Glide.with(this);
        mPartName = (TextView) findViewById(R.id.part_name);
        mPartPicture = (ImageView) findViewById(R.id.part_picture);
        mOthersOld = (TextView) findViewById(R.id.others_old);
        mOthersUss = (TextView) findViewById(R.id.others_uss);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mParyicuFinish = (Button) findViewById(R.id.paryicu_finish);
        lovesNum = findViewById(R.id.loves_num);
        packetNum = findViewById(R.id.packet_num);
        otherLiveMsgs = new OtherLiveMsg();
        try {

            i = TimeConvertUtil.ConverToDate(home.getBirthday());

        } catch (Exception e) {
            e.printStackTrace();
        }

        mPartName.setText( StringUtils.toUtf8(home.getNickName()));
        mOthersOld.setText(i + "岁");
        mOthersUss.setText(home.getConstellation());

//        if (home.getPicture().equals("baidu.com")) {
//            with.load("https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg").transform(new GlideCircleTransform(getApplicationContext())).into(mPartPicture);
//        } else {
            with.load(home.getPicture()).error(R.drawable.get_more_btn_bg_f).transform(new GlideCircleTransform(getApplicationContext())).into(mPartPicture);
     //   }

        mParyicuFinish.setOnClickListener(this);
        //显示他人基本信息
        GetBaseData getBaseData = new GetBaseData();
        getBaseData.setLat(home.getLat());
        getBaseData.setLon(home.getLon());
        getBaseData.setTelephone(home.getTelephone());
        getBaseData.setToken(user.getString("token",""));
        serviceApi.getBaseData(getBaseData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseData>() {
                    @Override
                    public void accept(BaseData baseData) throws Exception {
                        packetNum.setText(baseData.getData().getOtherUserInfo().getRedPacketNum()+"次");
                        lovesNum.setText(baseData.getData().getOtherUserInfo().getThumbsUpNum()+"次");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });


        PhoneRequest requst = new PhoneRequest(home.getTelephone());
        serviceApi.getOtherLive(requst).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OtherLiveMsg>() {
                    @Override
                    public void accept(OtherLiveMsg otherLiveMsg) throws Exception {
                        otherLiveMsgs = otherLiveMsg;
                        bList = otherLiveMsg.getData().getBList();
                        for (int i = 0; i < bList.size(); i++) {
                            String timeInterval = TimeConvertUtil.getTimeInterval(bList.get(i).getBehaviorTime());
                          //  list.add(timeInterval.substring(timeInterval.length()-3,timeInterval.length()).equals("分钟前")?"1小时前":timeInterval);
                          //  list.add(timeInterval.substring(0,2).equals("昨天")?"1天前":timeInterval);
                            if(timeInterval.substring(0,2).equals("昨天"))
                            {
                                list.add("1天前");
                            }
                            else if(timeInterval.substring(timeInterval.length()-3,timeInterval.length()).equals("分钟前"))
                            {
                                list.add("1小时前");
                            }
                            else{
                                list.add(timeInterval);
                            }

                        }
                        List<String> strings = removeDuplicate(list);
                        fragments = new ArrayList<Fragment>();
                        for (int i = 0; i < strings.size(); i++) {
                            Fragment fragment = new MyFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("text", strings.get(i));
                            bundle.putSerializable("list",otherLiveMsgs);
                            fragment.setArguments(bundle);
                            fragments.add(fragment);
                        }
                        mViewPager.setAdapter(new TabFragmentAdapter(fragments, strings, getSupportFragmentManager(), getApplicationContext()));
                        // 将ViewPager和TabLayout绑定
                        mTablayout.setupWithViewPager(mViewPager);
                        // 设置tab文本的没有选中（第一个参数）和选中（第二个参数）的颜色
                        mTablayout.setTabTextColors(getResources().getColor(R.color.dark_white), Color.WHITE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.paryicu_finish:
                this.finish();
                break;
        }
    }
    public static List<String> removeDuplicate(List<String> list)
    {
        Set set = new LinkedHashSet<String>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }
}
