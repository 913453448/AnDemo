package com.cisetech.animationdemo.demo.practise;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cisetech.animationdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * author：yinqingy
 * date：2016-11-23 14:53
 * blog：http://blog.csdn.net/vv_bug
 * desc：基础动画练习
 */

public class BasicPractiseActivity1 extends ListActivity {
    private static final String TITLE = "TITLE";
    private static final String RESID = "RESID";
    private List<Map<String,Object>> datas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        getListView().setBackgroundColor(Color.DKGRAY);
        FrameLayout.LayoutParams lp= (FrameLayout.LayoutParams) getListView().getLayoutParams();
        lp.topMargin=10;
        lp.bottomMargin=10;
        lp.leftMargin=10;
        lp.rightMargin=10;
        initDatas();
        setListAdapter(new SimpleAdapter(this,datas,android.R.layout.simple_list_item_1,
                new String[]{TITLE},new int[]{android.R.id.text1}));
    }
    private void initDatas() {
        addData("alpha(从0.1到1透明度增加)", R.anim.pra_anim_alpha1);
        addData("alpha+rotate", R.anim.pra_anim_alpha_rotate);
        addData("alpha+scale", R.anim.pra_anim_alpha_scale);
        addData("alpha+scale 2", R.anim.pra_anim_alpha_scale2);
        addData("自定义动画1", R.anim.pra_anim_own_design);
        addData("slide left in", R.anim.pra_anim_slide_left);
        addData("slide right in", R.anim.pra_anim_slide_right);
        addData("slide right up", R.anim.pra_anim_slide_up);
        addData("slide right bottom", R.anim.pra_anim_slide_bottom);
        addData("Zoom enter", R.anim.pra_zoom_enter);
        addData("Zoom exit", R.anim.pra_zoom_exit);
        addData("shake test", R.anim.pra_anim_shake);
    }
    private void addData(String title,int resId){
        Map<String,Object>demo=new TreeMap<>();
        demo.put(TITLE,title);
        demo.put(RESID,resId);
        datas.add(demo);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ListView listView=getListView();
        Animation a= AnimationUtils.loadAnimation(this, (Integer) datas.get(position).get(RESID));
        if((Integer) datas.get(position).get(RESID)==R.anim.pra_anim_shake){
            Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.cancel();
            long [] pattern = {100,200};   // 停止 开启
            vibrator.vibrate(pattern,-1);
        }
        listView.startAnimation(a);
    }
}
