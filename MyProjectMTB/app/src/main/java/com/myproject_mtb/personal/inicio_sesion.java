package com.myproject_mtb.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class inicio_sesion extends AppCompatActivity {

    Button btnVolverHome;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnVolverHome = findViewById(R.id.btn_volver_home);
        btnIngresar = findViewById(R.id.btn_ingresar);

        btnVolverHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverHomeDesdeInicioSesion();
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresarDashboard();
            }
        });

    }

    public void volverHomeDesdeInicioSesion(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void ingresarDashboard(){
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }



}