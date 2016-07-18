package com.shogonir.android_sample.gl_surface;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shogonir.android_sample.R;

public class GLSurfaceActivity extends AppCompatActivity {

    private GLSurfaceView mGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gl_surface);

        mGLView = new MyGLSurfaceView(this);
        setContentView(mGLView);
    }
}
