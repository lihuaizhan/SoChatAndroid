package com.hyphenate.easeui.widget.chatrow;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.easeui.R;
import com.hyphenate.easeui.utils.EaseSmileUtils;
import com.hyphenate.easeui.utils.EaseUserUtils;
import com.hyphenate.exceptions.HyphenateException;
import com.lidroid.xutils.util.LogUtils;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class EaseChatRowText extends EaseChatRow {

    private TextView contentView;
    private RelativeLayout praise_bubble;
    private TextView praise_num;
    private RelativeLayout red_bubble;
    private RelativeLayout bubble;

    public EaseChatRowText(Context context, EMMessage message, int position, BaseAdapter adapter) {
        super(context, message, position, adapter);
    }
    @Override
    protected void onInflateView() {
            inflater.inflate(message.direct() == EMMessage.Direct.RECEIVE ?
                    R.layout.ease_row_received_message : R.layout.ease_row_sent_message, this);
    }

    @Override
    protected void onFindViewById() {
        contentView = (TextView) findViewById(R.id.tv_chatcontent);
        praise_bubble= (RelativeLayout) findViewById(R.id.praise_bubble);
        praise_num= (TextView) findViewById(R.id.praise_num);
        red_bubble= (RelativeLayout) findViewById(R.id.red_bubble);
        bubble= (RelativeLayout) findViewById(R.id.bubble);
    }

    @Override
    public void onSetUpView() {
        String messageType=null;
        try {
             messageType = message.getStringAttribute(EaseUserUtils.MESSAGETYPE);
        } catch (HyphenateException e) {
            e.printStackTrace();

        }
        if(null!=messageType){
            switch (messageType){
                case "praiseType"://收到点赞消息
                    String stringAttribute = null;
                    try {
                        stringAttribute = message.getStringAttribute(EaseUserUtils.PRAISEFLAG);
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                    }
                    bubble.setVisibility(GONE);
                    red_bubble.setVisibility(GONE);
                    praise_bubble.setVisibility(VISIBLE);
                    praise_num.setText("x"+stringAttribute);
                    break;
                case "redType"://收到红包消息
                    bubble.setVisibility(GONE);
                    red_bubble.setVisibility(VISIBLE);
                    praise_bubble.setVisibility(GONE);
                    break;
                default:
                    break;
            }
        }else {
            bubble.setVisibility(VISIBLE);
            red_bubble.setVisibility(GONE);
            praise_bubble.setVisibility(GONE);
            EMTextMessageBody txtBody = (EMTextMessageBody) message.getBody();
            Spannable span = EaseSmileUtils.getSmiledText(context, txtBody.getMessage());
            // 设置内容
            contentView.setText(span, BufferType.SPANNABLE);
        }
        handleTextMessage();
    }

    protected void handleTextMessage() {
        if (message.direct() == EMMessage.Direct.SEND) {
            setMessageSendCallback();
            switch (message.status()) {
                case CREATE:
                    progressBar.setVisibility(View.GONE);
                    statusView.setVisibility(View.VISIBLE);
                    break;
                case SUCCESS:
                    progressBar.setVisibility(View.GONE);
                    statusView.setVisibility(View.GONE);
                    break;
                case FAIL:
                    progressBar.setVisibility(View.GONE);
                    statusView.setVisibility(View.VISIBLE);
                    break;
                case INPROGRESS:
                    progressBar.setVisibility(View.VISIBLE);
                    statusView.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        } else {
            if (!message.isAcked() && message.getChatType() == ChatType.Chat) {
                try {
                    EMClient.getInstance().chatManager().ackMessageRead(message.getFrom(), message.getMsgId());
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onUpdateView() {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onBubbleClick() {
        // TODO Auto-generated method stub
    }
}
