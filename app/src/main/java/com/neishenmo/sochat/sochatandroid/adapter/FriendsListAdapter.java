package com.neishenmo.sochat.sochatandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.Friends;
import com.neishenmo.sochat.sochatandroid.bean.Like;
import com.neishenmo.sochat.sochatandroid.bean.LogOut;
import com.neishenmo.sochat.sochatandroid.utils.GlideCircleTransform;
import com.neishenmo.sochat.sochatandroid.utils.TimeConvertUtil;
import com.neishenmo.sochat.sochatandroid.view.signin.SplaActivity;

import java.util.List;

import bpwidget.lib.wjj.blurpopupwindowlib.widget.BlurPopWin;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2018-04-25.
 * 喜欢数据适配器
 */

public class FriendsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RequestManager with;
    private Context context;
    private List<Friends.DataBean.FuiListBean> list;
    private LayoutInflater inflater;
    private int size;
    private boolean isChange;
    private OnItemClickListener mOnItemClickListener;

    //定义RecyclView点击事件接口
    public interface OnItemClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    //设置点击事件
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    //构造参数
    public FriendsListAdapter(Context context, List<Friends.DataBean.FuiListBean> list, boolean isChange) {
        this.context = context;
        this.list = list;
        this.isChange = isChange;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.visitor_list_layout, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder holder1 = (MyViewHolder) holder;
        Friends.DataBean.FuiListBean fuiListBean = list.get(position);
        with = Glide.with(context);
        if (fuiListBean.getPicture().equals("baidu.com")) {
            with.load("https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg").transform(new GlideCircleTransform(context)).into(holder1.visitorTou);
        } else {
            with.load(fuiListBean.getPicture()).transform(new GlideCircleTransform(context)).into(holder1.visitorTou);
        }
//        if(isChange==false)
//        {
//            holder1.visitorTime.setText();
//        }
        if(!isChange)
        {
            ViewGroup.LayoutParams layoutParams = holder1.visitorTou.getLayoutParams();
            layoutParams.height=300;
            layoutParams.width=300;
            holder1.visitorTou.setLayoutParams(layoutParams);
            holder1.visitorTime.setText(TimeConvertUtil.getTimeInterval(fuiListBean.getFrTime()));
        }
        holder1.visitorTou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder1.deleteBg.setVisibility(View.GONE);
            }
        });
        holder1.visitorTou.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                holder1.deleteBg.setVisibility(View.VISIBLE);
                return true;
            }
        });
        holder1.deleteBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new BlurPopWin.Builder(context).setContent("删除后,好友将不会在出现在您的好友列表!")
                        //Radius越大耗时越长,被图片处理图像越模糊
                        .setRadius(3).setTitle("删除好友")
                        //设置居中还是底部显示
                        .setshowAtLocationType(0)
                        .onClick(new BlurPopWin.PopupCallback() {
                            @Override
                            public void onCancelClick(@NonNull BlurPopWin blurPopWin) {
                                blurPopWin.dismiss();
                            }

                            @Override
                            public void onAffirmClick(@NonNull BlurPopWin blurPopWin) {
                                blurPopWin.dismiss();
                            }
                        }).show(holder1.deleteBg);
            }
        });
        //判断点击接口是否为空
        if (mOnItemClickListener != null) {
            //点击事件
            holder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);

                }
            });
            //长按点击事件
            holder1.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(position);

                    return true;
                }
            });
        }

    }

    //返回条目数
    @Override
    public int getItemCount() {
        return setListSize();
    }

    //使用viewHolder类
    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView visitorTou;
        private TextView visitorTime;
        private ImageView deleteBg;

        public MyViewHolder(View itemView) {
            super(itemView);
            visitorTou = itemView.findViewById(R.id.visitor_tou);
            visitorTime = itemView.findViewById(R.id.visitor_time);
            deleteBg = itemView.findViewById(R.id.delete_bg);

        }
    }

    //设置list返回长度
    public int setListSize() {
        size = list.size();
        if (isChange) {
            return size >= 5 ? 5 : size;
        } else {
            return size;
        }


    }
}
