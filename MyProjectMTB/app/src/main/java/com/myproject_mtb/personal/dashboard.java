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

public class dashboard extends AppCompatActivity {

    Button btnVolverHome;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnVolverHome = findViewById(R.id.btn_volver_home);

        btnVolverHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverHomeDesdeInicioSesion();
            }
        });
    }

    public void volverHomeDesdeInicioSesion(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}