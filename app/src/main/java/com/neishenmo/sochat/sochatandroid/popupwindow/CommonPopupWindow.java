package com.neishenmo.sochat.sochatandroid.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.R;

/**
 * 小果冻
 * 点击弹出popupwindow 选择相册或相机拍照
 * Created by Administrator on 2018\4\28 0028.
 */

public class CommonPopupWindow extends PopupWindow implements View.OnClickListener {
    private View mMenuView;

    private OnPopWindowClickListener listener;

    private Activity activity;

    public CommonPopupWindow(OnPopWindowClickListener listener, Activity activity) {
//        super(context);
        this.activity = activity;
        initView(activity,listener);
    }

    public void show(){
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int winHeight = activity.getWindow().getDecorView().getHeight();
        this.showAtLocation(activity.getWindow().getDecorView(),Gravity.BOTTOM , 0 , winHeight - rect.bottom);


    }

    private void initView(Activity activity, OnPopWindowClickListener listener) {
        this.listener = listener;
        initViewSetting(activity);
        this.setContentView(mMenuView);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.dialog_style);
        ColorDrawable drawable = new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(drawable);
        mMenuView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height = mMenuView.findViewById(R.id.rl_popup_window).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (y < height){
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    private void initViewSetting(Activity context){
        TextView mPhotograph;
        TextView mAlbum;
        TextView mCancel;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.item_choice_head,null);
        mPhotograph = mMenuView.findViewById(R.id.tv_menu_1);
        mAlbum = mMenuView.findViewById(R.id.tv_menu_2);
        mCancel = mMenuView.findViewById(R.id.tv_close_popup_window);

        mPhotograph.setOnClickListener(this);
        mAlbum.setOnClickListener(this);
        mCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onPopWindowClickListener(v);
        dismiss();
    }

    /**
     * 接口
     */
    public interface OnPopWindowClickListener{
        void onPopWindowClickListener(View view);
    }
}
