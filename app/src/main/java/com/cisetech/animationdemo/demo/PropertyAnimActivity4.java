package com.cisetech.animationdemo.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cisetech.animationdemo.demo.practise.PropertyAnimActivity4_evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * author：yinqingy
 * date：2016-11-29 21:12
 * blog：http://blog.csdn.net/vv_bug
 * desc：属性动画
 */

public class PropertyAnimActivity4 extends ListActivity {
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
        addData("补间动画跟属性动画对比", PropertyAnimActivity4_compare.class);
        addData("属性动画进阶之（Evaluator）", PropertyAnimActivity4_evaluator.class);
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
