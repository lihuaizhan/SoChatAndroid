package com.neishenmo.sochat.sochatandroid.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 小果冻
 * 打开相机获取相册
 * Created by Administrator on 2018\4\28 0028.
 */

public class ObtainAlbumUtils {

    public static int HEAD_SCREENSHOT = 66;

    /**
     * 获取相册
     */
    public static void openCamera(Activity context , String mPhotoPath) {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        mPhotoPath = getSDPath()+"/"+getPhotoFileName();
        File mPhotoFile = new File(mPhotoPath);
        if (mPhotoFile.exists()){
            try {
                mPhotoFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPhotoFile));
        context.startActivityForResult(intent,33);
    }


    public static String getSDPath(){
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);   //判断sd卡是否存在
        if   (sdCardExist)
        {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();

    }

    public static String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date)  +".jpg";
    }


    /**
     * 以时间戳命名将bitmap写入文件
     *  返回图片储存绝对看路径
     * @param bitmap
     */
    public static String writeFileByBitmap(Bitmap bitmap) {
        String uploadFilePath;
        String path = "/storage/emulated/0/wandoujia/downloader/icon/";//手机设置的存储位置
        File file = new File(path);
        String time = System.currentTimeMillis() + ".jpg";
        File imageFile = new File(file, time);
        uploadFilePath = path+time;
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            imageFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uploadFilePath;
    }

    /**
     * bitmap进入截图
     * @param data
     * @param context
     */
    public static void BitmapScreenshot(Intent data,Activity context){
        Intent intent = new Intent("com.android.camera.action.CROP");
        Bitmap bitmap = data.getParcelableExtra("data");
        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(),bitmap,null,null));
        intent.setDataAndType(uri,"image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 裁剪框大小
        intent.putExtra("aspectX", dpturnxpUtils.wide(context));
        intent.putExtra("aspectY", dpturnxpUtils.wide(context));
        // outputX outputY 保存图片大小
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        //输出JPG格式图片
        intent.putExtra("outputFormat",Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("return-data", true);
        context.startActivityForResult(intent, HEAD_SCREENSHOT);
    }

    /**
     *  照片绝对路径进入截图
     */
    public static void UriScreenshot(Activity context,Uri uri){
        Intent intent = new Intent("com.android.camera.action.CROP");
//        Uri uri = getUri(Path,context);
        intent.setDataAndType(uri,"image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 裁剪框大小
        intent.putExtra("aspectX", dpturnxpUtils.wide(context));
        intent.putExtra("aspectY", dpturnxpUtils.wide(context));
        // outputX outputY 保存图片大小
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        //输出JPG格式图片
        intent.putExtra("outputFormat",Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("return-data", true);
        context.startActivityForResult(intent, HEAD_SCREENSHOT);
    }

    /**
     * 把获取到图片的绝对路径转换为uri
     * @param path
     * @return
     */
    public static Uri getUri(String path,Activity context){
        Uri uri = null;
        if (path != null) {
            path = Uri.decode(path);
            ContentResolver cr = context.getContentResolver();
            StringBuffer buff = new StringBuffer();
            buff.append("(")
                    .append(MediaStore.Images.ImageColumns.DATA)
                    .append("=")
                    .append("'" + path + "'")
                    .append(")");
            Cursor cur = cr.query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    new String[] { MediaStore.Images.ImageColumns._ID },
                    buff.toString(), null, null);
            int index = 0;
            for (cur.moveToFirst(); !cur.isAfterLast(); cur
                    .moveToNext()) {
                index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID);
                index = cur.getInt(index);
            }
            if (index == 0) {
            } else {
                Uri uri_temp = Uri.parse("content://media/external/images/media/" + index);
                if (uri_temp != null) {
                    uri = uri_temp;
                }
            }
        }
        return uri;
    }


    /*
 * 将时间戳转换为时间
 */
    public static String stampToDate(long timeMillis){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timeMillis);
        return simpleDateFormat.format(date);
    }
}
