package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapFragment mapFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

//        //google map fragment
////        SupportMapFragement mapFragement = (SupportMapFragement) getSupportFragmentManager()
////                .findFragmentById(R.id.map);
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
////        mapFragement.getMapAsync(OnMapReadyCallback this);
//        //google map Fragment


    }

    public void onMapReady(GoogleMap googleMap){

        double startLatitude =6.767254 ;
        double startLongitude = 79.8189226;
        double endLatitude=6.9218387;
        double endLongitude=79.8562055;

        mMap= googleMap;
        LatLng moratuwa= new LatLng(startLatitude,startLongitude);
        mMap.addMarker(new MarkerOptions().position(moratuwa).title("Marker in Moratuwa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(moratuwa));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(startLatitude,startLongitude),15.0f));

        //calculate distance
        float[] results = new float[1];
        Location.distanceBetween(startLatitude,startLongitude,endLatitude,endLongitude,results);
        float distance = results[0];

        int kilometre = (int) (distance/1000);

        Toast.makeText(this, String.valueOf(kilometre)+" Km.", Toast.LENGTH_SHORT).show();

    }


    public void gotoHome(MenuItem item) {
        Intent intent = new Intent(MapActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void gotoCategory(MenuItem item) {
        Intent intent = new Intent(MapActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    public void gotoLocation(MenuItem item) {
        Intent intent = new Intent(MapActivity.this, MapActivity.class);
        startActivity(intent);
    }

    public void gotoAccount(MenuItem item) {
        Intent intent = new Intent(MapActivity.this, AccountActivity.class);
        startActivity(intent);
    }
}