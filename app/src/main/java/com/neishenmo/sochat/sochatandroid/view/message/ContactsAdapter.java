package com.neishenmo.sochat.sochatandroid.view.message;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.utils.StringUtil;
import com.neishenmo.sochat.sochatandroid.utils.glide.GlideUtil;

import java.util.List;



/**
 * Created by Administrator on 2018/2/3.
 */

public class ContactsAdapter extends RecyclerArrayAdapter<MemberModel> {
    private int position;
    private boolean flag;
    private CallBack mCallBack;
    public interface CallBack {
        void click(View v, int postion);
    }
    public ContactsAdapter(Activity activity, CallBack mCallBack) {
        super(activity);
        this.mCallBack=mCallBack;
    }

    public void setSelected(int position) {
        this.position = position;
    }

    public void setDelete(boolean flag) {
        this.flag = flag;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CircleViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        CircleViewHolder viewHolder = (CircleViewHolder) holder;
        if (flag) {
            viewHolder.delete.setVisibility(View.VISIBLE);
            viewHolder.delete_x.setVisibility(View.VISIBLE);
        } else {
            viewHolder.delete.setVisibility(View.GONE);
            viewHolder.delete_x.setVisibility(View.GONE);
        }
        if (this.position == position) {
            viewHolder.avatar.setVisibility(View.GONE);
            viewHolder.selected.setVisibility(View.VISIBLE);
            viewHolder.delete_x.setVisibility(View.GONE);
        } else {
            viewHolder.avatar.setVisibility(View.VISIBLE);
            viewHolder.selected.setVisibility(View.GONE);
            viewHolder.delete.setVisibility(View.GONE);
        }

    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, final int position) {
        super.OnBindViewHolder(holder, position);
        CircleViewHolder viewHolder = (CircleViewHolder) holder;
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.click(v,position);
                //删除和某个user会话，如果需要保留聊天记录，传false
                /*EMClient.getInstance().chatManager().deleteConversation(getAllData().get(position).telephone, true);
                getAllData().remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount()); //刷新被删除数据，以及其后面的数据
                LogUtils.e("删除和某人会话列表111111111");*/
            }
        });
        viewHolder.delete_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.click(v,position);
                //删除和某个user会话，如果需要保留聊天记录，传false
              /*  EMClient.getInstance().chatManager().deleteConversation(getAllData().get(position).telephone, true);
                getAllData().remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount()); //刷新被删除数据，以及其后面的数据*/
            }
        });
    }


    static class CircleViewHolder extends BaseViewHolder<MemberModel> {
        ImageView avatar;
        RelativeLayout selected;
        ImageView selsctedAvatar;
        TextView nickName;
        ImageView delete_x;
        ImageView delete;
        ImageView unreadLable;

        public CircleViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_contacts);
            avatar = $(R.id.item_contacts_avatar);
            selected = $(R.id.item_contacts_selected);
            selsctedAvatar = $(R.id.item_contacts_selected_avatar);
            nickName = $(R.id.item_contacts_selected_nickname);
            delete_x = $(R.id.item_contacts_delete);
            delete = $(R.id.item_contacts_selected_delete);
            unreadLable= $(R.id.unread_lable);
        }

        @Override
        public void setData(final MemberModel model) {
            GlideUtil.getInstance().loadCircleImage(getContext(), avatar, model.picture, R.drawable.pull_list_view_progressbar_bg);
            GlideUtil.getInstance().loadCircleImage(getContext(), selsctedAvatar, model.picture, R.drawable.useravatar1);
            if (!StringUtil.isEmpty(model.name)) {
                nickName.setText(model.name);
            } else {
                nickName.setText("昵称");
            }
        }
    }
}
