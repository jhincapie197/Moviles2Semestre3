package com.myproject_mtb.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dashboard extends AppCompatActivity {

    //Button btnVolverHome;
    Button btnSalir;
    ImageButton imageBtnIrDatosUsuario;
    ImageButton imageIrBiciNinos;
    ImageButton imageIrBiciRuta;
    ImageButton imageIrBiciTaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //btnVolverHome = findViewById(R.id.btn_volver_home);
        btnSalir = findViewById(R.id.salir_sesion);
        imageBtnIrDatosUsuario = findViewById(R.id.imageView2);
        imageIrBiciNinos = findViewById(R.id.imageView3);
        imageIrBiciRuta = findViewById(R.id.imageView4);
        imageIrBiciTaller = findViewById(R.id.imageView5);

        /*btnVolverHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverHomeDesdeInicioSesion();
            }
        });*/

        imageBtnIrDatosUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irDatosUsuario();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CerrarSesion();
            }
        });




    }

    public void CerrarSesion(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void irDatosUsuario(){
        Intent intent = new Intent(this, UserData.class);
        startActivity(intent);
    }
}