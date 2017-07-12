package com.auribises.gwaactivitydemo;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MyLocationActivity extends AppCompatActivity implements LocationListener {

    @InjectView(R.id.textViewLocation)
    TextView txtLoc;

    @InjectView(R.id.buttonFetch)
    Button btnFetch;


    /*void initViews(){
        txtLoc = (TextView)findViewById(R.id.textViewLocation);
        btnFetch = (Button)findViewById(R.id.buttonFetch);
    }*/


    LocationManager locationManager;
    NotificationManager notificationManager;

    ProgressDialog progressDialog;

    String strLoc = "";

    void showNotification(){

        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Location");
        builder.setContentText(strLoc);
        builder.setSmallIcon(R.drawable.music);
        builder.setDefaults(Notification.DEFAULT_ALL); // VIBRATE permission in manifest

        Intent intent = new Intent(MyLocationActivity.this,ActivityOne.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,333,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();

        notificationManager.notify(101,notification);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        //initViews();
        ButterKnife.inject(this);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MyLocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MyLocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MyLocationActivity.this,"Please Grant Permissions",Toast.LENGTH_LONG).show();
                }else {

                    if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10, 5, MyLocationActivity.this);
                        progressDialog.show();
                    }else{
                        Toast.makeText(MyLocationActivity.this,"Please Enable GPS",Toast.LENGTH_LONG).show();

                        // Buil-In Intent
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }


                }
            }
        });

        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");

    }

    @Override
    public void onLocationChanged(Location location) {

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        strLoc = "Location: "+latitude+" - "+longitude;

        showNotification();

        txtLoc.setText("Location is: "+latitude+" - "+longitude);

        try {
            // Reverse Geocoding : Fetch Address from Latitude and Longitude
            Geocoder geocoder = new Geocoder(this);
            List<Address> adrsList = geocoder.getFromLocation(latitude, longitude, 5);

            if(adrsList!=null && adrsList.size()>0){
                Address address = adrsList.get(0);
                StringBuffer buffer = new StringBuffer();

                for(int i=0;i<address.getMaxAddressLineIndex();i++){
                    buffer.append(address.getAddressLine(i)+"\n");
                }

                txtLoc.setText(buffer.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        progressDialog.dismiss();

        //location.getSpeed(); mps

        locationManager.removeUpdates(this);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
