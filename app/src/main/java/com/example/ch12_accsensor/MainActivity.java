package com.example.ch12_accsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
                    implements SensorEventListener {

    SensorManager sm;
    Sensor sr;
    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        sr=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        txv=findViewById(R.id.txv);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        txv.setText(String.format("X軸: %1.2f, Y軸: %1.2f, Z軸: %1.2f",
                event.values[0],event.values[1],event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    protected void onResume(){
    super.onResume();
    sm.unregisterListener(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sm.unregisterListener(this);
    }
}
