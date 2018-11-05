package com.neishenmo.sochat.sochatandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.gson.Gson;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.HomeOthers;
import com.neishenmo.sochat.sochatandroid.bean.LiveContent;
import com.neishenmo.sochat.sochatandroid.bean.OtherLiveMsg;
import com.neishenmo.sochat.sochatandroid.utils.GlideCircleTransform;
import com.neishenmo.sochat.sochatandroid.utils.TimeConvertUtil;
import com.neishenmo.sochat.sochatandroid.view.particular.AMapActivity;
import com.neishenmo.sochat.sochatandroid.view.particular.ParticularActivity;

import java.util.List;


/**
 * Created by Administrator on 2018-04-25.
 * 喜欢数据适配器
 */

public class OthersMesgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RequestManager with;
    private Context context;
    private List<OtherLiveMsg.DataBean.BListBean> list;
    private LayoutInflater inflater;
    private int size;
    private boolean isChange;
    private OnItemClickListener mOnItemClickListener;
    private int i;

    //定义RecyclView点击事件接口
    public interface OnItemClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    private interface InGetPosition {

    }

    //设置点击事件
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    //构造参数
    public OthersMesgAdapter(Context context, List<OtherLiveMsg.DataBean.BListBean> list, boolean isChange) {
        this.context = context;
        this.list = list;
        this.isChange = isChange;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.others_live_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        OtherLiveMsg.DataBean.BListBean bListBean = list.get(position);
        int type = bListBean.getType();
        with = Glide.with(context);
        final LiveContent liveContent = new Gson().fromJson(bListBean.getContent(), LiveContent.class);
        String picture = liveContent.getPicture();
        String substring;
        if (type == 0) {
            if (liveContent.getLon() != null & !liveContent.getLon().equals("") & liveContent.getLat() != null & !liveContent.getLat().equals("")) {
                String s = "http://api.map.baidu.com/staticimage/v2?ak=QmvSjRZZ6ULwH3Ei3OjWpemBIcsOHhVl&mcode=C0:98:07:DF:B5:81:5B:5A:A7:E9:1D:4B:0E:12:CC:38:0C:44:0E:3B;com.neishenmo.sochat.sochatandroid&center=" +
                        liveContent.getLon() + "," + liveContent.getLat() +
                        "&width=300&height=300&zoom=15";
                with.load(s)
                        .transform(new GlideCircleTransform(context)).into(holder1.liveContent);
            }
            holder1.liveIdtor.setText(liveContent.getSimpleAddress());
            holder1.liveContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AMapActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("lat",liveContent.getLat());
                    bundle.putString("lon",liveContent.getLon());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        } else if (type == 1) {
            if (!".jpg".equals(picture.substring(picture.length() - 4, picture.length()))) {
                with.load("https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg").transform(new GlideCircleTransform(context)).into(holder1.liveContent);
            } else {

                with.load(picture).transform(new GlideCircleTransform(context)).into(holder1.liveContent);
            }
            holder1.liveIcon.setBackgroundResource(R.mipmap.love);
         //   holder1.liveIdtor.setText("+" + liveContent.getAmount());
        } else {
            if (!".jpg".equals(picture.substring(picture.length() - 4, picture.length()))) {
                with.load("https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg").transform(new GlideCircleTransform(context)).into(holder1.liveContent);
            } else {

                with.load(picture).transform(new GlideCircleTransform(context)).into(holder1.liveContent);
            }
        }
        if (!"".equals(picture) || picture != null) {
            //substring = picture.substring(0, picture.length() - 1);

        }
//        else {
//            substring="https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg";
//        }


//        try {
//
//           i = TimeConvertUtil.ConverToDate(onlineUserListBean.getBirthday());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        holder1.otherOld.setText(i+"岁");
//        holder1.otherName.setText(onlineUserListBean.getNickName());
//
//        holder1.otherUss.setText(onlineUserListBean.getConstellation());
//

//        if(isChange==false)
//        {
//            holder1.visitorTime.setText();
//        }
        if (!isChange) {
//            ViewGroup.LayoutParams layoutParams = holder1.otherPicture.getLayoutParams();
//            layoutParams.height=300;
//            layoutParams.width=300;
//            holder1.otherPicture.setLayoutParams(layoutParams);
            //  holder1.otherRegis.setText(TimeConvertUtil.getTimeInterval(onlineUserListBean.getLastActiveTime()));
        }

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

        private TextView liveIdtor;
        private ImageView liveContent;
        private ImageView liveIcon;


        public MyViewHolder(View itemView) {
            super(itemView);
            liveIdtor = itemView.findViewById(R.id.live_idtor);
            liveContent = itemView.findViewById(R.id.live_content);
            liveIcon = itemView.findViewById(R.id.live_icon);


        }
    }

    //设置list返回长度
    public int setListSize() {
        size = list.size();
        return size;
    }
}
