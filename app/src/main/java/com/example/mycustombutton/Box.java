package com.example.mycustombutton;

import android.graphics.PointF;

public class Box {
    PointF origin;
    PointF current;
    Box(PointF point)
    {
        this.origin=point;
        this.current=point;
    }
    PointF getCurrent()
    {
        return this.current;
    }
    void setCurrent(PointF point)
    {
        this.current=point;
    }
        PointF getOrigin()
    {
        return this.origin;
    }

}
