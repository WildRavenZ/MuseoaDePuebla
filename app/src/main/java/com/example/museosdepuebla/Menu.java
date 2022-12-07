package com.example.museosdepuebla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    Button btnMuseos, btnBuscar, btnCreditos, btnAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnMuseos = findViewById(R.id.btnMuseos);
        btnMuseos.setOnClickListener(this);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(this);
        btnCreditos = findViewById(R.id.btnCreditos);
        btnCreditos.setOnClickListener(this);
        btnAleatorio = findViewById(R.id.btnAleatorio);
        btnAleatorio.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnMuseos) {
            Intent intent = new Intent();
            intent.setClassName("com.example.museosdepuebla", "com.example.museosdepuebla.Museos");
            startActivity(intent);
        }

        if (view.getId() == R.id.btnBuscar) {
            Intent intent = new Intent();
            intent.setClassName("com.example.museosdepuebla", "com.example.museosdepuebla.Buscar");
            startActivity(intent);
        }

        if (view.getId() == R.id.btnCreditos) {
            Intent intent = new Intent();
            intent.setClassName("com.example.museosdepuebla", "com.example.museosdepuebla.Creditos");
            startActivity(intent);
        }
        if (view.getId() == R.id.btnAleatorio) {
            String latitudesC[] = {"19.0918046", "19.0416757", "19.0577691", "19.0941801", "19.0938331", "19.0417815", "19.0446219", "19.0441273", "19.0188014", "19.0399323", "19.0589208", "19.0459608", "19.050184", "19.0438441", "19.0548205", "19.0442108", "19.0548356", "19.0409316", "19.0525465", "19.0570455"};
            String longitudesC[] = {"-98.2341392", "-98.1991955", "-98.1837606", "-98.2368737", "-98.2366378", "-98.1984116", "-98.2028336", "-98.1949906", "-98.2484779", "-98.2057946", "-98.3025643", "-98.1973868", "-98.1997119", "-98.1954756", "-98.2046826", "-98.1974173", "-98.1826372", "-98.200634", "-98.182066", "-98.1837997"};
            Random rand = new Random();
            int museoaleatorio = rand.nextInt(20);
            Uri uri = Uri.parse("geo:" + latitudesC[museoaleatorio] + "," + longitudesC[museoaleatorio]);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }

    }

}