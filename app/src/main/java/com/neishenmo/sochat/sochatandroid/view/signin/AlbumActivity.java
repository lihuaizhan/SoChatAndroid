package com.neishenmo.sochat.sochatandroid.view.signin;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.adapter.AlbumAdapter;
import com.neishenmo.sochat.sochatandroid.utils.ObtainAlbumUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 小果冻
 * 相册展示
 * Created by Administrator on 2018\4\25 0025.
 */

public class AlbumActivity extends Activity {


    private RecyclerView mRvPhoto;

    private List<String> mPhotoList;

    private AlbumAdapter adapter;

    private Uri cropImageUri;

    private Intent cropIntent;

    public static int HEAD_OK = 22;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        initView();
    }

    private void initView() {

        mRvPhoto = (RecyclerView) findViewById(R.id.rv_photo);
        mPhotoList = new ArrayList<>();
        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        while (cursor.moveToNext()){
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
            mPhotoList.add(path);
        }
        cursor.close();
        Log.d("TAG",mPhotoList.size()+"-------------------");
        adapter = new AlbumAdapter(mPhotoList,this);
        mRvPhoto.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mRvPhoto.setAdapter(adapter);
        adapter.setOnitemClickListener(new AlbumAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ObtainAlbumUtils.UriScreenshot(AlbumActivity.this,ObtainAlbumUtils.getUri(mPhotoList.get(position),AlbumActivity.this));
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ObtainAlbumUtils.HEAD_SCREENSHOT){
            if (data!=null){
                Intent intent = new Intent();
                Bitmap bitmap = data.getParcelableExtra("data");
                Bundle bundle = new Bundle();
                bundle.putParcelable("bitmap",bitmap);
                intent.putExtras(bundle);
                setResult(HEAD_OK , intent);
            }

        }
        finish();
    }

}
