package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private AutoCompleteTextView etcity;
    private Button btnsearch;
    private List<LatitudeLongitude>latitudeLongitudes;
    Marker markerName;
    CameraUpdate center, zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        etcity=findViewById(R.id.etcity);
        btnsearch=findViewById(R.id.btnsearch);

        fillArrayListAndSetAdapter();
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etcity.getText().toString()))
                {
                    etcity.setError("Please Enter Place");
                    return;
                }

                int position = SearchArrayList(etcity.getText().toString());
                if (position>-1)
                    loadMap(position);
                else Toast.makeText(SearchActivity.this, "Location not found by name : "
                +etcity.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });




    }


    private void fillArrayListAndSetAdapter()
    {
        latitudeLongitudes=new ArrayList<>();
        latitudeLongitudes.add(new LatitudeLongitude(27.7052354, 27.7052354, "dillibazar"));
        latitudeLongitudes.add(new LatitudeLongitude(27.7039216, 85.3287974, "kalikasthan"));
        latitudeLongitudes.add(new LatitudeLongitude(27.705749, 85.329542, "ganewshor"));
        latitudeLongitudes.add(new LatitudeLongitude(27.7054079, 85.329686,"banewshor"));
        String[]data=new String[latitudeLongitudes.size()];

        for (int i=0; 1<data.length; i++){
            data[i]=latitudeLongitudes.get(i).getMarker();

        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                SearchActivity.this,android.R.layout.simple_list_item_1,
                data
        );
        etcity.setAdapter(adapter);
        etcity.setThreshold(1);

    }

    public int SearchArrayList(String name){
        for (int i=0; i<latitudeLongitudes.size();i++){
            if (latitudeLongitudes.get(i).getMarker().contains(name)){
                return 1;
            }
        }
        return -1;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        center= CameraUpdateFactory.newLatLng(new LatLng(27.7052354, 27.7052354));
        zoom=CameraUpdateFactory.zoomTo(16);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        mMap.getUiSettings().setZoomControlsEnabled(true);

    }
    public void loadMap(int position){
        if (markerName!=null)
        {
            markerName.remove();
        }
        double latitude=latitudeLongitudes.get(position).getLat();
        double longitude=latitudeLongitudes.get(position).getLat();
        String marker=latitudeLongitudes.get(position).getMarker();
        center=CameraUpdateFactory.newLatLng(new LatLng(latitude,longitude));
        zoom=CameraUpdateFactory.zoomTo(16);
        markerName=mMap.addMarker(new MarkerOptions().position(new LatLng(latitude,
                longitude)).title(marker));
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
}
