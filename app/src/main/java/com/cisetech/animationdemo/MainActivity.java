package com.cisetech.animationdemo;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cisetech.animationdemo.demo.BasicAnimActivity2;
import com.cisetech.animationdemo.demo.BasicAnimXmlActivity1;
import com.cisetech.animationdemo.demo.InterpolatorActivity3;
import com.cisetech.animationdemo.demo.practise.BasicPractiseActivity1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * author：yinqingy
 * date：2016-11-17 20:45
 * blog：http://blog.csdn.net/vv_bug
 * desc：animation practice
 */

public class MainActivity extends ListActivity {
    private static final String TITLE = "TITLE";
    private static final String CLASS = "CLASS";
    private List<Map<String,Object>>datas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
        setListAdapter(new SimpleAdapter(this,datas,android.R.layout.simple_list_item_1,
                new String[]{TITLE},new int[]{android.R.id.text1}));
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String name=intent.getStringExtra("data");
                Log.e("TAG", "onReceive: ----->"+name );
            }
        },new IntentFilter("com.yqy"),"com.cn.customview.permissions.MY_BROADCAST",null);


    }
    private void initDatas() {
        addData("基础动画xml文件实现（一）", BasicAnimXmlActivity1.class);
        addData("基础动画代码实现（二）", BasicAnimActivity2.class);
        addData("动画插值器Interpolator（三）", InterpolatorActivity3.class);
        addData("基础动画练习（四）", BasicPractiseActivity1.class);
    }
    private void addData(String title,Class clazz){
        Map<String,Object>demo=new TreeMap<>();
        demo.put(TITLE,title);
        demo.put(CLASS,clazz);
        datas.add(demo);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, (Class<?>) datas.get(position).get(CLASS)));
    }
}
