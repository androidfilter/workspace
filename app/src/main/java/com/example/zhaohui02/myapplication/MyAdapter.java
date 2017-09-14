package com.example.zhaohui02.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohui02 on 2017/9/13.
 */

public class MyAdapter extends BaseAdapter {
    private List<ItemBean> images = new ArrayList<>();
    private AppCompatActivity activity;

    private ImageLoader imageLoader = ImageLoader.getInstance();

    private boolean isDown;

    public MyAdapter(List<ItemBean> images, AppCompatActivity activity) {
        this.images = images;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int i) {
        return images.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(activity).inflate(R.layout.listview_item,null);
            holder.iv = view.findViewById(R.id.iv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if(!ListViewActivity.isScroll){
            displayImage(holder.iv, images.get(i).name, getSampleDisplayImageOptions(R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher),null);
        }else{

            holder.iv.setImageResource(R.mipmap.ic_launcher);
        }

        return view;
    }
    public class ViewHolder {
        public ImageView iv;
    }
    @SuppressWarnings("deprecation")
    protected DisplayImageOptions getSampleDisplayImageOptions(
            int stubImageRes, int emptyImageRes, int errorImageRes) {
        return new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .showStubImage(stubImageRes)
                .showImageForEmptyUri(emptyImageRes)
                .showImageOnFail(errorImageRes)
                .cacheInMemory(true)
                .cacheOnDisc(true).displayer(new FadeInBitmapDisplayer(0))
                .build();
    }




    public void displayImage(final ImageView imageView, String uri,
                             DisplayImageOptions options, ImageLoadingListener listener) {
        imageLoader.displayImage(uri, imageView, options, listener);
    }

    public void setIsDown(boolean isDown){
        this.isDown = isDown;
    }

}
