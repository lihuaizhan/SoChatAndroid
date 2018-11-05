package com.neishenmo.sochat.sochatandroid.view.signin;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.PhoneBean;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.PhoneRequest;
import com.neishenmo.sochat.sochatandroid.view.MainActivity;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/*
* 小果冻
* 输入手机号发送短信
* */
public class SplaActivity extends Activity implements View.OnClickListener {


    private EditText mEdPhone;
    private ImageView mIvContinue;
    private TextView mTvAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spla);
        initView();
    }

    private void initView() {
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mIvContinue = (ImageView) findViewById(R.id.iv_continue);
        mTvAgreement = (TextView) findViewById(R.id.tv_agreement);
        //EditText修改字体大小 颜色
        mEdPhone.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        SpannableString mSpannableString = new SpannableString(getString(R.string.sign_in_phone));
        AbsoluteSizeSpan mAbsoluteSizeSpan = new AbsoluteSizeSpan(28,true);
        mSpannableString.setSpan(mAbsoluteSizeSpan,0,mSpannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mEdPhone.setHint(new SpannableString(mSpannableString));

        mIvContinue.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //点击手机号表示继续发送短信
            case R.id.iv_continue:
                if (mEdPhone.getText().length()==11){
                    Continue();
                }
                else {
                    Toast.makeText(this, getString(R.string.sign_in_phone_remind), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 继续点击事件
     */
    private void Continue() {
        PhoneRequest request = new PhoneRequest(mEdPhone.getText().toString());
        ServiceApi api = RetrofitHelper.getServiceApi();
        api.getPhone(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneBean>() {
                    @Override
                    public void accept(PhoneBean phoneBean) throws Exception {
                        PhoneBean bean = phoneBean;
                        if (bean.getCode() == 200){
                                Intent intent = new Intent(SplaActivity.this, VerificationActivity.class);
                                intent.putExtra("phone",mEdPhone.getText().toString());
                                intent.putExtra("state",String.valueOf(bean.getData().getMsgType()));
                                Log.d("TAG",String.valueOf(bean.getData().getMsgType())+"--------");
                                startActivity(intent);
                                finish();
//                            }
//                            /**
//                             * 注册
//                             */
//                            else if (bean.getData().getMsgType() == 0){
//                                Intent intent = new Intent(SplaActivity.this, VerificationActivity.class);
//                                intent.putExtra("phone",mEdPhone.getText().toString());
//                                intent.putExtra("state",String.valueOf(bean.getData().getMsgType()));
//                                startActivity(intent);
//                                finish();
//                            }
                        }
                    }
                });
    }
}
