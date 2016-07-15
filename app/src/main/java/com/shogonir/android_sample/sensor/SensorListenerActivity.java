package com.shogonir.android_sample.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.shogonir.android_sample.R;

import java.util.List;

public class SensorListenerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;

    private TextView mBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_listener);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_LIGHT);
        if (sensors.size() > 0) {
            mSensorManager.registerListener(this, sensors.get(0), SensorManager.SENSOR_DELAY_UI);
        }

        mBrightness = (TextView)findViewById(R.id.sensor_listener_brightness);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_LIGHT :
                double brightness = sensorEvent.values[0];
                mBrightness.setText(String.valueOf(brightness));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
