package com.hyphenate.easeui.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.R;
import com.hyphenate.easeui.controller.EaseUI;
import com.hyphenate.easeui.controller.EaseUI.EaseUserProfileProvider;
import com.hyphenate.easeui.domain.EaseUser;

import java.util.Map;

public class EaseUserUtils {
    public static String FROM_AVATAR = "avatarUrl";
    public static String FROM_MEMBER_NICK = "member_nick";
    public static String FROM_MEMBER_ID = "member_id";
    public static String TOMEMBER_ID = "tomember_id";
    public static String TOMEMBER_NICK = "tomember_nick";
    public static String TOMAVATAR = "tomavatar";
    public static String PRAISEFLAG = "praiseflag";
    public static String REDPICKID = "redPickId";
    public static String MESSAGETYPE="messagetype";//praiseType:点赞 redType：红包 2：其他消息

    static EaseUserProfileProvider userProvider;

    static {
        userProvider = EaseUI.getInstance().getUserProfileProvider();
    }

    /**
     * get EaseUser according username
     *
     * @param username
     * @return
     */
    public static EaseUser getUserInfo(String username) {
        if (userProvider != null) {
            EaseUser user = userProvider.getUser(username);
            return user;
        }

        return null;
    }

    static String fromavatar;
    static String sendavatar;//
    static String fromnick;
    static String sendnick;//
    static String myname;

    public static void setMyname(String myname) {
        EaseUserUtils.myname = myname;
    }

    public static void putNickAndAvatar(String sendnick, String fromnick, String sendavatar, String fromavatar) {
        EaseUserUtils.sendnick = sendnick;
        EaseUserUtils.fromnick = fromnick;
        EaseUserUtils.sendavatar = sendavatar;
        EaseUserUtils.fromavatar = fromavatar;
    }


    /**
     * set user avatar
     *
     * @param username
     */
    public static void setUserAvatar(Context context, EMMessage message, String username, ImageView imageView) {
        if (message != null) {
            String nickname = "";
            String avatar;

            Map<String, Object> ext = message.ext();
            if (ext != null) {
                nickname = ext.get(FROM_MEMBER_NICK) + "";
                avatar = ext.get(FROM_AVATAR) + "";

                if (username.equals(myname)) {
                    //自己
                    Glide.with(context).load(nickname).diskCacheStrategy(DiskCacheStrategy.ALL).
                            placeholder(R.drawable.ease_default_avatar).into(imageView);
                } else {
                    Glide.with(context).load(avatar).diskCacheStrategy(DiskCacheStrategy.ALL).
                            placeholder(R.drawable.ease_default_avatar).into(imageView);
                }

//                if (headimg == null)
//                    Glide.with(context).load(R.drawable.ease_default_avatar).into(imageView);
//                else {
//                    Glide.with(context).load(headimg).diskCacheStrategy(DiskCacheStrategy.ALL).
//                            placeholder(R.drawable.ease_default_avatar).into(imageView);
//                }
            }
        } else {
            EaseUser user = getUserInfo(username);
            if (user != null && user.getAvatar() != null) {
                try {
                    int avatarResId = Integer.parseInt(user.getAvatar());
                    Glide.with(context).load(avatarResId).into(imageView);
                } catch (Exception e) {
                    //use default avatar
                    Glide.with(context).load(user.getAvatar()).diskCacheStrategy(DiskCacheStrategy.ALL).
                            placeholder(R.drawable.ease_default_avatar).into(imageView);
                }
            } else {
                Glide.with(context).load(R.drawable.ease_default_avatar).into(imageView);
            }
        }

    }

    /**
     * set user's nickname
     */
    public static void setUserNick(EMMessage message, String username, TextView textView) {

        if (textView != null) {
            if (message != null) {
                Map<String, Object> ext = message.ext();
                if (ext != null) {
                    textView.setText(ext.get("truename") + ":  ");
                }

            }
        }
    }

}
