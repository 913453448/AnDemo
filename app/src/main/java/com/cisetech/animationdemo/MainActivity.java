package com.cisetech.animationdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cisetech.animationdemo.demo.BasicAnimActivity1;
import com.cisetech.animationdemo.demo.BasicAnimXmlActivity1;

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
    }
    private void initDatas() {
        addData("基础动画xml文件实现（一）", BasicAnimXmlActivity1.class);
        addData("基础动画代码实现（一）", BasicAnimActivity1.class);
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
