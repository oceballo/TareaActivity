package com.example.tareaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //declarar objetos
    TextView editTextNombre2;
    TextView editTextApellido2;
    TextView editTextEdad2;
    TextView editTextSexo2;
    TextView editTextEstadoCivil2;
    TextView editTextFechaNac2;
    TextView editTextCorreo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //recuperar datos del intent
        Intent intent=getIntent();
        String[] arrayDatos=intent.getStringArrayExtra("array_datos");

        //capturar objetos
        editTextNombre2=(TextView)findViewById(R.id.editTextNombre2);
        editTextApellido2=(TextView)findViewById(R.id.editTextApellido2);
        editTextEdad2=(TextView)findViewById(R.id.editTextEdad2);
        editTextSexo2=(TextView)findViewById(R.id.editTextSexo2);
        editTextEstadoCivil2=(TextView)findViewById(R.id.editTextEstadoCivil2);
        editTextFechaNac2=(TextView)findViewById(R.id.editTextFechaNac2);
        editTextCorreo2=(TextView)findViewById(R.id.editTextCorreo2);

        //mostrar datos en textview
        editTextNombre2.setText(arrayDatos[0]);
        editTextApellido2.setText(arrayDatos[1]);
        editTextEdad2.setText(arrayDatos[2]);
        editTextSexo2.setText(arrayDatos[3]);
        editTextEstadoCivil2.setText(arrayDatos[4]);
        editTextFechaNac2.setText(arrayDatos[5]);
        editTextCorreo2.setText(arrayDatos[6]);

    }
}
