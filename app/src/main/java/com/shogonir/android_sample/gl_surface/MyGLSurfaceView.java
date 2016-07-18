package com.shogonir.android_sample.gl_surface;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by shogo on 2016/07/19.
 */
class MyGLSurfaceView extends GLSurfaceView {

    private final GLSurfaceRenderer mRenderer;

    public MyGLSurfaceView(Context context){
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        //setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        mRenderer = new GLSurfaceRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
    }
}
