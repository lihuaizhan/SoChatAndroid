package com.neishenmo.sochat.sochatandroid.view.homepage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.neishenmo.sochat.sochatandroid.bean.HomeListBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2018\5\2 0002.
 */

class HomeAdapter extends PagerAdapter {

    private Context context;
    private List<HomeListBean> mList;
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        CircleImageView circleImageView = new CircleImageView(context);
//        Glide.with(context)
//                .load(mList.get(position).getData().getOnlineUserList().get)
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
