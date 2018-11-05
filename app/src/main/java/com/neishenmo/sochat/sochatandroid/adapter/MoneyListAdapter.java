package com.neishenmo.sochat.sochatandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.bean.MoneyListBean;

import java.util.List;

/**
 * Created by Administrator on 2018\5\3 0003.
 */

public class MoneyListAdapter extends BaseAdapter {
    private Context context;
    private List<MoneyListBean.DataMapBean.RedPacketListBean> mList;

    public MoneyListAdapter(Context context, List<MoneyListBean.DataMapBean.RedPacketListBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MoneyListViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_choice_head,null);
            holder = new MoneyListViewHolder();
            holder.mMoneyType = convertView.findViewById(R.id.monet_type);
            holder.mMoneyTime = convertView.findViewById(R.id.money_time);
            holder.mMoneyNumber = convertView.findViewById(R.id.monet_number);
            convertView.setTag(holder);
        }
        else {
            holder = (MoneyListViewHolder) convertView.getTag();
        }
        if (mList.get(position).getType() == 0){
            holder.mMoneyType.setText("发出红包");
            holder.mMoneyNumber.setText("-"+mList.get(position).getPicture());
        }
        else if (mList.get(position).getType() == 1){
            holder.mMoneyType.setText("接收红包");
            holder.mMoneyNumber.setText("+"+mList.get(position).getPicture());
        }
        holder.mMoneyTime.setText(mList.get(position).getTime());

        return convertView;
    }

    class MoneyListViewHolder{
        TextView mMoneyType;
        TextView mMoneyTime;
        TextView mMoneyNumber;
    }
}
