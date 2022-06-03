package com.example.realitymapper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap gMap;
    MapFragment mapFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mapFrag = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    GroundOverlayOptions Mark;

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        MarkerOptions mOptions1 = new MarkerOptions();
        MarkerOptions mOptions2 = new MarkerOptions();
        MarkerOptions mOptions3 = new MarkerOptions();
        MarkerOptions mOptions4 = new MarkerOptions();
        MarkerOptions mOptions5 = new MarkerOptions();
        MarkerOptions mOptions6 = new MarkerOptions();
        MarkerOptions mOptions7 = new MarkerOptions();
        MarkerOptions mOptions8 = new MarkerOptions();



        mOptions1.title("재림관");
        mOptions1.position(new LatLng(37.38042924,126.92755373));

        mOptions2.title("학술정보관");
        mOptions2.position(new LatLng(37.38059865,126.92668988));

        mOptions3.title("신유관(대학원)");
        mOptions3.position(new LatLng(37.3809557,126.92617866));

        mOptions4.title("기념관(신학,예술)");
        mOptions4.position(new LatLng(37.37914851,126.92768111));

        mOptions5.title("중생관(사회,과학)");
        mOptions5.position(new LatLng(37.37887416,126.92913049));

        mOptions6.title("영암관(인문,사범)");
        mOptions6.position(new LatLng(37.37901741,126.92968687));

        mOptions7.title("학생회관");
        mOptions7.position(new LatLng(37.37952387,126.92941348));

        mOptions8.title("성결관(공과대학)");
        mOptions8.position(new LatLng(37.37986914,126.928753));

        gMap = map;
        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.379829, 126.926990), 20));
        gMap.getUiSettings().setZoomControlsEnabled(true);   // + - 모양 줌 컨트롤
        gMap.addMarker(mOptions1);
        gMap.addMarker(mOptions2);
        gMap.addMarker(mOptions3);
        gMap.addMarker(mOptions4);
        gMap.addMarker(mOptions5);
        gMap.addMarker(mOptions6);
        gMap.addMarker(mOptions7);
        gMap.addMarker(mOptions8);
    }
}
