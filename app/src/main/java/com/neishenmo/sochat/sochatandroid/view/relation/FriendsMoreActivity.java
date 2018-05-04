package com.neishenmo.sochat.sochatandroid.view.relation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.adapter.FriendsListAdapter;
import com.neishenmo.sochat.sochatandroid.adapter.LikeListAdapter;
import com.neishenmo.sochat.sochatandroid.bean.Friends;
import com.neishenmo.sochat.sochatandroid.bean.Like;

import java.util.List;

public class FriendsMoreActivity extends AppCompatActivity {
    private Friends friendsData;
    /**
     * 访问
     */
    private TextView mFriendsMoreNum;
    private RecyclerView mFriendsMoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_more);
        initView();
        friendsData = (Friends) getIntent().getSerializableExtra("friend_data");
        mFriendsMoreNum.setText(friendsData.getData().getAmount()+"位");
        mFriendsMoreList.setLayoutManager(new GridLayoutManager(this,3));
        List<Friends.DataBean.FuiListBean> vuiList = friendsData.getData().getFuiList();
        FriendsListAdapter adapter = new FriendsListAdapter(this,vuiList,false);
        mFriendsMoreList.setAdapter(adapter);
    }

    private void initView() {
        mFriendsMoreNum = (TextView) findViewById(R.id.friends_more_num);
        mFriendsMoreList = (RecyclerView) findViewById(R.id.friends_more_list);
    }
}
