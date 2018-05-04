package com.neishenmo.sochat.sochatandroid.view.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.widget.EaseImageView;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.base.BaseFragment;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018-04-24.
 */

public class MessageFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private List<Integer> mDatas;
    private GalleryAdapter mAdapter;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_layout, container, false);
//        SharedPreferences sp = getActivity().getSharedPreferences("user",getActivity().MODE_PRIVATE);

        EaseChatFragment chatFragment = new EaseChatFragment();
        chatFragment.hideTitleBar();
        //传入参数
        Bundle args = new Bundle();
        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
        args.putString(EaseConstant.EXTRA_USER_ID, "88888888");
        chatFragment.setArguments(args);
        getFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();

        initDatas();
//得到控件
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recy);
//设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
//设置适配器
        mAdapter = new GalleryAdapter(getActivity(), mDatas);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setDefaultFragmentTitle(String title) {

    }


    private void initDatas()
    {
        mDatas = new ArrayList<>(Arrays.asList(R.mipmap.ic_launcher,
                R.drawable.ease_blue_add, R.drawable.ease_default_avatar, R.drawable.ease_default_expression, R.drawable.ease_default_image,
                R.drawable.common_google_signin_btn_icon_dark_focused, R.drawable.ease_new_friends_icon, R.drawable.ease_location_msg, R.drawable.ease_groups_icon));
    }
    public class GalleryAdapter extends
            RecyclerView.Adapter<GalleryAdapter.ViewHolder>
    {
        private LayoutInflater mInflater;
        private List<Integer> mDatas;
        public GalleryAdapter(Context context, List<Integer> datats)
        {
            mInflater = LayoutInflater.from(context);
            mDatas = datats;
        }
        public class ViewHolder extends RecyclerView.ViewHolder
        {
            public ViewHolder(View arg0)
            {
                super(arg0);
            }
            EaseImageView mImg;
            TextView mTxt;
        }
        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }
        /**
         * 创建ViewHolder
         */
        @Override
        public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
        {
            View view = mInflater.inflate(R.layout.activity_recycler_item,
                    viewGroup, false);
            GalleryAdapter.ViewHolder viewHolder = new GalleryAdapter.ViewHolder(view);
            viewHolder.mImg = (EaseImageView) view
                    .findViewById(R.id.id_index_gallery_item_image);
            viewHolder.mImg.setShapeType(1);
            return viewHolder;
        }
        /**
         * 设置值
         */
        @Override
        public void onBindViewHolder(final GalleryAdapter.ViewHolder viewHolder, final int i)
        {
            viewHolder.mImg.setImageResource(mDatas.get(i));
        }
    }


}
