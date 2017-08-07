package com.dfsx.bowen.zoomheadercoordinator.util;

import android.content.Context;
import android.content.res.Resources;

/**
 * 像素转换工具类.
 *
 */
public class PixelUtil {


    /**
     * dp转 px.
     *
     * @param value the value
     * @return the int
     */
    public static int dp2px(Context context, float value) {
        final float scale = context.getResources().getDisplayMetrics().densityDpi;
        return (int) (value * (scale / 160) + 0.5f);
    }
    public static int dp2px(float value,Context context) {
        return dp2px(context, value);
    }
    /**
     * px转dp.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int px2dp(Context context, float value) {
        final float scale = context.getResources().getDisplayMetrics().densityDpi;
        return (int) ((value * 160) / scale + 0.5f);
    }
    public static int px2dp(float value,Context context) {
        return px2dp(context, value);
    }
   /**
     * sp转px.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int sp2px(Context context, float value) {
        Resources r;
        if (context == null) {
            r = Resources.getSystem();
        } else {
            r = context.getResources();
        }
        float spvalue = value * r.getDisplayMetrics().scaledDensity;
        return (int) (spvalue + 0.5f);
    }
    public static int sp2px(float value, Context context) {
    	return sp2px(context, value);
    }

    /**
     * px转sp.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int px2sp(Context context, float value) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (value / scale + 0.5f);
    }
    public static int px2sp(float value, Context context) {
        return px2sp(context, value);
    }

}
