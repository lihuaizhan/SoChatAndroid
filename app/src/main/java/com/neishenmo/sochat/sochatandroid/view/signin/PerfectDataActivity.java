package com.neishenmo.sochat.sochatandroid.view.signin;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.PerfectDataBean;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.popupwindow.CommonPopupWindow;
import com.neishenmo.sochat.sochatandroid.requestbean.PerfectDataRequst;
import com.neishenmo.sochat.sochatandroid.utils.ObtainAlbumUtils;
import com.neishenmo.sochat.sochatandroid.utils.UtilAnim;
import com.neishenmo.sochat.sochatandroid.utils.UtilBitmap;
import com.neishenmo.sochat.sochatandroid.utils.UtilScreenCapture;
import com.neishenmo.sochat.sochatandroid.view.MainActivity;
import com.neishenmo.sochat.sochatandroid.wheelView.AbstractWheelTextAdapter1;
import com.neishenmo.sochat.sochatandroid.wheelView.OnWheelChangedListener;
import com.neishenmo.sochat.sochatandroid.wheelView.OnWheelScrollListener;
import com.neishenmo.sochat.sochatandroid.wheelView.WheelView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 小果冻
 * 完善个人信息
 * Created by Administrator on 2018\4\24 0024.
 */

public class PerfectDataActivity extends Activity implements View.OnClickListener, CommonPopupWindow.OnPopWindowClickListener {

    private TextView mTvPerfect;
    private CircleImageView mCivHeadPortrait;
    private ImageView mIvMan;
    private ImageView mIvWoman;
    private LinearLayout mLlSexChoice;
    private EditText mEtName;
    private TextView mTvData;
    private TextView mTvCancel;
    private TextView mTvDetermine;
    private LinearLayout mLlLl;

    private long time;


    public static int PICTUR_HEAD = 11;
    private String sex = "男";


    private WheelView mWvBirthYear;
    private WheelView mWvBirthMonth;
    private WheelView mWvBirthDay;
    private LinearLayout mLlYearMonthDay;
    private ImageView mIvPopupWindowBack;
    private CalendarTextAdapter mYearAdapter;
    private CalendarTextAdapter mMonthAdapter;
    private CalendarTextAdapter mDaydapter;
    private ArrayList<String> arry_years = new ArrayList<String>();
    private ArrayList<String> arry_months = new ArrayList<String>();
    private ArrayList<String> arry_days = new ArrayList<String>();
    private String selectYear;
    private String selectMonth;
    private String selectDay;
    private boolean issetdata = false;
    private String currentYear = getYear();
    private String currentMonth = getMonth();
    private String currentDay = getDay();
    private String month;
    private String day;
    private int maxTextSize = 24;
    private int minTextSize = 14;
    private ImageView mTvNextStep;

    private String token;

    private  String mPhotoPath;

    private String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    private static final String testBucket = "neishenme";
    private String accessKeyId = "LTAIH2OdoTZKNR7k ";
    private String accessKeySecret = "H4woB6oRaJ2lJRnUQNmTE5OOtpYT9p ";
    private OSS oss;
    private String uploadObject;
    private String uploadFilePath;

    private String AliYunPath;

