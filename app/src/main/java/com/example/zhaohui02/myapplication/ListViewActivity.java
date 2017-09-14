package com.example.zhaohui02.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.*;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;

/**
 * Created by admin on 2017/9/13.
 */

public class ListViewActivity extends AppCompatActivity {
    private ListView listview;

    public static boolean isScroll = false;

    /**
     * 初始化图片加载器
     *
     * @param context
     */
    public static void initImageLoader(Context context) {
        @SuppressWarnings("deprecation")
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                // .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageLoader(this);


        listview = (ListView) findViewById(R.id.lv);
        ArrayList<ItemBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemBean item = new ItemBean();
            item.name = "https://img20.360buyimg.com/da/jfs/t7828/72/2654330378/98752/fc211738/59b20f46N6192d6a3.jpg";
            data.add(item);
        }
        for (int i = 0; i < 10; i++) {
            ItemBean item = new ItemBean();
            item.name = "http://kohoh1992.github.io/image/201409182001.png";
            data.add(item);
        }
        final MyAdapter adapter = new MyAdapter(data,this);
        listview.setAdapter(adapter);

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    isScroll = false;
                    adapter.notifyDataSetChanged();
                } else {
                    isScroll = true;
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }
}
