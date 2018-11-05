package com.neishenmo.sochat.sochatandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.Like;
import com.neishenmo.sochat.sochatandroid.bean.Visitor;
import com.neishenmo.sochat.sochatandroid.utils.GlideCircleTransform;
import com.neishenmo.sochat.sochatandroid.utils.TimeConvertUtil;

import java.util.List;


/**
 * Created by Administrator on 2018-04-25.
 * 喜欢数据适配器
 */

public class LikeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RequestManager with;
    private Context context;
    private List<Like.DataBean.TuuiListBean> list;
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
    public LikeListAdapter(Context context, List<Like.DataBean.TuuiListBean> list, boolean isChange) {
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Like.DataBean.TuuiListBean tuuiListBean = list.get(position);
        with = Glide.with(context);
        if (tuuiListBean.getPicture().equals("baidu.com")) {
            with.load("https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg").transform(new GlideCircleTransform(context)).into(holder1.visitorTou);
        } else {
            with.load(tuuiListBean.getPicture()).transform(new GlideCircleTransform(context)).into(holder1.visitorTou);
        }
        if(!isChange)
        {
            ViewGroup.LayoutParams layoutParams = holder1.visitorTou.getLayoutParams();
            layoutParams.height=300;
            layoutParams.width=300;
            holder1.visitorTou.setLayoutParams(layoutParams);
            holder1.visitorTime.setText(TimeConvertUtil.getTimeInterval(tuuiListBean.getTuTime()));
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
        private ImageView visitorTou;
        private TextView visitorTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            visitorTou = itemView.findViewById(R.id.visitor_tou);
            visitorTime = itemView.findViewById(R.id.visitor_time);

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
