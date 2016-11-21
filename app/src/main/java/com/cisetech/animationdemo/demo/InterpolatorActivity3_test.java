package com.cisetech.animationdemo.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.cisetech.animationdemo.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

import static com.cisetech.animationdemo.R.id.chart;

/**
 * author：yinqingy
 * date：2016-11-21 21:28
 * blog：http://blog.csdn.net/vv_bug
 * desc：数据展示页面
 */

public class InterpolatorActivity3_test extends AppCompatActivity {
    private GridView mGridView;
    private LineChartView mLineChartView;
    private List<Map<String, Object>> datas = new ArrayList<>();
    private TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator_activity3_test);
        mLineChartView = (LineChartView) findViewById(chart);
        tv_desc = (TextView) findViewById(R.id.tv_desc);
        mGridView = (GridView) findViewById(R.id.gv_type);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle(datas.get(position).get("TITLE").toString());
                tv_desc.setText(datas.get(position).get("DESC").toString());
                float value = 0.0f;
                List<PointValue> points = new ArrayList<PointValue>();
                for (int i = 0; i <= 10; i++) {
                    value += 0.1f;
                    try {
                        Object obj = null;
                        Class clazz = (Class) datas.get(position).get("CLASS");
                        if("CycleInterpolator".equals(clazz.getSimpleName())){
                            Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
                            for (Constructor con:declaredConstructors) {
                                if(con.getParameterTypes().length==1){
                                    obj=con.newInstance(3);
                                    break;
                                }
                            }
                        }else{
                            obj=clazz.newInstance();
                        }
                        for (Method m : obj.getClass().getDeclaredMethods()) {
                            String name=m.getName();
                            if("getInterpolation".equals(name)){
                                m.setAccessible(true);
                                Object result = m.invoke(obj, value);
                                points.add(new PointValue(value, (Float) result));
                            }
                        }
                    }  catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                initDatas1(points);
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

    private void initDatas1(List<PointValue> points) {
        Line line = new Line(points).setColor(Color.RED).setCubic(false);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(true);
        axisX.setName("输入值");
        data.setAxisXBottom(axisX);

        Axis axisY = new Axis();  //Y轴
        axisY.setHasTiltedLabels(true);
        axisY.setName("输出值");
        data.setAxisYLeft(axisY);

        //设置行为属性，支持缩放、滑动以及平移
        mLineChartView.setInteractive(true);
        mLineChartView.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);
        mLineChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        mLineChartView.setLineChartData(data);
        mLineChartView.setVisibility(View.VISIBLE);
    }
}
