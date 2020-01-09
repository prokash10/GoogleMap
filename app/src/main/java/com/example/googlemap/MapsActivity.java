package com.example.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double latitude;
    private double longitude;
    private String marker;

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
        //LatLng dillibazar = new LatLng(27.7052354, 27.7052354);
        //mMap.addMarker(new MarkerOptions().position(dillibazar).title("Mero College"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(dillibazar));


      /*  List<LatitudeLongitude>latlngs=new ArrayList<>();
        latlngs.add(new LatitudeLongitude(27.7052354, 27.7052354,"Mero College" ));
        latlngs.add(new LatitudeLongitude(27.7039216, 85.3287974,"hamro College" ));
        latlngs.add(new LatitudeLongitude(27.705749, 85.329542,"tero College" ));
        latlngs.add(new LatitudeLongitude(27.7054079, 85.329686,"usko College" ));

        CameraUpdate center, Zoom;
        for (int i =0; i< latlngs.size(); i++){
            center=
                    CameraUpdateFactory.newLatLng(new LatLng(latlngs.get(i).getLat(),
            latlngs.get(i).getLon()));
            Zoom=CameraUpdateFactory.zoomTo(16);
            mMap.addMarker(new MarkerOptions().position(new LatLng(latlngs.get(i).getLat(),latlngs.get(i).getLon()))
                    .title(latlngs.get(i).getMarker()));

            mMap.moveCamera(center);
            mMap.animateCamera(Zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);

        }*/




    }
}
