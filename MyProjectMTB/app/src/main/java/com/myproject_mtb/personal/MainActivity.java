package com.myproject_mtb.personal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_inicio;

    //Video youtube
    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init video youtube
        init();

        btn_inicio = findViewById(R.id.btn_inicio);

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHome();
            }
        });
    }

    //Init video youtube
    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "Pedro", "Mexico", "Activo"));
        elements.add(new ListElement("#607d8b", "Juan", "Colombia", "Activo"));
        elements.add(new ListElement("#03a9f4", "Alejandra", "Mexico", "Activo"));
        elements.add(new ListElement("#775447", "Pedro", "Mexico", "Activo"));
        elements.add(new ListElement("#775447", "Pedro", "Mexico", "Activo"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

    public void irHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    };

}