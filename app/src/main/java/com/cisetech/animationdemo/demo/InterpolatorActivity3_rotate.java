package com.cisetech.animationdemo.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.cisetech.animationdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * author：yinqingy
 * date：2016-11-21 17:14
 * blog：http://blog.csdn.net/vv_bug
 * desc：旋转+插值器测试
 */

public class InterpolatorActivity3_rotate extends AppCompatActivity {
    private GridView mGridView;
    private TextView tv_anim;
    private TextView tv_desc;
    private List<Map<String, Object>> datas = new ArrayList<>();
    private RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rotateAnimation.setDuration(2000);
        setContentView(R.layout.activity_interpolator_activity3_alpha);
        mGridView = (GridView) findViewById(R.id.gv_type);
        tv_anim = (TextView) findViewById(R.id.tv_anim);
        tv_desc = (TextView) findViewById(R.id.tv_desc);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    tv_anim.setText(datas.get(position).get("TITLE").toString());
                    tv_desc.setText(datas.get(position).get("DESC").toString());
                    rotateAnimation.setInterpolator((Interpolator) ((Class) datas.get(position).get("CLASS")).newInstance());
                    tv_anim.startAnimation(rotateAnimation);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        initDatas();
    }

    private void initDatas() {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("TITLE", "AccelerateDecelerateInterpolator");
        map1.put("DESC", "在动画开始与介绍的地方速率改变比较慢，在中间的时候加速");
        map1.put("CLASS", AccelerateDecelerateInterpolator.class);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("TITLE", "AccelerateInterpolator");
        map2.put("DESC", "在动画开始的地方速率改变比较慢，然后开始加速");
        map2.put("CLASS", AccelerateInterpolator.class);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("TITLE", "AnticipateInterpolator ");
        map3.put("DESC", " 开始的时候向后然后向前甩 ");
        map3.put("CLASS", AnticipateInterpolator.class);

        Map<String, Object> map4 = new HashMap<>();
        map4.put("TITLE", "AnticipateOvershootInterpolator ");
        map4.put("DESC", "开始的时候向后然后向前甩一定值后返回最后的值 ");
        map4.put("CLASS", AnticipateOvershootInterpolator.class);

        Map<String, Object> map5 = new HashMap<>();
        map5.put("TITLE", "BounceInterpolator ");
        map5.put("DESC", "动画结束的时候弹起 ");
        map5.put("CLASS", BounceInterpolator.class);

        Map<String, Object> map6 = new HashMap<>();
        map6.put("TITLE", "CycleInterpolator  ");
        map6.put("DESC", "动画循环播放特定的次数，速率改变沿着正弦曲线  ");
        map6.put("CLASS", CycleInterpolator.class);

        Map<String, Object> map7 = new HashMap<>();
        map7.put("TITLE", "DecelerateInterpolator ");
        map7.put("DESC", "在动画开始的地方快然后慢");
        map7.put("CLASS", DecelerateInterpolator.class);

        Map<String, Object> map8 = new HashMap<>();
        map8.put("TITLE", "LinearInterpolator  ");
        map8.put("DESC", "以常量速率改变 ");
        map8.put("CLASS", LinearInterpolator.class);

        Map<String, Object> map9 = new HashMap<>();
        map9.put("TITLE", "OvershootInterpolator  ");
        map9.put("DESC", "向前甩一定值后再回到原来位置");
        map9.put("CLASS", OvershootInterpolator.class);
        datas.add(map1);
        datas.add(map2);
        datas.add(map3);
        datas.add(map4);
        datas.add(map5);
        datas.add(map6);
        datas.add(map7);
        datas.add(map8);
        datas.add(map9);
        mGridView.setAdapter(new SimpleAdapter(
                this, datas,
                android.R.layout.simple_list_item_2,
                new String[]{"TITLE"},
                new int[]{android.R.id.text1})
        );
    }
}
