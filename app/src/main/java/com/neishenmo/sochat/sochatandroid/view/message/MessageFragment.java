package com.neishenmo.sochat.sochatandroid.view.message;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMConversationListener;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.utils.EaseUserUtils;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.base.BaseFragment;
import com.neishenmo.sochat.sochatandroid.utils.AutoUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-04-24.
 */

public class MessageFragment extends BaseFragment {
    private final static int MSG_REFRESH = 2;
    private RecyclerView mRecyclerView;
    private List<Integer> mDatas;
    //    private GalleryAdapter mAdapter;
    protected List<EMConversation> conversationList = new ArrayList<EMConversation>();
    private ArrayList<MemberModel> datas = new ArrayList<>();
    protected EMConversationListener convListener = new EMConversationListener() {
        @Override
        public void onCoversationUpdate() {
            refresh();
        }

    };
    private String tochatUserName;
    private RecyclerView recyclerView;
    private ContactsAdapter adapter;
    private EaseChatFragment chatFragment;
    private SharedPreferences sp;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_layout, container, false);
//        SharedPreferences sp = getActivity().getSharedPreferences("user",getActivity().MODE_PRIVATE);
        sp = getActivity().getSharedPreferences("config", getActivity().MODE_PRIVATE);
//        EaseChatFragment chatFragment = new EaseChatFragment();
//        chatFragment.hideTitleBar();
//        //传入参数
//        Bundle args = new Bundle();
//        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
//        args.putString(EaseConstant.EXTRA_USER_ID, "开发测试");
//        chatFragment.setArguments(args);
//        getFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();
//        initDatas();

        datas = initConversationData();


//得到控件
        recyclerView = (RecyclerView) view.findViewById(R.id.recy);
        AutoUtils.auto(recyclerView);
        LinearLayoutManager ms = new LinearLayoutManager(getContext());
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);// 设置 recyclerview 布局方式为横向布局
        recyclerView.setLayoutManager(ms);
        recyclerView.setAdapter(adapter = new ContactsAdapter(getActivity(), new ContactsAdapter.CallBack() {
            @Override
            public void click(View v, int postion) {
                if (postion < datas.size()) {
                    EMClient.getInstance().chatManager().deleteConversation(datas.get(postion).telephone, true);
                    refresh();
                }
            }
        }));
        adapter.addAll(datas);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                adapter.setSelected(position);
                adapter.notifyDataSetChanged();
//                viewPager.setCurrentItem(position);
                EMConversation conversation = conversationList.get(position);
                tochatUserName = conversation.conversationId();
//                dealWithRedOrPraise(conversation);
                if (tochatUserName.equals(EMClient.getInstance().getCurrentUser()))
                    Toast.makeText(getActivity(), R.string.Cant_chat_with_yourself, Toast.LENGTH_SHORT).show();
                else {
                    // start chat acitivity
                    chatFragment = new EaseChatFragment();
                    //pass parameters to chat fragment
                    Bundle args = new Bundle();
                    args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
                    args.putString(EaseConstant.EXTRA_USER_ID,datas.get(position).telephone);
                    chatFragment.setArguments(args);
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();
                }
            }
        });
//设置布局管理器
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(linearLayoutManager);
////设置适配器
//        mAdapter = new GalleryAdapter(getActivity(), conversationList);
//        conversationList.addAll(loadConversationList());
//        mAdapter.setOnItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClick(String position) {
////                Toast.makeText(getActivity(), "123456788"+position, Toast.LENGTH_SHORT).show();
//
//                EaseChatFragment chatFragment = new EaseChatFragment();
//                chatFragment.hideTitleBar();
//                //传入参数
//                Bundle args = new Bundle();
//                args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
//                args.putString(EaseConstant.EXTRA_USER_ID,position );
//                chatFragment.setArguments(args);
//
//
//                getFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();
//
//
//
//            }
//        });
////        myAdapter=new ConversationAdapter(getActivity(),0,conversationList);
////        myAdapter=new ConversationAdapter(getActivity(),0,mDatas)
//        mRecyclerView.setAdapter(mAdapter);

