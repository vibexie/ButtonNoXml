package com.vibexie.buttonnoxml.library;

import android.content.Context;

public class Util {
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}