package com.neishenmo.sochat.sochatandroid.view.signin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.app.NeiShenMeApp;
import com.neishenmo.sochat.sochatandroid.bean.PhoneBean;
import com.neishenmo.sochat.sochatandroid.bean.SignBean;
import com.neishenmo.sochat.sochatandroid.bean.VerificationBean;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.PhoneRequest;
import com.neishenmo.sochat.sochatandroid.requestbean.SignRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.VerificationRequst;
import com.neishenmo.sochat.sochatandroid.utils.ToastUtils;
import com.neishenmo.sochat.sochatandroid.view.MainActivity;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 小果冻
 * 短信验证码验证
 * Created by Administrator on 2018\4\24 0024.
 */

public class VerificationActivity extends Activity implements View.OnClickListener {


    private ImageView mIvReturn;
    private TextView mTvText;
    private TextView mTvPhoneErification;
    private EditText mEdErificationNumber;
    private ImageView mIvNextStep;
    private TextView mTvAgain;
    private String phone;

    private String phone_state;
    private SharedPreferences sp;
    private  String msgCode;
    private Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        initView();
    }

    private void initView() {
        mIvReturn = (ImageView) findViewById(R.id.iv_return);
        mIvReturn.setOnClickListener(this);
        mTvText = (TextView) findViewById(R.id.tv_text);
        mTvText.setOnClickListener(this);
        mTvPhoneErification = (TextView) findViewById(R.id.tv_phone_erification);
        mTvPhoneErification.setOnClickListener(this);
        mEdErificationNumber = (EditText) findViewById(R.id.ed_erification_number);
        mEdErificationNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEdErificationNumber.setOnClickListener(this);
        mIvNextStep = (ImageView) findViewById(R.id.iv_next_step);
        mIvNextStep.setOnClickListener(this);
        mTvAgain = (TextView) findViewById(R.id.tv_again);
        mTvAgain.setOnClickListener(this);

        /**
         *intent 传递登录或注册状态，手机号。
         */
        Intent intent = getIntent();
        phone_state = intent.getStringExtra("state");
        phone = intent.getStringExtra("phone");
        mTvPhoneErification.setText(String.format(getString(R.string.input_phione),phone));
        if ("1".equals(phone_state ) ){
            mTvText.setText(R.string.sign_title);
        }
        else if ("0".equals(phone_state )) {
            mTvText.setText(R.string.register_title);
        }

//        mTvPhoneErification.setText(String.format(getString(R.string.input_phione),intent.getStringArrayExtra("phone").toString()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**
             * 返回按钮点击事件
             */
            case R.id.iv_return:
                Intent intent = new Intent(VerificationActivity.this,SplaActivity.class);
                startActivity(intent);
            break;
            /**
             * 下一步点击事件
             */
            case R.id.iv_next_step:
                 msgCode = mEdErificationNumber.getText().toString().trim();
                 bundle.putString("code",msgCode);
                 bundle.putString("call",phone);
                NextStep();
                break;
            /**
             * 重新发送点击事件
             */
            case R.id.tv_again:
                Continue();
                break;
        }
    }

    private void NextStep() {
        /**
         * 登录
         */
        if (phone_state.equals("1")){
            SignIn();
        }
        /**
         * 注册
         */
        else if (phone_state.equals("0")){
            Register();
        }
    }

    /**
     * 登录
     */
    private void SignIn() {
        VerificationRequst requst = new VerificationRequst(phone,msgCode);
        ServiceApi api = RetrofitHelper.getServiceApi();
        api.getVerification(requst)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VerificationBean>() {
                    @Override
                    public void accept(VerificationBean verificationBean) throws Exception {

                        VerificationBean bean = verificationBean;
                        Log.d("TAG", String.valueOf(bean.getCode()) + "保存token之前的code--------------");
                        Log.d("TAG", String.valueOf(bean.getData().getUserId()) + "保存之前的token--------------");
                        sp = getSharedPreferences("user", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("userId", String.valueOf(bean.getData().getUserId()));
                        editor.putString("telephone", bean.getData().getTelephone());
                        editor.putString("nickName", bean.getData().getNickName());
                        editor.putString("picture", bean.getData().getPicture());
                        editor.putString("birthday", bean.getData().getBirthday());
                        editor.putString("sex", bean.getData().getSex());
                        editor.putString("constellation", bean.getData().getConstellation());
                        editor.putString("token", bean.getData().getToken());
                        editor.putString("hxPassword", bean.getData().getHxPassword());
                        editor.putString("balance", bean.getData().getBalance().setScale(2, BigDecimal.ROUND_HALF_UP).toString());


                        editor.commit();
                        if (bean.getCode() == 200) {
                            emClient(String.valueOf(bean.getData().getUserId()), bean.getData().getHxPassword());

                            Intent intent = new Intent(VerificationActivity.this, MainActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        } else if (bean.getCode() == 302) {
                            //editor.putString("token", bean.getData().getToken());
//                            Intent intent = new Intent(VerificationActivity.this, PerfectDataActivity.class);
//                            startActivity(intent);
//                            finish();
                            Toast.makeText(getApplicationContext(),"请输入正确的验证码",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    private void emClient(String userId, String password) {
        EMClient.getInstance().login(userId,password,new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.d("main", "登录聊天服务器成功！");
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登录聊天服务器失败！");
            }
        });
    }

    /**
     * 注册
     */
    private void Register() {
        SignRequst requst = new SignRequst(phone,mEdErificationNumber.getText().toString());
        ServiceApi api = RetrofitHelper.getServiceApi();
        api.getSign(requst)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SignBean>() {
                    @Override
                    public void accept(SignBean signBean) throws Exception {
                        SignBean bean = signBean;
                        if (bean.getCode() == 200){
//                            SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sp.edit();
//                            editor.putString("token",bean.getToken());
//                            editor.commit();
                            Intent intent = new Intent(VerificationActivity.this, PerfectDataActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }
    /**
     * 重新发送验证码
     */
    private void Continue() {
        PhoneRequest request = new PhoneRequest(phone);
        ServiceApi api = RetrofitHelper.getServiceApi();
        api.getPhone(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneBean>() {
                    @Override
                    public void accept(PhoneBean phoneBean) throws Exception {
                        PhoneBean bean = phoneBean;
                        if (bean.getCode() == 200){
                            ToastUtils.makeText(VerificationActivity.this,"短信发送成功，请注意查收",2);
                        }
                    }
                });
    }
}
