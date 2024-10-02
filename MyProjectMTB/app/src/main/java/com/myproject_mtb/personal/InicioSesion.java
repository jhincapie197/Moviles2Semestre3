package com.myproject_mtb.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InicioSesion extends AppCompatActivity {

    Button btnIniciarSesion;
    Button btnVolverHome2;
    EditText inputCorreoInicio;
    EditText inputContrasenainicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        inputCorreoInicio = findViewById(R.id.input_inicio_sesion);
        inputContrasenainicio = findViewById(R.id.input_password_inicio_sesion);
        btnIniciarSesion = findViewById(R.id.btn_ingresar);
        btnVolverHome2 = findViewById(R.id.btn_volver_home2);

    }

    public void volverHomeDesdeInicioSesion(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void ingresarDashboard(){
        Intent intent = new Intent(this, DashBoard.class);
        startActivity(intent);
    }



}