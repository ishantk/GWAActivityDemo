package com.auribises.gwaactivitydemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MySensorActivity extends AppCompatActivity implements SensorEventListener {

    @InjectView(R.id.textViewSesnor)
    TextView txtSensodData;

    @InjectView(R.id.buttonActivate)
    Button btnActivate;

    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sensor);
        ButterKnife.inject(this);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        btnActivate.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sensorManager.registerListener(MySensorActivity.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

                    Intent intent = new Intent("a.b.c.d");
                    sendBroadcast(intent);
                }
            }

        );
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;

        float proximity = values[0];

        if (proximity == 0) {

            String phone = "+91 99155 71177";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phone));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Please Grant Permissions",Toast.LENGTH_LONG).show();
            }else {
                startActivity(intent);
                sensorManager.unregisterListener(this);
            }
        }else{
            txtSensodData.setText("Proximity Value: "+proximity);
        }

        /*float x = values[0];
        float y = values[1];
        float z = values[2];

        float cal = ((x*x)+(y*y)+(z*z)) / (SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);

        if(cal>3){
            txtSensodData.setText("Shake Detected");


            String phone = "+91 99155 71177";
            String msg = "Device Shake Done !!";

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone,null,msg,null,null);

            sensorManager.unregisterListener(this);

        }else{
            txtSensodData.setText(x+" - "+y+" - "+z);
        }*/


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        sensorManager.unregisterListener(this);
    }
}
