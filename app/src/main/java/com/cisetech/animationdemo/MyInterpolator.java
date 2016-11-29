package com.cisetech.animationdemo;

import android.view.animation.Interpolator;

/**
 * author：yinqingy
 * date：2016-11-28 21:35
 * blog：http://blog.csdn.net/vv_bug
 * desc：
 */

public class MyInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
