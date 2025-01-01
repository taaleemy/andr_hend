package com.example.evstationfinder;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MainActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the osmdroid configuration
        Configuration.getInstance().setUserAgentValue(getPackageName());

        // Set up the map view
        mapView = findViewById(R.id.map);
        mapView.setMultiTouchControls(true);

        // Add markers for EV stations
        addMarker(new GeoPoint(24.7136, 46.6753), "EV Charging Station - Riyadh");
        addMarker(new GeoPoint(21.4858, 39.1925), "EV Charging Station - Jeddah");
        addMarker(new GeoPoint(26.3927, 49.9777), "EV Charging Station - Dammam");

        // Center the map on Riyadh
        mapView.getController().setZoom(5.0);
        mapView.getController().setCenter(new GeoPoint(24.7136, 46.6753));
    }

    private void addMarker(GeoPoint point, String title) {
        Marker marker = new Marker(mapView);
        marker.setPosition(point);
        marker.setTitle(title);
        mapView.getOverlays().add(marker);
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
}
