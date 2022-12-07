package com.example.museosdepuebla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.lang.Math;

import java.util.List;

public class Buscar extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private List<String> enableProviders;
    private Double latitud, longitud;
    private String latitudC, longitudC;
    private Button btnBuscarcercano;
    private Double latitudes[] = {19.0918046, 19.0416757, 19.0577691, 19.0941801, 19.0938331, 19.0417815, 19.0446219, 19.0441273, 19.0188014, 19.0399323, 19.0589208, 19.0459608, 19.050184, 19.0438441, 19.0548205, 19.0442108, 19.0548356, 19.0409316, 19.0525465, 19.0570455};
    private Double longitudes[] = {-98.2341392, -98.1991955, -98.1837606, -98.2368737, -98.2366378, -98.1984116, -98.2028336, -98.1949906, -98.2484779, -98.2057946, -98.3025643, -98.1973868, -98.1997119, -98.1954756, -98.2046826, -98.1974173, -98.1826372, -98.200634, -98.182066, -98.1837997};
    private int lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        btnBuscarcercano = findViewById(R.id.btnBuscarcercano);
        btnBuscarcercano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Double cercanos[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                Double diferencialatitudes[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                Double diferencialongitudes[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                for (int i = 0; i < 20; i++) {
                    if (latitud < latitudes[i]) {
                        diferencialatitudes[i] = latitudes[i] - latitud;
                    }
                    else {
                        diferencialatitudes[i] = latitud - latitudes[i];
                    }
                    if (longitud < longitudes[i]) {
                        diferencialongitudes[i] = (-longitudes[i]) - longitud;
                    }
                    else {
                        diferencialongitudes[i] = longitud - (-longitudes[i]);
                    }
                    cercanos[i] = diferencialatitudes[i] + diferencialongitudes[i];
                }
                Double val = 100.0;
                for (int i = 0; i < 20; i++) {
                    if(cercanos[i] < val) {
                        val = cercanos[i];
                        lugar = i;
                    }
                }
                latitudC = String.valueOf(latitudes[lugar]);
                longitudC = String.valueOf(longitudes[lugar]);
                Uri uri = Uri.parse("geo:" + latitudC + "," + longitudC);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            locationManager.removeUpdates(this);
        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        StringBuffer stringBuffer = new StringBuffer();
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        enableProviders = locationManager.getProviders(criteria, true);
        if (enableProviders == null) {

        }
        else {
            for (String enableProvider : enableProviders) {
                stringBuffer.append(enableProvider).append(" ");
                try {
                    locationManager.requestSingleUpdate(enableProvider, this, null);
                } catch(SecurityException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        latitud = location.getLatitude();
        longitud = location.getLongitude();
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }

}