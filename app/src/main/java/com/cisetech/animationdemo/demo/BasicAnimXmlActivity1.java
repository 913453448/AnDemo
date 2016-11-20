package com.cisetech.animationdemo.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.cisetech.animationdemo.R;
/**
 * author：yinqingy
 * date：2016-11-17 20:53
 * blog：http://blog.csdn.net/vv_bug
 * desc：基本动画一
 */

public class BasicAnimXmlActivity1 extends AppCompatActivity {
    private TextView tv_anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_anim1);
        tv_anim= (TextView) findViewById(R.id.tv_anim);
    }
    /**
     * 缩放测试
     */
    public void scale(View view){
        ScaleAnimation scale1= (ScaleAnimation) AnimationUtils.loadAnimation(this,R.anim.anim_scale1);
        tv_anim.startAnimation(scale1);
    }

    /**
     * 透明度动画测试
     */
    public void alpha(View view){
        AlphaAnimation alpha= (AlphaAnimation) AnimationUtils.loadAnimation(this,R.anim.anim_alpha1);
        tv_anim.startAnimation(alpha);
    }

    /**
     * 旋转动画测试
     */
    public void rotate(View view){
        RotateAnimation rotate= (RotateAnimation) AnimationUtils.loadAnimation(this,R.anim.anim_rotate);
        tv_anim.startAnimation(rotate);
    }
    /**
     * 平移动画测试
     */
    public void translate(View view){
        TranslateAnimation translate= (TranslateAnimation) AnimationUtils.loadAnimation(this,R.anim.anim_translate1);
        tv_anim.startAnimation(translate);
    }
    /**
     * set动画测试
     */
    public void set(View view){
        AnimationSet set= (AnimationSet) AnimationUtils.loadAnimation(this,R.anim.anim_set1);
        tv_anim.startAnimation(set);
    }
}
