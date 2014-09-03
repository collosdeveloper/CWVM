package com.module.wview.MSGView;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class Archive {

    /**
     * Get Zoom WebView
     */

//    static final int NONE = 0;
//    static final int DRAG = 1;
//    static final int ZOOM = 2;
//    int mode = NONE;
//
//    PointF start = new PointF();
//    PointF mid = new PointF();
//    float oldDist = 1f;
//    float scale = 0f;
//    float oldscale = 0f;
//    int displayHeight;
//
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        boolean consumed = super.onTouchEvent(ev);
//
//        if (isClickable())
//            switch (ev.getAction() & MotionEvent.ACTION_MASK) {
//
//                case MotionEvent.ACTION_DOWN:
//                    start.set(ev.getX(), ev.getY());
//                    mode = DRAG;
//                    break;
//                case MotionEvent.ACTION_UP:
//                case MotionEvent.ACTION_POINTER_UP:
//                    mode = NONE;
//                    break;
//                case MotionEvent.ACTION_POINTER_DOWN:
//                    oldDist = spacing(ev);
//                    if (oldDist > 5f) {
//                        midPoint(mid, ev);
//                        mode = ZOOM;
//                    }
//                    break;
//
//                case MotionEvent.ACTION_MOVE:
//                    if (mode == DRAG) {
//                    }
//                    else if (mode == ZOOM) {
//                        float newDist = spacing(ev);
//                        if (newDist > 5f) {
//                            scale = newDist / oldDist;
//                            if(scale>1){
//                                if(Math.abs(oldscale-scale)>0.3){
//                                    zoomIn();
//                                    oldscale = scale;
//                                }
//                            }
//
//                            Log.d(TAG, "scale = " + scale);
//                            Log.d(TAG, "getScale() 1 = " + getScale());
//
//                            if(scale<1){
//                                if((getContentHeight()*getScale()>displayHeight)){
//                                    zoomOut();
//                                    Log.d(TAG, "getScale() = " + getScale());
//                                }
//                            }
//                        }
//                    }
//
//                    break;
//            }
//
//        return consumed;
//    }
//
//    private float spacing(MotionEvent event) {
//        float x = event.getX(0) - event.getX(1);
//        float y = event.getY(0) - event.getY(1);
//        return FloatMath.sqrt(x * x + y * y);
//    }
//
//    private void midPoint(PointF point, MotionEvent event) {
//        float x = event.getX(0) + event.getX(1);
//        float y = event.getY(0) + event.getY(1);
//        point.set(x / 2, y / 2);
//    }

    /**
     * Get Display Param
     */

//    public static int WIDTH;
//    public static int HEIGHT;
//
//    public static void getScreenParam(Context context){
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        WIDTH = size.x;
//        HEIGHT = size.y;
//    }

}
