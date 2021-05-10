package com.example.mymapsnew;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng rumah = new LatLng(-1.273504,120.586270);
        LatLng mesjid= new LatLng(-1.2795417, 120.5833740);
        int tinggi = 70;
        int lebar = 70;
        BitmapDrawable bitmapstart = (BitmapDrawable)getResources().getDrawable(R.drawable.rumah);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.masjid);
        Bitmap s = bitmapstart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        mMap.addMarker(new MarkerOptions().position(rumah).title("Rumahku")
                .snippet("Ini adalah rumah saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(mesjid).title("Masjid")
                .snippet("Ini adalah Masjid")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumah));
        mMap.addPolyline(new PolylineOptions().add(
                rumah,
                new LatLng(-1.273504,120.586270),
                new LatLng(-1.273338, 120.585954),
                new LatLng(-1.277576,120.583123),
                new LatLng(-1.278403, 120.582586),
                new LatLng(-1.279191, 120.583822),
                new LatLng(-1.279623, 120.583551),
                new LatLng(-1.2795417, 120.5833740),
                mesjid
                ).width(10)
                        .color(Color.RED)

        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rumah, 17.5f));
    }
}