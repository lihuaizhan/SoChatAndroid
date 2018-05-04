package com.neishenmo.sochat.sochatandroid.view.relation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.adapter.LikeListAdapter;
import com.neishenmo.sochat.sochatandroid.adapter.VisitorListAdapter;
import com.neishenmo.sochat.sochatandroid.bean.Like;
import com.neishenmo.sochat.sochatandroid.bean.Visitor;

import java.util.List;

public class LikeMoreActivity extends AppCompatActivity {
    private Like likeData;
    /**
     * 访问
     */
    private TextView mLikeMoreNum;
    private RecyclerView mLikeMoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_more);
        initView();
        likeData = (Like) getIntent().getSerializableExtra("like_data");
        mLikeMoreNum.setText(likeData.getData().getAmount()+"位");
        mLikeMoreList.setLayoutManager(new GridLayoutManager(this,3));
        List<Like.DataBean.TuuiListBean> vuiList = likeData.getData().getTuuiList();
        LikeListAdapter adapter = new LikeListAdapter(this,vuiList,false);
        mLikeMoreList.setAdapter(adapter);
    }

    private void initView() {
        mLikeMoreNum = (TextView) findViewById(R.id.like_more_num);
        mLikeMoreList = (RecyclerView) findViewById(R.id.like_more_list);
    }
}
