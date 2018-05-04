package com.neishenmo.sochat.sochatandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.utils.dpturnxpUtils;

import java.io.File;
import java.util.List;

/**
 * 相册列表的adapter
 * Created by Administrator on 2018\4\25 0025.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<String> albumList;

    private Context context;

    public OnItemClickListener mListener;

    public AlbumAdapter(List<String> albumList, Context context) {
        this.albumList = albumList;
        this.context = context;
    }

    public void setOnitemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }

    @Override
    public AlbumAdapter.AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AlbumViewHolder holder = new AlbumViewHolder(LayoutInflater.from(context).inflate(R.layout.item_photo,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final AlbumAdapter.AlbumViewHolder holder, final int position) {
        Log.d("TAG",albumList.get(position)+"相册url----------------");
//        GlideUtils.loadIntoUseFitWidth(context,albumList.get(position),R.mipmap.ic_launcher,holder.imageView);
        Glide.with(context).load(new File(albumList.get(position))).centerCrop().override(dpturnxpUtils.wide(context)/3,dpturnxpUtils.wide(context)/3).
                placeholder(R.drawable.icon_picture_load).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(holder.imageView,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        public AlbumViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_photo);
            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            params.height = dpturnxpUtils.wide(context)/3;
            imageView.setLayoutParams(params);
        }

        @Override
        public void onClick(View v) {

        }
    }

//    private void onItemClick(OnItemClickListener listener) {
//        this.mListener = listener;
//    }

}