////会话列表控件
//        conversationListView = (EaseConversationList) getView().findViewById(R.id.list);
////初始化，参数为会话列表集合
//        conversationListView.init(conversationList);
////刷新列表
//        conversationListView.refresh();
//
//        conversationListFragment = new EaseConversationListFragment();
//        conversationListFragment.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {
//            @Override
//            public void onListItemClicked(EMConversation conversation) {
//                Toast.makeText(getActivity(), "..............", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        getFragmentManager().beginTransaction().add(R.id.fragment_container, conversationListFragment).show(conversationListFragment)
//                .commit();
        return view;
    }

    private ArrayList<MemberModel> initConversationData() {
        conversationList = loadConversationList();
        ArrayList<MemberModel> datas = new ArrayList<>();
        for (int i = 0; i < conversationList.size(); i++) {
            String userPhoneNum = conversationList.get(i).conversationId();
            datas.add(new MemberModel(sp.getString("tx",""),sp.getString("xm",""), userPhoneNum));
        }
        return datas;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setDefaultFragmentTitle(String title) {

    }

    private void initRecyclerView() {
//        if(null!=datas&&datas.size()>0){
//            tochatUserName =datas.get(0).telephone;
//        }
        AutoUtils.auto(recyclerView);
        LinearLayoutManager ms = new LinearLayoutManager(getContext());
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);// 设置 recyclerview 布局方式为横向布局
        recyclerView.setLayoutManager(ms);
        recyclerView.setAdapter(adapter = new ContactsAdapter(getActivity(), new ContactsAdapter.CallBack() {
            @Override
            public void click(View v, int postion) {
                if (postion < datas.size()) {
                    EMClient.getInstance().chatManager().deleteConversation(datas.get(postion).telephone, true);
                    refresh();
                }
            }
        }));

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                adapter.setSelected(position);
                adapter.notifyDataSetChanged();
//                viewPager.setCurrentItem(position);
                EMConversation conversation = conversationList.get(position);
                tochatUserName = conversation.conversationId();
//                dealWithRedOrPraise(conversation);
                if (tochatUserName.equals(EMClient.getInstance().getCurrentUser()))
                    Toast.makeText(getActivity(), R.string.Cant_chat_with_yourself, Toast.LENGTH_SHORT).show();
                else {
                    // start chat acitivity
                    chatFragment = new EaseChatFragment();
                    //pass parameters to chat fragment
                    Intent intent = new Intent();
//                // it's single chat
                    intent.putExtra(EaseUserUtils.FROM_MEMBER_ID, datas.get(position).telephone);
                    intent.putExtra(EaseUserUtils.FROM_AVATAR, position);
                    chatFragment.setArguments(intent.getExtras());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();
                }
            }
        });
    }

    private void initDatas() {
//        mDatas = new ArrayList<>(Arrays.asList(R.mipmap.ic_launcher, R.drawable.ease_blue_add, R.drawable.ease_default_avatar, R.drawable.ease_default_expression, R.drawable.ease_default_image, R.drawable.common_google_signin_btn_icon_dark_focused, R.drawable.ease_new_friends_icon, R.drawable.ease_location_msg, R.drawable.ease_groups_icon));

    }

    //    public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
