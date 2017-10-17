package com.vibexie.buttonnoxml.library;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class ButtonNoXml {
    private final Context context;
    private final String unpressedColor;
    private final String pressedColor;
    private final int radius;
    private final boolean selectable;
    private final boolean semicircle;
    private final int strokeWidth;
    private final String strokeColor;

    private ButtonNoXml(Builder builder) {
        context = builder.context;
        unpressedColor = builder.unpressedColor;
        pressedColor = builder.pressedColor;
        selectable = builder.selectable;

        semicircle = builder.semicircle;
        if (semicircle) {
            radius = 1000;
        } else {
            radius = builder.radius;
        }

        strokeWidth = builder.strokeWidth;
        strokeColor = builder.strokeColor;
    }

    public static class Builder {
        private Context context;
        private String unpressedColor = "#ffffff";
        private String pressedColor = "#ffffff";
        private int radius;
        private boolean selectable;
        private boolean semicircle;
        private int strokeWidth;
        private String strokeColor;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder unpressedColor(String color) {
            this.unpressedColor = color;
            return this;
        }

        public Builder pressedColor(String color) {
            this.pressedColor = color;
            return this;
        }

        public Builder radius(int radius) {
            this.radius = radius;
            return this;
        }

        public Builder selectable(boolean selectable) {
            this.selectable = selectable;
            return this;
        }

        public Builder semicircle(boolean semicircle) {
            this.semicircle = semicircle;
            return this;
        }

        public Builder strokeWidth(int strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        public Builder strokeColor(String strokeColor) {
            this.strokeColor = strokeColor;
            return this;
        }

        public Drawable build() {
            return new ButtonNoXml(this).getDrawable();
        }
    }

    public Drawable getDrawable() {
        GradientDrawable unpressed = new GradientDrawable();
        unpressed.setColor(Color.parseColor(unpressedColor));
        unpressed.setCornerRadius(Util.dip2px(context, radius));

        if (strokeWidth > 0) {
            unpressed.setStroke(Util.dip2px(context, strokeWidth), Color.parseColor(strokeColor));
        }

        GradientDrawable pressed = new GradientDrawable();
        pressed.setColor(Color.parseColor(pressedColor));
        pressed.setCornerRadius(Util.dip2px(context, radius));

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, selectable ? android.R.attr.state_selected : 0}, pressed.mutate());
        stateListDrawable.addState(new int[]{-android.R.attr.state_pressed, selectable ? -android.R.attr.state_selected : 0}, unpressed.mutate());
        return stateListDrawable;
    }
}