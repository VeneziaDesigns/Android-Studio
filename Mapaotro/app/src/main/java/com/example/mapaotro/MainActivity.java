package com.example.mapaotro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
        LatLng lavaClimb = new LatLng(14.0051335, 121.0002801);
        CameraUpdate posicion = CameraUpdateFactory.newLatLngZoom(lavaClimb,15);

        mMap.animateCamera(posicion);
        mMap.addMarker(new MarkerOptions()
                .position(lavaClimb)
                .title("Marker in lavaClimb")
                .draggable(true));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(lavaClimb));
        // Add a marker in lavaClimb and move the camera





    }
}