    private SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_data);
        initView();
        //初始化阿里云
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKeyId, accessKeySecret);
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000);//连接超时时间
        conf.setSocketTimeout(15 * 1000);//socket 超时时间
        conf.setMaxConcurrentRequest(5); //最大发送数
        conf.setMaxErrorRetry(2); // 失败后最大重连次数
        OSSLog.enableLog();
        oss = new OSSClient(getApplicationContext(),endpoint,credentialProvider,conf);

    }

    private void initView() {
        sp = getSharedPreferences("user",MODE_PRIVATE);
        mTvPerfect = (TextView) findViewById(R.id.tv_perfect);
        mTvPerfect.setOnClickListener(this);
        mCivHeadPortrait = (CircleImageView) findViewById(R.id.civ_head_portrait);
        mCivHeadPortrait.setOnClickListener(this);
        mIvMan = (ImageView) findViewById(R.id.iv_man);
        mIvMan.setOnClickListener(this);
        mIvWoman = (ImageView) findViewById(R.id.iv_woman);
        mIvWoman.setOnClickListener(this);
        mLlSexChoice = (LinearLayout) findViewById(R.id.ll_sex_choice);
        mLlSexChoice.setOnClickListener(this);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtName.setOnClickListener(this);
        mTvData = (TextView) findViewById(R.id.tv_data);
        mTvData.setOnClickListener(this);
        mWvBirthYear = (WheelView) findViewById(R.id.wv_birth_year);
        mWvBirthYear.setOnClickListener(this);
        mWvBirthMonth = (WheelView) findViewById(R.id.wv_birth_month);
        mWvBirthMonth.setOnClickListener(this);
        mWvBirthDay = (WheelView) findViewById(R.id.wv_birth_day);
        mWvBirthDay.setOnClickListener(this);
        mLlYearMonthDay = (LinearLayout) findViewById(R.id.ll_year_month_day);
        mLlYearMonthDay.setOnClickListener(this);
        mIvPopupWindowBack = (ImageView) findViewById(R.id.iv_popup_window_back);
        mIvPopupWindowBack.setOnClickListener(this);

        mIvMan.setSelected(true);
        mIvWoman.setSelected(false);
        token = sp.getString("token","");
//        token = getIntent().getStringExtra("token");
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

        /**
         * 年
         */
        initYears();
        mYearAdapter = new CalendarTextAdapter(PerfectDataActivity.this, arry_years, setYear(currentYear), maxTextSize, minTextSize);
        mWvBirthYear.setVisibleItems(5);
        mWvBirthYear.setViewAdapter(mYearAdapter);
        mWvBirthYear.setCurrentItem(setYear(currentYear));

        /**
         * 月
         */
        initMonths(Integer.parseInt(month));
        mMonthAdapter = new CalendarTextAdapter(PerfectDataActivity.this, arry_months, setMonth(currentMonth), maxTextSize, minTextSize);
        mWvBirthMonth.setVisibleItems(5);
        mWvBirthMonth.setViewAdapter(mMonthAdapter);
        mWvBirthMonth.setCurrentItem(setMonth(currentMonth));

        /**
         * 日
         */
        initDays(Integer.parseInt(day));
        mDaydapter = new CalendarTextAdapter(PerfectDataActivity.this, arry_days, Integer.parseInt(currentDay) - 1, maxTextSize, minTextSize);
        mWvBirthDay.setVisibleItems(5);
        mWvBirthDay.setViewAdapter(mDaydapter);
        mWvBirthDay.setCurrentItem(Integer.parseInt(currentDay) - 1);

        /**
         * 年
         */
        mWvBirthYear.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                // TODO Auto-generated method stub
                String currentText = (String) mYearAdapter.getItemText(wheel.getCurrentItem());
                selectYear = currentText;
                setTextviewSize(currentText, mYearAdapter);
                currentYear = currentText.substring(0, currentText.length() - 1).toString();
                Log.d("currentYear==", currentYear);
                setYear(currentYear);
                initMonths(Integer.parseInt(month));
                mMonthAdapter = new CalendarTextAdapter(PerfectDataActivity.this, arry_months, 0, maxTextSize, minTextSize);
                mWvBirthMonth.setVisibleItems(5);
                mWvBirthMonth.setViewAdapter(mMonthAdapter);
                mWvBirthMonth.setCurrentItem(0);

                calDays(currentYear, month);
            }
        });

        mWvBirthYear.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                // TODO Auto-generated method stub
                String currentText = (String) mYearAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mYearAdapter);
            }
        });


        /**
         * 月
         */
        mWvBirthMonth.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                // TODO Auto-generated method stub
                String currentText = (String) mMonthAdapter.getItemText(wheel.getCurrentItem());
                selectMonth = currentText;
                setTextviewSize(currentText, mMonthAdapter);
                setMonth(currentText.substring(0, 1));
                initDays(Integer.parseInt(day));
                mDaydapter = new CalendarTextAdapter(PerfectDataActivity.this, arry_days, 0, maxTextSize, minTextSize);
                mWvBirthDay.setVisibleItems(5);
                mWvBirthDay.setViewAdapter(mDaydapter);
                mWvBirthDay.setCurrentItem(0);

                calDays(currentYear, month);
            }
        });

        mWvBirthMonth.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                // TODO Auto-generated method stub
                String currentText = (String) mMonthAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mMonthAdapter);
            }
        });

        /**
         * 日
         */
        mWvBirthDay.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                // TODO Auto-generated method stub
                String currentText = (String) mDaydapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mDaydapter);
                selectDay = currentText;
            }
        });

        mWvBirthDay.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                // TODO Auto-generated method stub
                String currentText = (String) mDaydapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mDaydapter);
            }
        });
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvCancel.setOnClickListener(this);
        mTvDetermine = (TextView) findViewById(R.id.tv_determine);
        mTvDetermine.setOnClickListener(this);
        mLlLl = (LinearLayout) findViewById(R.id.ll_ll);
        mLlLl.setOnClickListener(this);
        mTvNextStep = (ImageView) findViewById(R.id.tv_next_step);
        mTvNextStep.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**
             * 头像
             */
            case R.id.civ_head_portrait:
                new CommonPopupWindow(this,this).show();
