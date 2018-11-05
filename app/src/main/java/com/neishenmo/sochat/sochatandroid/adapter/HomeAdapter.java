package com.neishenmo.sochat.sochatandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.HomeOthers;
import com.neishenmo.sochat.sochatandroid.utils.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2018-05-25.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RequestManager with;
private List<HomeOthers.DataBean.OnlineUserListBean> list;
private LayoutInflater inflater;
private Context context;

    public HomeAdapter(List<HomeOthers.DataBean.OnlineUserListBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.item_layouts,parent,false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MyViewHolder holder1 = (MyViewHolder) holder;
        with = Glide.with(context);
        HomeOthers.DataBean.OnlineUserListBean onlineUserListBean = list.get(position);
        with.load(onlineUserListBean.getPicture()).transform(new GlideCircleTransform(context)).into(holder1.tou);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
private ImageView tou;
        public MyViewHolder(View itemView) {
            super(itemView);
            tou= itemView.findViewById(R.id.head);
        }
    }
}
