package com.neishenmo.sochat.sochatandroid.view.relation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.adapter.FriendsListAdapter;
import com.neishenmo.sochat.sochatandroid.adapter.LikeListAdapter;
import com.neishenmo.sochat.sochatandroid.adapter.VisitorListAdapter;
import com.neishenmo.sochat.sochatandroid.base.BaseFragment;
import com.neishenmo.sochat.sochatandroid.bean.Friends;
import com.neishenmo.sochat.sochatandroid.bean.Like;
import com.neishenmo.sochat.sochatandroid.bean.Visitor;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.requestbean.RelationShipRequest;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2018-04-24.
 */

public class RelationFragment extends BaseFragment {
    private RecyclerView visitorRc;
    private RecyclerView likeRc;
    private RecyclerView friendsRc;
    private TextView visitorNum;
    private TextView likeNum;
    private TextView friendsNum;
    private View view;
    private ImageView visitorMore;
    private ImageView likeMore;
    private ImageView friendsMore;
    private  SharedPreferences user;
    private  ServiceApi serviceApi;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.relation_layout, container, false);
        return view;
    }

    @Override
    protected void initData() {
        //获取控件id
        visitorRc = view.findViewById(R.id.visitor_list);
        likeRc = view.findViewById(R.id.like_list);
        friendsRc = view.findViewById(R.id.friends_list);
        visitorNum = view.findViewById(R.id.visitor_num);
        likeNum = view.findViewById(R.id.like_num);
        friendsNum = view.findViewById(R.id.friends_num);
        visitorMore = view.findViewById(R.id.visitor_more);
        likeMore = view.findViewById(R.id.like_more);
        friendsMore = view.findViewById(R.id.friends_more);
        user = getActivity().getSharedPreferences("user", 0);


        RelationShipRequest request = new RelationShipRequest("1", user.getString("token",""));
        serviceApi = RetrofitHelper.getServiceApi();
        //来访数据请求
        serviceApi.getVisitor(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Visitor>() {
                    @Override
                    public void accept(final Visitor visitor) throws Exception {

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        //recyclerView设置布局管理器
                        visitorRc.setLayoutManager(linearLayoutManager);
                        //拿到数据
                        final Visitor.DataBean data = visitor.getData();
                        List<Visitor.DataBean.VuiListBean> vuiList = data.getVuiList();
                        if(vuiList.size()>5)
                        {
                            visitorMore.setVisibility(View.VISIBLE);
                        }
                        visitorNum.setText(visitor.getData().getVuiAmount()+"位");
                        //实例化适配器
                        VisitorListAdapter adapter = new VisitorListAdapter(getActivity(), vuiList, true);
                        //添加适配器
                        visitorRc.setAdapter(adapter);

                        //访问查看更多
                        visitorMore.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                               Intent intent = new Intent(getActivity(),VisitorMoreActivity.class);
                                intent.putExtra("visitor_data", visitor);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.zoom_out,R.anim.zoom_in);
                            }
                        });
//                        //点击事件
//                        adapter.setOnItemClickListener(new VisitorListAdapter.OnItemClickListener() {
//                            @Override
//                            public void onClick(int position) {
//                                Toast.makeText(getActivity(),"您点击了"+position+"行",Toast.LENGTH_SHORT).show();
//                            }
//                            @Override
//                            public void onLongClick(int position) {
//                                Toast.makeText(getActivity(),"您长按点击了"+position+"行",Toast.LENGTH_SHORT).show();
//                            }
//                        });
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        //喜欢数据请求
        serviceApi.getLike(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Like>() {
                    @Override
                    public void accept(final Like like) throws Exception {
                        likeNum.setText(like.getData().getAmount()+"位");
                        //recyclerView设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        likeRc.setLayoutManager(linearLayoutManager);
                        //拿到数据
                        List<Like.DataBean.TuuiListBean> vuiList = like.getData().getTuuiList();
                        if(vuiList.size()>5)
                        {
                            likeMore.setVisibility(View.VISIBLE);
                        }
                        //实例化适配器
                        LikeListAdapter likeAdapter = new LikeListAdapter(getActivity(), vuiList, true);
                        //添加适配器
                        likeRc.setAdapter(likeAdapter);
                        //喜欢查看更多
                        likeMore.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(),LikeMoreActivity.class);
                                intent.putExtra("like_data", like);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.zoom_out,R.anim.zoom_in);
                            }
                        });
//                        //点击事件
//                        adapter.setOnItemClickListener(new VisitorListAdapter.OnItemClickListener() {
//                            @Override
//                            public void onClick(int position) {
//                                Toast.makeText(getActivity(),"您点击了"+position+"行",Toast.LENGTH_SHORT).show();
//                            }
//                            @Override
//                            public void onLongClick(int position) {
//                                Toast.makeText(getActivity(),"您长按点击了"+position+"行",Toast.LENGTH_SHORT).show();
//                            }
//                        });
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        //好友数据请求
        serviceApi.getFriends(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Friends>() {
                    @Override
                    public void accept(final Friends friends) throws Exception {
                        friendsNum.setText(friends.getData().getAmount()+"位");
                        //recyclerView设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        friendsRc.setLayoutManager(linearLayoutManager);
                        //拿到数据
                        final Friends.DataBean friendsData = friends.getData();
                        List<Friends.DataBean.FuiListBean> fuiList = friendsData.getFuiList();
                        if(fuiList.size()>5)
                        {
                            friendsMore.setVisibility(View.VISIBLE);
                        }

                        //实例化适配器
                        FriendsListAdapter friendsAdapter = new FriendsListAdapter(getActivity(), fuiList, true);
                        //添加适配器
                        friendsRc.setAdapter(friendsAdapter);

                        //好友查看更多
                        friendsMore.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(),FriendsMoreActivity.class);
                                intent.putExtra("friend_data", friends);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.zoom_out,R.anim.zoom_in);
                            }
                        });
//                        //点击事件
//                        adapter.setOnItemClickListener(new VisitorListAdapter.OnItemClickListener() {
//                            @Override
//                            public void onClick(int position) {
//                                Toast.makeText(getActivity(),"您点击了"+position+"行",Toast.LENGTH_SHORT).show();
//                            }
//                            @Override
//                            public void onLongClick(int position) {
//                                Toast.makeText(getActivity(),"您长按点击了"+position+"行",Toast.LENGTH_SHORT).show();
//                            }
//                        });
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {

    }
}