//                clickPopupWindow(mRlPopupWindow);
                break;

            /**
             * 性别选择
             */
            case R.id.iv_man:
                mIvMan.setSelected(true);
                mIvWoman.setSelected(false);
                sex = "男";
                break;
            case R.id.iv_woman:
                mIvMan.setSelected(false);
                mIvWoman.setSelected(true);
                sex = "女";
                break;
            /**
             * 日期选择
             */
            case R.id.tv_data:
                clickPopupWindow(mLlYearMonthDay);
                break;
            /**
             * 取消选择日期
             */
            case R.id.tv_cancel:
                UtilAnim.hideToDown(mLlYearMonthDay, mIvPopupWindowBack);
                break;
            /**
             * 确定选择日期
             */
            case R.id.tv_determine:
                mTvData.setText(selectYear + "" + selectMonth + "" + selectDay);
                UtilAnim.hideToDown(mLlYearMonthDay, mIvPopupWindowBack);
                break;
            /**
             * 下一步
             */
            case R.id.tv_next_step:
                time = System.currentTimeMillis();
                beginupload();
//                Log.d("TAG","https://neishenme.oss-cn-beijing.aliyuncs.com/" + token + time);
//                NextStop();
                break;
        }
    }

    /**
     * 把设置好的信息传入服务器
     */
    private void NextStop() {
        Log.d("TAG","https://neishenme.oss-cn-beijing.aliyuncs.com/" + token + time);
        PerfectDataRequst requst = new PerfectDataRequst(token, mEtName.getText().toString(), "https://neishenme.oss-cn-beijing.aliyuncs.com/" + token + time
                , selectYear + "" + selectMonth + "" + selectDay, sex);
        ServiceApi api = RetrofitHelper.getServiceApi();
        api.getPerfectData(requst)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PerfectDataBean>() {
                    @Override
                    public void accept(PerfectDataBean perfectDataBean) throws Exception {
                        PerfectDataBean bean = perfectDataBean;
                        if (bean.getCode() == 200) {
                            SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("userId",String.valueOf(bean.getData().getUserId()));
                            editor.putString("telephone",bean.getData().getTelephone());
                            editor.putString("nickName",bean.getData().getNickName());
                            editor.putString("picture",bean.getData().getPicture());
                            editor.putString("birthday",bean.getData().getBirthday());
                            editor.putString("sex",bean.getData().getSex());
                            editor.putString("constellation",bean.getData().getConstellation());
                            editor.putString("token",bean.getData().getToken());
                            editor.putString("hxPassword",bean.getData().getHxPassword());
                            editor.commit();
                            Intent intent = new Intent(PerfectDataActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    /**
     * 选择出生日期弹窗
     */
    private void clickPopupWindow(View view) {
        // 获取截图的Bitmap
        Bitmap bitmap = UtilScreenCapture.getDrawing(this);

        if (bitmap != null) {
            // 将截屏Bitma放入ImageView
            mIvPopupWindowBack.setImageBitmap(bitmap);
            // 将ImageView进行高斯模糊【25是最高模糊等级】【0x77000000是蒙上一层颜色，此参数可不填】
            UtilBitmap.blurImageView(this, mIvPopupWindowBack, 18, 0x77000000);
        } else {
            // 获取的Bitmap为null时，用半透明代替
            mIvPopupWindowBack.setBackgroundColor(0x77000000);
        }

        // 打开弹窗
        UtilAnim.showToUp(view, mIvPopupWindowBack);
    }

    /**
     * 选择头像的点击事件
     * @param view
     */
    @Override
    public void onPopWindowClickListener(View view) {
        switch (view.getId()){
            /**
             * 头像 拍照
             */
            case R.id.tv_menu_1:
                mPhotoPath = ObtainAlbumUtils.getSDPath()+"/"+ObtainAlbumUtils.getPhotoFileName();
                ObtainAlbumUtils.openCamera(PerfectDataActivity.this,mPhotoPath);
//                openCamera();
                break;
            /**
             * 头像  相册选择
             */
            case R.id.tv_menu_2:
                openAlbum();
                break;
            /**
             * 取消选择
             */
            case R.id.tv_close_popup_window:

                break;
        }
    }

    private class CalendarTextAdapter extends AbstractWheelTextAdapter1 {
        ArrayList<String> list;

        protected CalendarTextAdapter(Context context, ArrayList<String> list, int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem, maxsize, minsize);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }

        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index) + "";
        }
    }


    /**
     * 设置字体大小
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTextviewSize(String curriteItemText, CalendarTextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(maxTextSize);
            } else {
                textvew.setTextSize(minTextSize);
            }
        }
    }

    public void initYears() {
        for (int i = Integer.parseInt(getYear()); i > 1950; i--) {
            arry_years.add(i + "年");
        }
    }

    public void initMonths(int months) {
        arry_months.clear();
        for (int i = 1; i <= months; i++) {
            arry_months.add(i + "月");
        }
    }

    public void initDays(int days) {
        arry_days.clear();
        for (int i = 1; i <= days; i++) {
            arry_days.add(i + "日");
        }
    }

    /**
     * 设置年月日
     *
     * @param year
     * @param month
     * @param day
     */
    public void setDate(String year, String month, String day) {
        selectYear = year + "-";
        selectMonth = month + "-";
        selectDay = day + "";
        issetdata = true;
        this.currentYear = year;
        this.currentMonth = month;
        this.currentDay = day;
        if (year == getYear()) {
            this.month = getMonth();
        } else {
            this.month = 12 + "";
        }
        calDays(year, month);
    }

    /**
     * 设置年份
     *
     * @param year
     */
    public int setYear(String year) {
        int yearIndex = 0;
        if (!year.equals(getYear())) {
            this.month = 12 + "";
        } else {
            this.month = getMonth();
        }
        for (int i = Integer.parseInt(getYear()); i > 1950; i--) {
            if (i == Integer.parseInt(year)) {
                return yearIndex;
            }
            yearIndex++;
        }
        return yearIndex;
    }

    /**
     * 设置月份
     *
     * @param month
     * @param month
     * @return
     */
    public int setMonth(String month) {
        int monthIndex = 0;
        calDays(currentYear, month);
        for (int i = 1; i < Integer.parseInt(this.month); i++) {
            if (Integer.parseInt(month) == i) {
                return monthIndex;
            } else {
                monthIndex++;
            }
        }
        return monthIndex;
    }

    /**
     * 获取年月日
     *
     * @return
     */
    public String getYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) + "";
    }

    public String getMonth() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH) + 1 + "";
    }

    public String getDay() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DATE) + "";
    }


    /**
     * 计算每月多少天
     *
     * @param month
     * @param year
     */
    public void calDays(String year, String month) {
        boolean leayyear = false;
        if (Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0) {
            leayyear = true;
        } else {
            leayyear = false;
        }
        for (int i = 1; i <= 12; i++) {
            switch (Integer.parseInt(month)) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    this.day = 31 + "";
                    break;
                case 2:
                    if (leayyear) {
                        this.day = 29 + "";
                    } else {
                        this.day = 28 + "";
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    this.day = 30 + "";
                    break;
            }
        }
        if (year.equals(getYear()) && month.equals(getMonth())) {
            this.day = getDay();
        }
    }

    /**
     * 打开相册
     */
    private void openAlbum() {
        Intent intent = new Intent(PerfectDataActivity.this, AlbumActivity.class);
        startActivityForResult(intent, PICTUR_HEAD);
    }


    @Override
    public void onBackPressed() {
        if (mLlYearMonthDay.getVisibility() != View.GONE) {
            mLlYearMonthDay.setVisibility(View.GONE);
            UtilAnim.hideToDown(mLlYearMonthDay, mIvPopupWindowBack);
        }

        else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 截图完成后传回
         */
        if (requestCode == PICTUR_HEAD && resultCode == AlbumActivity.HEAD_OK) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = bundle.getParcelable("bitmap");
            uploadFilePath = ObtainAlbumUtils.writeFileByBitmap(bitmap);
            mCivHeadPortrait.setImageBitmap(bitmap);
        }
        /**
         * 调用截图
         */
        else if (requestCode  == 33){
            if (data!=null){
                ObtainAlbumUtils.BitmapScreenshot(data,PerfectDataActivity.this);
            }
        }
        /**
         * 截图之后设置头像
         */
        else if (requestCode == ObtainAlbumUtils.HEAD_SCREENSHOT){
            if (data!=null) {
                Bitmap bitmap = data.getParcelableExtra("data");
                uploadFilePath = ObtainAlbumUtils.writeFileByBitmap(bitmap);
                mCivHeadPortrait.setImageBitmap(bitmap);
            }
        }
    }

    /**
     * 图片传到阿里云服务器
     */
    private void beginupload() {
        PutObjectRequest put = new PutObjectRequest(testBucket,token+time,uploadFilePath);
        OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                NextStop();
//                Log.d("TAG", "UploadSuccess");
//                Log.d("TAG", "ETag"+result.getETag());
//                Log.d("TAG", "RequestId"+result.getRequestId());
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException) {
                if (clientException != null) {
                    Log.d("TAG","本地异常");
                    // 本地异常如网络异常等
                }
                if (serviceException != null) {
                    Log.d("TAG","服务异常");
                    // 服务异常
                }
            }
        });
    }
}
