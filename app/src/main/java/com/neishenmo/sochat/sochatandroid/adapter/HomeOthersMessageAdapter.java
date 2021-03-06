package com.neishenmo.sochat.sochatandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.Friends;
import com.neishenmo.sochat.sochatandroid.bean.HomeOthers;
import com.neishenmo.sochat.sochatandroid.utils.GlideCircleTransform;
import com.neishenmo.sochat.sochatandroid.utils.StringUtil;
import com.neishenmo.sochat.sochatandroid.utils.StringUtils;
import com.neishenmo.sochat.sochatandroid.utils.TimeConvertUtil;

import java.util.List;


/**
 * Created by Administrator on 2018-04-25.
 * 喜欢数据适配器
 */

public class HomeOthersMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RequestManager with;
    private Context context;
    private List<HomeOthers.DataBean.OnlineUserListBean> list;
    private LayoutInflater inflater;
    private int size;
    private boolean isChange;
    private OnItemClickListener mOnItemClickListener;
    private AlphaAnimation mHideAnimation;
    private AlphaAnimation mShowAnimation;
  private int i;
    //定义RecyclView点击事件接口
    public interface OnItemClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }
    private interface InGetPosition{

    }

    //设置点击事件
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    //构造参数
    public HomeOthersMessageAdapter(Context context, List<HomeOthers.DataBean.OnlineUserListBean> list, boolean isChange) {
        this.context = context;
        this.list = list;
        this.isChange = isChange;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.home_recycle_page, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        HomeOthers.DataBean.OnlineUserListBean onlineUserListBean = list.get(position);
        with = Glide.with(context);

        try {

           i = TimeConvertUtil.ConverToDate(onlineUserListBean.getBirthday());

        } catch (Exception e) {
            e.printStackTrace();
        }
        holder1.otherOld.setText(i+"岁");
        String s = StringUtils.toUtf8(onlineUserListBean.getNickName());
        holder1.otherName.setText(s);

        holder1.otherUss.setText(onlineUserListBean.getConstellation());

        if (onlineUserListBean.getPicture().equals("baidu.com")) {
            with.load("https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg").transform(new GlideCircleTransform(context)).into(holder1.otherPicture);
        } else {
            with.load(onlineUserListBean.getPicture()).transform(new GlideCircleTransform(context)).into(holder1.otherPicture);
        }
//        if(isChange==false)
//        {
//            holder1.visitorTime.setText();
//        }
        if(!isChange)
        {
//            ViewGroup.LayoutParams layoutParams = holder1.otherPicture.getLayoutParams();
//            layoutParams.height=300;
//            layoutParams.width=300;
//            holder1.otherPicture.setLayoutParams(layoutParams);
            holder1.otherRegis.setText(TimeConvertUtil.getTimeInterval(onlineUserListBean.getLastActiveTime()));
        }
//         if(position>0)
//         {
////             setHideAnimation(holder1.otherName,1000);
////             setHideAnimation(holder1.lable,1000);
//             setShowAnimation(holder1.otherName,500);
//             setShowAnimation(holder1.lable,500);
//         }
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

        private TextView otherName;
        private TextView otherOld;
        private TextView otherUss;
        private TextView otherRegis;
        private ImageView otherPicture;
        private LinearLayout lable;
        public MyViewHolder(View itemView) {
            super(itemView);
            otherName = itemView.findViewById(R.id.other_name);
            otherOld = itemView.findViewById(R.id.other_old);
            otherUss = itemView.findViewById(R.id.other_uss);
            otherRegis = itemView.findViewById(R.id.other_regis);
            otherPicture = itemView.findViewById(R.id.other_picture);
            lable = itemView.findViewById(R.id.ll_lable);

        }
    }

    //设置list返回长度
    public int setListSize() {
        size = list.size();
        return size;
    }

    //淡入淡出动画
    public  void setHideAnimation( final View view, int duration)
    {
        if (null == view || duration < 0)
        {
            return;
        }

        if (null != mHideAnimation)
        {
            mHideAnimation.cancel();
        }
        // 监听动画结束的操作
        mHideAnimation = new AlphaAnimation(1.0f, 0.0f);
        mHideAnimation.setDuration(duration);
        mHideAnimation.setFillAfter(true);
        mHideAnimation.setAnimationListener(new Animation.AnimationListener()
        {

            @Override
            public void onAnimationStart(Animation arg0)
            {

            }

            @Override
            public void onAnimationRepeat(Animation arg0)
            {

            }

            @Override
            public void onAnimationEnd(Animation arg0)
            {
                view.setVisibility(View.GONE);
            }
        });
        view.startAnimation(mHideAnimation);
    }
    public  void setShowAnimation( final View view, int duration)
    {
        if (null == view || duration < 0)
        {
            return;
        }
        if (null != mShowAnimation)
        {
            mShowAnimation.cancel();
        }
        mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
        mShowAnimation.setDuration(duration);
        mShowAnimation.setFillAfter(true);
        mShowAnimation.setAnimationListener(new Animation.AnimationListener()
        {

            @Override
            public void onAnimationStart(Animation arg0)
            {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation arg0)
            {

            }

            @Override
            public void onAnimationEnd(Animation arg0)
            {

            }
        });
        view.startAnimation(mShowAnimation);
    }
}
