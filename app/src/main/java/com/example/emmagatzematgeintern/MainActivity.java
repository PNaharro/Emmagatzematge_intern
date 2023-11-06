package com.example.emmagatzematgeintern;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText nombreEditText, cognomsEditText, telefonEditText, emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreEditText = findViewById(R.id.nom);
        cognomsEditText = findViewById(R.id.cognoms);
        telefonEditText = findViewById(R.id.telefon);
        emailEditText = findViewById(R.id.mail);

        Button guardarButton = findViewById(R.id.Guardar);
        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarContacto();
            }
        });
    }

    private void guardarContacto() {
        String nombre = nombreEditText.getText().toString();
        String cognoms = cognomsEditText.getText().toString();
        String telefon = telefonEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String contacto = nombre + ";" + cognoms + ";" + telefon + ";" + email + "\n";
        nombreEditText.setText("");
        cognomsEditText.setText("");
        telefonEditText.setText("");
        emailEditText.setText("");
        try {
            FileOutputStream fileOutputStream = openFileOutput("contactos.txt", Context.MODE_APPEND);
            fileOutputStream.write(contacto.getBytes());
            fileOutputStream.close();
            Toast.makeText(this, "Contacto guardado con éxito", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar el contacto", Toast.LENGTH_SHORT).show();
        }
    }
}
