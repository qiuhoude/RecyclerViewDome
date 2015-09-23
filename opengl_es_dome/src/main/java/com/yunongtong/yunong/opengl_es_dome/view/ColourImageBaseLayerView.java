package com.yunongtong.yunong.opengl_es_dome.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * TODO: document your custom view class.
 */
public class ColourImageBaseLayerView extends View {

    private LayerDrawable mLayerDrawable;

    public ColourImageBaseLayerView(Context context) {
        this(context, null);
    }

    public ColourImageBaseLayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColourImageBaseLayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLayerDrawable = (LayerDrawable) getBackground();

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mLayerDrawable.getIntrinsicWidth(), mLayerDrawable.getIntrinsicHeight());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final float x = event.getX();
        final float y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //通过点找到是那种图片
            Drawable drawable = findDrawble(x, y);
            //设置颜色
            if(drawable !=null){
                drawable.setColorFilter(randomColor(), PorterDuff.Mode.SRC_IN);
                invalidate();
            }

        }

        return super.onTouchEvent(event);
    }

    private int randomColor(){
        Random random = new Random() ;
        int color = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        return  color;
    }

    private Drawable findDrawble(float x, float y) {

        //获取当前层叠图片的个数
        final int numberOfLayers =  mLayerDrawable.getNumberOfLayers();
        Drawable currentDrawable = null;
        Bitmap bitmap = null;
        for (int i = numberOfLayers - 1; i >= 0; i--) {
            currentDrawable = mLayerDrawable.getDrawable(i);
            bitmap = ((BitmapDrawable) currentDrawable).getBitmap();

            try {
                int pixel = bitmap.getPixel((int) x, (int) y);
                if (pixel == Color.TRANSPARENT) {
                    //如果像素是空白的
                    continue;
                }
            } catch (Exception e) {
                continue;
            }

            return currentDrawable;

        }

        return null;
    }

}
