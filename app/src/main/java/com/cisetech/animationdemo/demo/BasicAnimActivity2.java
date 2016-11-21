package com.cisetech.animationdemo.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.cisetech.animationdemo.R;

/**
 * author：yinqingy
 * date：2016-11-20 20:29
 * blog：http://blog.csdn.net/vv_bug
 * desc：基础动画代码实现
 */

public class BasicAnimActivity2 extends AppCompatActivity {
    private TextView tv_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_anim);
        tv_anim = (TextView) findViewById(R.id.tv_anim);
    }

    /**
     * 透明度动画测试
     * <?xml version="1.0" encoding="utf-8"?>
     * <alpha xmlns:android="http://schemas.android.com/apk/res/android"
     * android:fromAlpha="0"
     * android:toAlpha="1"
     * android:duration="800"
     * android:repeatCount="-1"
     * android:repeatMode="reverse"
     * android:interpolator="@android:anim/accelerate_decelerate_interpolator"
     * />
     */
    public void alpha(View view) {
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(800);
        alpha.setRepeatCount(Animation.INFINITE);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setInterpolator(new AccelerateDecelerateInterpolator());
        tv_anim.startAnimation(alpha);
    }

    /**
     * 缩放动画
     * <?xml version="1.0" encoding="utf-8"?>
     * <scale xmlns:android="http://schemas.android.com/apk/res/android"
     * android:fromXScale="0"
     * android:toXScale="1.5"
     * android:fromYScale="1"
     * android:toYScale="1"
     * android:pivotX="50%"
     * android:pivotY="50%"
     * android:duration="1000"
     * android:fillAfter="true"
     * />
     */
    public void scale(View view) {
        ScaleAnimation scale = new ScaleAnimation(0, 1.5f, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(1000);
        scale.setFillAfter(true);
        tv_anim.startAnimation(scale);
    }

    /**
     * 旋转动画
     * <?xml version="1.0" encoding="utf-8"?>
     * <rotate xmlns:android="http://schemas.android.com/apk/res/android"
     * android:fromDegrees="40"
     * android:toDegrees="760"
     * android:fillAfter="true"
     * android:pivotY="50%"
     * android:pivotX="50%"
     * android:duration="2000"
     * android:repeatCount="-1"
     * android:repeatMode="restart"
     * android:interpolator="@android:anim/linear_interpolator"
     * />
     */
    public void rotate(View view) {
        RotateAnimation rotate = new RotateAnimation(40f, 760f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2000);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setRepeatMode(Animation.RESTART);
        rotate.setInterpolator(new LinearInterpolator());
        tv_anim.startAnimation(rotate);
    }

    /**
     * 平移动画
     * <?xml version="1.0" encoding="utf-8"?>
     * <translate xmlns:android="http://schemas.android.com/apk/res/android"
     * android:fromXDelta="0"
     * android:toXDelta="0"
     * android:fromYDelta="0"
     * android:toYDelta="50%p"
     * android:repeatCount="1"
     * android:repeatMode="reverse"
     * android:duration="1000"
     * />
     */
    public void translate(View view) {
        TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_SELF, 0);
        translate.setDuration(1000);
        translate.setRepeatCount(1);
        translate.setRepeatMode(Animation.REVERSE);
        tv_anim.startAnimation(translate);
    }

    /**
     * set动画集合
     * <?xml version="1.0" encoding="utf-8"?>
     * <set xmlns:android="http://schemas.android.com/apk/res/android"
     * android:interpolator="@android:anim/accelerate_decelerate_interpolator"
     * android:shareInterpolator="true"
     * >
     * <translate
     * android:fromXDelta="0"
     * android:toXDelta="0"
     * android:fromYDelta="-80%p"
     * android:toYDelta="0"
     * android:duration="3000"
     * />
     * <alpha
     * android:fromAlpha="0.5"
     * android:toAlpha="1"
     * android:duration="3000"
     * />
     * <rotate
     * android:fromDegrees="0"
     * android:toDegrees="3600"
     * android:duration="2000"
     * android:pivotY="50%"
     * android:pivotX="50%"
     * android:startOffset="3000"
     * />
     * </set>
     */
    public void set(View view) {
        AnimationSet set = new AnimationSet(true);
        set.setInterpolator(new AccelerateDecelerateInterpolator());

        TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_PARENT, -0.8f, Animation.RELATIVE_TO_SELF, 0);
        translate.setDuration(3000);

        AlphaAnimation alpha = new AlphaAnimation(0.5f, 1.0f);
        alpha.setDuration(3000);

        RotateAnimation rotate = new RotateAnimation(0, 3600, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2000);
        rotate.setStartOffset(3000);

        set.addAnimation(translate);
        set.addAnimation(alpha);
        set.addAnimation(rotate);
        tv_anim.startAnimation(set);
    }
}
