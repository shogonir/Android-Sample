package com.shogonir.android_sample.gl_surface;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 * Created by shogo on 2016/07/19.
 */
class MyGLSurfaceView extends GLSurfaceView {

    private final GLSurfaceRenderer mRenderer;

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    public MyGLSurfaceView(Context context){
        super(context);
        setEGLContextClientVersion(2);
        mRenderer = new GLSurfaceRenderer();
        setRenderer(mRenderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - mPreviousX;
                float dy = y - mPreviousY;
                // reverse direction of rotation above the mid-line
                if (y > getHeight() / 2) {
                    dx = dx * -1 ;
                }
                // reverse direction of rotation to left of the mid-line
                if (x < getWidth() / 2) {
                    dy = dy * -1 ;
                }
                float angle = mRenderer.getAngle() + ((dx + dy) * TOUCH_SCALE_FACTOR);
                mRenderer.setAngle(angle);
                requestRender();
        }
        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
