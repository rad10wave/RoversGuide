package com.example.roversguide2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Geocoder;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback {
    Button uber;
    TextView stateHead,stateHead1;
    TextView stateContent;
    TextView cityContent;
    String title;
    private GoogleMap mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        stateContent = findViewById(R.id.stateContent);
        stateHead1 = findViewById(R.id.stateHead1);
        cityContent = findViewById(R.id.cityContent);
        Intent i = getIntent();
        title = i.getStringExtra("titleOfState");
        String content = i.getStringExtra("contentOfState");
        String head = i.getStringExtra("cityHead");
        String city = i.getStringExtra("cityContent");
        stateContent.setText(content);
        stateHead1.setText(head);
        cityContent.setText(city);
        uber=findViewById(R.id.btn1);


        getSupportActionBar().setTitle(title);


        //getSupportActionBar().setTitle(title);

        //Address add= i.getStringExtra("titleOfState");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapView = googleMap;
        List<Address> addressList = null;
        Geocoder geocoder = new Geocoder(this);
        try {
            addressList = geocoder.getFromLocationName(title, 1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Address address = addressList.get(0);
        LatLng sydney = new LatLng(address.getLatitude(), address.getLongitude());
        //mapView.addMarker(new MarkerOptions().position(sydney).title(title));
        mapView.animateCamera(CameraUpdateFactory.zoomTo(7));
        mapView.animateCamera(CameraUpdateFactory.newLatLng(sydney));
        Log.d("MapDebug","map is showing");
        MapStyleOptions mapStyleOptions=MapStyleOptions.loadRawResourceStyle(this,R.raw.designmap);
        googleMap.setMapStyle(mapStyleOptions);
    }

    public void openapp(View view){
        Intent launchuber= getPackageManager().getLaunchIntentForPackage("com.ubercab");
        if(launchuber!=null)
            startActivity(launchuber);
        else
            Toast.makeText(DetailsActivity.this,"Uber not available in devie",Toast.LENGTH_LONG).show();

    }

/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);



    }

    @Override
    protected void onStart() {

        super.onStart();
        mapView.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }*/
}
