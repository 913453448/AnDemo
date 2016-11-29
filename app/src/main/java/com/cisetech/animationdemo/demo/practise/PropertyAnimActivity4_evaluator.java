package com.cisetech.animationdemo.demo.practise;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.cisetech.animationdemo.R;

/**
 * author：yinqingy
 * date：2016-11-29 22:39
 * blog：http://blog.csdn.net/vv_bug
 * desc：evaluator 程序取值器
 */

public class PropertyAnimActivity4_evaluator extends AppCompatActivity {
    private View bt_anim_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim_activity4_evaluator);
        bt_anim_view=findViewById(R.id.bt_anim_view);
    }

    /**
     * 开启动画
     */
    private ValueAnimator a;
    public void start(View view){
        a=ValueAnimator.ofObject(new TypeEvaluator<Integer>(){
            @Override
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return (int) (endValue-(endValue-startValue)*fraction);
            }
        },((ViewGroup)view.getParent()).getPaddingTop(),400);
        a.setDuration(2000);
        a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                bt_anim_view.setY((int) animation.getAnimatedValue());
            }
        });
        a.setInterpolator(new DecelerateInterpolator());
        a.start();
    }

    /**
     * 取消动画
     */
    public void cancle(View view){
        if(a!=null)a.cancel();
    }

    /**
     * argb evaluator
     */
    public void agb(final View view){
        ValueAnimator a=ValueAnimator.ofObject(new ArgbEvaluator(),0xffffff00,0xff0000ff);
        a.setDuration(2000);
        a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                bt_anim_view.setBackgroundColor((Integer) animation.getAnimatedValue());
                bt_anim_view.setY(((ViewGroup)view.getParent()).getPaddingTop()+(400-((ViewGroup)view.getParent()).getPaddingTop())*fraction);
            }
        });
        a.setRepeatMode(ValueAnimator.REVERSE);
        a.setRepeatCount(ValueAnimator.INFINITE);
        a.start();
    }

    /**
     * 自定义evaluator
     */
    public void customer(View view){
        ValueAnimator a=ValueAnimator.ofObject(new CharEvaluator(),'a','z');
        a.setDuration(10000);
        a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ((TextView)bt_anim_view).setText(String.valueOf((char) animation.getAnimatedValue()).toLowerCase());
            }
        });
        a.start();
    }
    class CharEvaluator implements TypeEvaluator<Character>{
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startChar=startValue;
            int endChar=endValue;
            return (char) (startChar+(endChar-startChar)*fraction);
        }
    }
}
