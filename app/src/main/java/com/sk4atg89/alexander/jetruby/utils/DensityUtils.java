package com.sk4atg89.alexander.jetruby.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DensityUtils {

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
