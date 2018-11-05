package com.neishenmo.sochat.sochatandroid.view.personage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.LogOut;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.AliWith;
import com.neishenmo.sochat.sochatandroid.requestbean.SendCode;
import com.neishenmo.sochat.sochatandroid.requestbean.WeiXinRequest;

import java.math.BigDecimal;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WeiXinSendActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences user;
    private String telephone;
    private String wxcode;
    private ImageView mCodeFinish;
    /**
     * 123456789
     */
    private TextView mPhoneCode;
    /**
     * 请输入短信验证码
     */
    private EditText mMsgCode;
    private ImageView mTiixanOk;
    /**
     * 发送
     */
    private TextView mFaSong;
    private ServiceApi serviceApi;
    private SendCode sendCode;
    private String num;
    private WeiXinRequest weiWith;
    private String trim;
    private BigDecimal bigDecimal ;
    private ImmersionBar mImmersionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar .statusBarColor(R.color.colorTheme).fitsSystemWindows(true).init();
        setContentView(R.layout.activity_wei_xin_send);
        user = getSharedPreferences("user", 0);
        telephone = user.getString("telephone", "");
        wxcode = getIntent().getStringExtra("wxcode");
        num = getIntent().getStringExtra("num");
        serviceApi = RetrofitHelper.getServiceApi();
        initView();
    }
    private void initView() {
        //实例化请求类
        sendCode = new SendCode();
        sendCode.setToken(user.getString("token", ""));
        String token = user.getString("token", "");
        sendCode.setMsgType("3");
        sendCode.setTelephone(telephone);
        //请求发送内部验证码
        serviceApi.sendInternalCode(sendCode).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LogOut>() {
                    @Override
                    public void accept(LogOut logOut) throws Exception {
                        String msg = logOut.getMsg();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        mCodeFinish = (ImageView) findViewById(R.id.wei_code_finish);
        mCodeFinish.setOnClickListener(this);
        mPhoneCode = (TextView) findViewById(R.id.wei_phone_code);
        mMsgCode = (EditText) findViewById(R.id.wei_msg_code);
        mTiixanOk = (ImageView) findViewById(R.id.wei_tiixan_ok);
        mTiixanOk.setOnClickListener(this);
        mFaSong = (TextView) findViewById(R.id.wei_fa_song);
        weiWith = new WeiXinRequest();


        mPhoneCode.setText(telephone);

        bigDecimal = new BigDecimal(num);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.wei_code_finish:
                this.finish();
                break;
            case R.id.wei_tiixan_ok:
                trim = mMsgCode.getText().toString().trim();
                if(!trim.equals("")&trim!=null)
                {
                    weiWith.setWxCode(wxcode);
                    weiWith.setBalance(bigDecimal);
                    weiWith.setMsgCode(trim);
                    weiWith.setToken(user.getString("token",""));
                    serviceApi.weiXinWith(weiWith).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<LogOut>() {
                                @Override
                                public void accept(LogOut logOut) throws Exception {
                                    String msg = logOut.getMsg();
                                    if(logOut.getCode()==200)
                                    {
                                        Intent intent = new Intent(WeiXinSendActivity.this,WithSuccessActivity.class);
                                        startActivity(intent);
                                    }

                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {

                                }
                            });
                }
                break;
        }
    }
    }