//        private LayoutInflater mInflater;
//        private List<EMConversation> conversationList;
//        public GalleryAdapter(Context context, List<EMConversation> list)
//        {
//            mInflater = LayoutInflater.from(context);
//            conversationList = list;
//        }
//        public class ViewHolder extends RecyclerView.ViewHolder
//        {
//            public ViewHolder(View arg0)
//            {
//                super(arg0);
//            }
//            //            ImageView mImg;
////            TextView mTxt;
//            TextView name;
//            /** unread message count */
//            TextView unreadLabel;
//            /** avatar */
//            EaseImageView avatar;
//
//        }
//        @Override
//        public int getItemCount()
//        {
//            return conversationList.size();
//        }
//        /**
//         * 创建ViewHolder
//         */
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
//        {
//            View view = mInflater.inflate(R.layout.activity_recycler_item,
//                    viewGroup, false);
//            ViewHolder viewHolder = new ViewHolder(view);
//            viewHolder.name = (TextView) view.findViewById(R.id.name);
//            viewHolder.unreadLabel = (TextView) view.findViewById(R.id.unread_msg_number);
//            viewHolder.avatar = (EaseImageView) view.findViewById(R.id.avatar);
//
//
//            return viewHolder;
//        }
//        /**
//         * 设置值
//         */
//        @Override
//        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
//
//            final EMConversation conversation = conversationList.get(i);
//            if (conversation.getUnreadMsgCount() > 0) {
//                // show unread message count
//                viewHolder.unreadLabel.setText(String.valueOf(conversation.getUnreadMsgCount()));
//                viewHolder.unreadLabel.setVisibility(View.VISIBLE);
//            } else {
//                viewHolder.unreadLabel.setVisibility(View.INVISIBLE);
//            }
////            viewHolder.avatar.setImageResource(conversationList.get(i).getLastMessage().get.get(i));
//            viewHolder.name.setText(conversationList.get(i).getLastMessage().getUserName());
//
//            if (mListener != null) {
//                //绑定点击事件
//                viewHolder.avatar.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //把条目的位置回调回去
//                        mListener.onItemClick(conversationList.get(i).getLastMessage().getUserName());
//                        viewHolder.unreadLabel.setVisibility(View.INVISIBLE);
//                    }
//                });
//            }
//
//        }
//
//
//
//        public ItemClickListener mListener;
//
//        public void setOnItemClickListener(ItemClickListener listener) {
//            this.mListener = listener;
//        }
//
//
//
//    }
    protected List<EMConversation> loadConversationList() {
        // get all conversations
        Map<String, EMConversation> conversations = EMClient.getInstance().chatManager().getAllConversations();
        List<Pair<Long, EMConversation>> sortList = new ArrayList<Pair<Long, EMConversation>>();
        /**
         * lastMsgTime will change if there is new message during sorting
         * so use synchronized to make sure timestamp of last message won't change.
         */
        synchronized (conversations) {
            for (EMConversation conversation : conversations.values()) {
                if (conversation.getAllMessages().size() != 0) {
                    sortList.add(new Pair<Long, EMConversation>(conversation.getLastMessage().getMsgTime(), conversation));
                }
            }
        }
        try {
            // Internal is TimSort algorithm, has bug
            sortConversationByLastChatTime(sortList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<EMConversation> list = new ArrayList<EMConversation>();
        for (Pair<Long, EMConversation> sortItem : sortList) {
            list.add(sortItem.second);
        }
        return list;
    }

    private void sortConversationByLastChatTime(List<Pair<Long, EMConversation>> conversationList) {
        Collections.sort(conversationList, new Comparator<Pair<Long, EMConversation>>() {
            @Override
            public int compare(final Pair<Long, EMConversation> con1, final Pair<Long, EMConversation> con2) {

                if (con1.first.equals(con2.first)) {
                    return 0;
                } else if (con2.first.longValue() > con1.first.longValue()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        });
    }

    protected android.os.Handler handler = new android.os.Handler() {
        public void handleMessage(android.os.Message msg) {

            conversationList.clear();
            conversationList.addAll(loadConversationList());
        }
    };


    protected boolean hidden;
    protected boolean isConflict;
    protected EMConnectionListener connectionListener = new EMConnectionListener() {

        @Override
        public void onDisconnected(int error) {
            if (error == EMError.USER_REMOVED || error == EMError.USER_LOGIN_ANOTHER_DEVICE || error == EMError.SERVER_SERVICE_RESTRICTED) {
                isConflict = true;
            } else {
                handler.sendEmptyMessage(0);
            }
        }

        @Override
        public void onConnected() {
            handler.sendEmptyMessage(1);
        }
    };

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.hidden = hidden;
        if (!hidden && !isConflict) {
            refresh();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        conversationList.clear();
        conversationList.addAll(loadConversationList());
        if (!hidden) {
            refresh();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EMClient.getInstance().removeConnectionListener(connectionListener);
    }

    public void refresh() {
        if (!handler.hasMessages(MSG_REFRESH)) {
            handler.sendEmptyMessage(MSG_REFRESH);
        }
    }

}
