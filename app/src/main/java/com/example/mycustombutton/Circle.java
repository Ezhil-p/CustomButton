package com.example.mycustombutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static android.graphics.Color.BLUE;

public class Circle extends View {
    Paint circlepaint;
    Paint labelpaint;
    Integer radius;
    String text;
    TypedArray array;
    int circlecolor;
    int labelcolor;
    private int width;
    private int height;

    public int getCirclecolor() {
        return circlecolor;
    }

    public void setCirclecolor(int circlecolor) {
        this.circlecolor = circlecolor;
    }

    public int getLabelcolor() {
        return labelcolor;
    }

    public void  setLabelcolor(int labelcolor) {
        this.labelcolor = labelcolor;
    }

    public Circle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public Circle(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width=this.getMeasuredWidth()/2;
        float height=this.getMeasuredHeight()/2;
        canvas.drawCircle(width,height,radius,circlepaint);
        canvas.drawText("this is a test",width,height,labelpaint);

    }

    private void init(Context context, AttributeSet attrs) {
        circlepaint=new Paint();
        array=context.getTheme().obtainStyledAttributes(attrs,R.styleable.Circle,0,0);
        circlepaint.setColor(array.getColor(R.styleable.Circle_circle_color,0));
        labelpaint=new Paint();
        labelpaint.setColor(array.getColor(R.styleable.Circle_label_color,0));
        text=array.getString(R.styleable.Circle_circle_lable);
        radius=array.getInteger(R.styleable.Circle_circle_radius,12);
        labelpaint.setTextAlign(Paint.Align.CENTER);
        labelpaint.setTextSize(50);
        circlecolor=circlepaint.getColor();
        labelcolor=labelpaint.getColor();
        array.recycle();

    }
    public void changeCircleSettings()
    {
        int temp=this.getCirclecolor();
        this.setCirclecolor(this.getLabelcolor());
        this.setLabelcolor(temp);
        labelpaint.setColor(this.getLabelcolor());
        circlepaint.setColor(this.getCirclecolor());
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("mytest",widthMeasureSpec+" "+heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
