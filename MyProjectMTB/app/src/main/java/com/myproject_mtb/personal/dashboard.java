package com.myproject_mtb.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DashBoard extends AppCompatActivity {

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
        btnSalir = findViewById(R.id.btn_cerrar_sesion);
        imageBtnIrDatosUsuario = findViewById(R.id.btnIrBiciMontana);
        imageIrBiciNinos = findViewById(R.id.btnIrBiciNino);
        imageIrBiciRuta = findViewById(R.id.btnIrBiciClasica);
        imageIrBiciTaller = findViewById(R.id.btnIrBiciTaller);

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