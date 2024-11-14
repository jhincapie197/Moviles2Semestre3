package com.example.library;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // Instanciar los objetos que tienen id en el archivo xml
    EditText idBook, name, author;
    Spinner editorial;
    Switch savailable;
    ImageButton bSave, bSearch, bEdit, bDelete, bList;
    TextView message;
    // Generar el array con las opciones del spinner (editorial)
    String[] arrayEditorial = {"Oveja Negra","Prentice Hall"};
    // Instanciar objeto de FirebaseFirestore para acceder a la base de datos Firestore
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    boolean mFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Referenciar los objetos con cada id respectivo del archivo xml
        message = findViewById(R.id.tvMessage);
        idBook = findViewById(R.id.etIdBook);
        name = findViewById(R.id.etName);
        author = findViewById(R.id.etAuthor);
        editorial = findViewById(R.id.spEditorial);
        savailable = findViewById(R.id.idswAvailable);
        bSave = findViewById(R.id.ibSave);
        bSearch = findViewById(R.id.ibSearch);
        bEdit = findViewById(R.id.ibEdit);
        bDelete = findViewById(R.id.ibDelete);
        bList = findViewById(R.id.ibList);
        // Poblar el spinner con Array y luego con el arrayAdapter
        ArrayAdapter<String> arrayadp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,arrayEditorial);
        editorial.setAdapter(arrayadp);
        // Eventos de cada botón
        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!idBook.getText().toString().isEmpty()){
                    // Buscar el libro a través del idbook
                    db.collection("book")
                            .whereEqualTo("idbook", idBook.getText().toString())
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()){
                                        if (!task.getResult().isEmpty()){
                                            for (QueryDocumentSnapshot document: task.getResult()){
                                                name.setText(document.getString("name"));
                                                author.setText(document.getString("author"));
                                                editorial.setSelection(document.getString("editorial").equals("Oveja Negra")? 0 : 1);
                                                savailable.setChecked(document.getDouble("available") == 1 ? true : false);
                                            }
                                        }
                                        else{
                                            message.setTextColor(Color.parseColor("#FF4545"));
                                            message.setText("El id del libro NO Existe. Inténtelo con otro");
                                        }
                                    }
                                }
                            });
                }
                else{
                    message.setTextColor(Color.parseColor("#FF4545"));
                    message.setText("Debe ingresar el id del libro a buscar...");
                }
            }
        });
        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mIdBook = idBook.getText().toString();
                String mName = name.getText().toString();
                String mAuthor = author.getText().toString();
                String mEditorial = editorial.getSelectedItem().toString();
                int mAvailable = savailable.isChecked() ? 1 : 0;
                if (checkDataBook(mIdBook,mName,mAuthor)) { // Estos datos están diligenciados
                    // Guardar el libro en la BDs de Firestore en la colección book
                    db.collection("book")
                            .whereEqualTo("idbook", mIdBook)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()){
                                        if (task.getResult().isEmpty()){
                                            // Crear objeto de la clase Map para agregar el documento en la coleccion
                                            Map<String, Object> mapBook = new HashMap<>();
                                            // asignar a cada key su valor respectivo
                                            mapBook.put("idbook", mIdBook);
                                            mapBook.put("name", mName);
                                            mapBook.put("author", mAuthor);
                                            mapBook.put("editorial", mEditorial);
                                            mapBook.put("available", mAvailable);
                                            // Guardar el documento
                                            db.collection("book")
                                                    .add(mapBook)
                                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                        @Override
                                                        public void onSuccess(DocumentReference documentReference) {
                                                            message.setTextColor(Color.parseColor("#31511E"));
                                                            message.setText("Libro agregado exitosamente...");
                                                        }
                                                    })
                                                    .addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            message.setTextColor(Color.parseColor("#FF4545"));
                                                            message.setText("No se agregó el libro...");
                                                        }
                                                    });
                                        }
                                        else{
                                            message.setTextColor(Color.parseColor("#FF4545"));
                                            message.setText("Id del libro EXISTENTE. Inténtelo con otro");
                                        }
                                    }
                                }
                            });
                }
                else{
                    message.setTextColor(Color.parseColor("#FF4545"));
                    message.setText("Debe ingresar todos los datos del libro");
                }
            }
        });

    }



    private boolean checkDataBook(String mIdBook, String mName, String mAuthor) {
        return !mIdBook.isEmpty() && !mName.isEmpty() && !mAuthor.isEmpty();
    }
}

