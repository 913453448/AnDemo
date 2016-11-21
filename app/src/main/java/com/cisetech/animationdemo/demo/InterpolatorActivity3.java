package com.cisetech.animationdemo.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * author：yinqingy
 * date：2016-11-21 16:00
 * blog：http://blog.csdn.net/vv_bug
 * desc：Interpolator插值器
 */

public class InterpolatorActivity3 extends ListActivity {
    private static final String TITLE = "TITLE";
    private static final String CLASS = "CLASS";
    private List<Map<String,Object>> datas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
        setListAdapter(new SimpleAdapter(this,datas,android.R.layout.simple_list_item_1,
                new String[]{TITLE},new int[]{android.R.id.text1}));
    }
    private void initDatas() {
        addData("透明度(Alpha)+插值器测试", InterpolatorActivity3_alpha.class);
        addData("旋转(Rotate)+插值器测试", InterpolatorActivity3_rotate.class);
        addData("平移(Translate)+插值器测试", InterpolatorActivity3_translate.class);
        addData("缩放(Scale)+插值器测试", InterpolatorActivity3_scale.class);
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
