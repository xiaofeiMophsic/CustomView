package com.example.paozi.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.icu.text.DisplayContext;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.example.paozi.customview.R;

/**
 * TODO: document your custom view class.
 */
public class CustomView extends View {

    private int defaultSize;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        defaultSize = a.getDimensionPixelSize(R.styleable.CustomView_default_size, 100);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int properSize = defaultSize;
        int width = getProperSize(properSize, widthMeasureSpec);
        int height = getProperSize(properSize, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int getProperSize(int defaultSize, int measureSpec){

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.AT_MOST:
                defaultSize = size / 3;
                break;
            case MeasureSpec.EXACTLY:
                defaultSize = size;
                break;
        }
        return defaultSize;
    }
}
