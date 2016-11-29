package com.cisetech.animationdemo.demo;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.cisetech.animationdemo.R;

/**
 * author：yinqingy
 * date：2016-11-29 21:17
 * blog：http://blog.csdn.net/vv_bug
 * desc：属性动画跟补间动画比较
 */

public class PropertyAnimActivity4_compare extends AppCompatActivity {
    private final static String TAG=PropertyAnimActivity4_compare.class.getSimpleName();
    private View bt_anim_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim_activity4_compare);
        bt_anim_view=findViewById(R.id.bt_anim_view);
    }

    /**
     * 补间动画
     */
    private TranslateAnimation translateAni;
    public void tweenAnim(View view){
        translateAni=new TranslateAnimation(0,400,0,400);
        translateAni.setDuration(2000);
        translateAni.setRepeatCount(1);
        translateAni.setRepeatMode(Animation.REVERSE);
        bt_anim_view.startAnimation(translateAni);
    }
    /**
     * 属性动画
     */
    private ValueAnimator a;
    public void propertyAnim(final View view){
        if(a==null){

            a=ValueAnimator.ofInt(40,400,40);
            a.setDuration(2000);
            a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int value= (int) animation.getAnimatedValue();
                    bt_anim_view.layout(value,value,value+bt_anim_view.getWidth(),value+bt_anim_view.getHeight());
                }
            });
            a.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.i(TAG, "onAnimationStart: ");
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.i(TAG, "onAnimationEnd: ");
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    Log.i(TAG, "onAnimationCancel: ");
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    Log.i(TAG, "onAnimationRepeat: ");
                }
            });
            a.addPauseListener(new Animator.AnimatorPauseListener() {
                @Override
                public void onAnimationPause(Animator animation) {
                    Log.i(TAG, "onAnimationPause: ");
                }

                @Override
                public void onAnimationResume(Animator animation) {
                    Log.i(TAG, "onAnimationResume: ");
                }
            });
            a.start();
        }else{
            a.resume();
        }
    }
    public void cancle(View view){
        if(a!=null)a.pause();
        if(translateAni!=null)translateAni.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(a!=null){
            a.removeAllUpdateListeners();
            a.removeAllListeners();
        }
    }
}
