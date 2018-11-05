package com.neishenmo.sochat.sochatandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.LoveListBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2018\5\2 0002.
 */

public class LoveNumberAdapter extends BaseAdapter {

    private Context context;

    private List<LoveListBean.DataMapBean.ThumbsUpListBean> listBeans;

    public LoveNumberAdapter(Context context, List<LoveListBean.DataMapBean.ThumbsUpListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @Override
    public int getCount() {
        return listBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LoveNumberViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_love_number,null);
            holder = new LoveNumberViewHolder();
            holder.civ_love = convertView.findViewById(R.id.civ_love);
            holder.love_name = convertView.findViewById(R.id.love_name);
            holder.love_time = convertView.findViewById(R.id.love_time);
            holder.tv_number = convertView.findViewById(R.id.tv_number);
            convertView.setTag(holder);
        }
        else {
            holder = (LoveNumberViewHolder) convertView.getTag();
        }
        Glide.with(context).load(listBeans.get(position).getPicture()).into(holder.civ_love);
        holder.love_name.setText(listBeans.get(position).getNickName());
        holder.love_time.setText(listBeans.get(position).getTuTime());
        holder.tv_number.setText(String.valueOf(listBeans.get(position).getAmount()));
        return convertView;
    }

    class LoveNumberViewHolder{
        CircleImageView civ_love;
        TextView love_name;
        TextView love_time;
        TextView tv_number;
    }
}
