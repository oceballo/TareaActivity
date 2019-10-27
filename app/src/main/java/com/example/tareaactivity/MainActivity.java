package com.example.tareaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextEdad;
    RadioGroup radioGroup;
    RadioButton radioButtonMasculino;
    RadioButton radioButtonFemenino;
    Spinner spinnerEstadoCivil;
    EditText editTextFechaNac;
    EditText editTextCorreo;
    Button buttonNuevo;
    Button buttonEnviar;

    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity","onCreate");

        //buscar referencias de objetos en el activity
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextApellido = (EditText) findViewById(R.id.editTextApellido);
        editTextEdad = (EditText) findViewById(R.id.editTextEdad);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonMasculino = (RadioButton) findViewById(R.id.radioButtonMasculino);
        radioButtonFemenino = (RadioButton) findViewById(R.id.radioButtonFemenino);

        spinnerEstadoCivil = (Spinner) findViewById(R.id.spinnerEstadoCivil);
        spinnerEstadoCivil.setSelection(0);

        editTextFechaNac = (EditText) findViewById(R.id.editTextFechaNac);
        editTextFechaNac.setOnClickListener(this);

        editTextCorreo = (EditText) findViewById(R.id.editTextCorreo);

        buttonNuevo = (Button) findViewById(R.id.buttonNuevo);
        buttonNuevo.setOnClickListener(this);

        buttonEnviar = (Button) findViewById(R.id.buttonEnviar);
        buttonEnviar.setOnClickListener(this);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MainActivity","onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity","onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity","onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity","onStop");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editTextFechaNac:
                clickEditTextFechaNac();
                break;

            case R.id.buttonNuevo:
                clickButtonNuevo();
                break;

            case R.id.buttonEnviar:
                clickButtonEnviar();
                break;
        }
    }


    private void clickEditTextFechaNac() {
        int mYear;
        int mMonth;
        int mDay;

        if (editTextFechaNac.getText().toString().isEmpty()) {


            // calender class's instance and get current date , month and year from calender
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR); // current year
            mMonth = c.get(Calendar.MONTH); // current month
            // Toast.makeText(this, mMonth, Toast.LENGTH_SHORT).show();
            mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        } else {
            String strFecha = editTextFechaNac.getText().toString();
            String[] arrayFecha = strFecha.split("/");

            mDay = Integer.parseInt(arrayFecha[0]);
            mMonth = Integer.parseInt(arrayFecha[1]) - 1;
            mYear = Integer.parseInt(arrayFecha[2]);
        }
        // date picker dialog
        datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        editTextFechaNac.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        editTextCorreo.requestFocus();
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    private void clickButtonNuevo() {
        //quitar errores
        editTextNombre.setError(null);
        editTextApellido.setError(null);
        editTextEdad.setError(null);
        radioButtonMasculino.setError(null);
        ((TextView)spinnerEstadoCivil.getSelectedView()).setError(null);
        editTextFechaNac.setError(null);
        editTextCorreo.setError(null);

        //limpiar campos
        editTextNombre.setText("");
        editTextApellido.setText("");
        editTextEdad.setText("");
        radioGroup.check(-1);
        spinnerEstadoCivil.setSelection(0);
        editTextFechaNac.setText("");
        editTextCorreo.setText("");

        editTextNombre.requestFocus();

    }

    private void clickButtonEnviar() {
        //quitar errores
        editTextNombre.setError(null);
        editTextApellido.setError(null);
        editTextEdad.setError(null);
        radioButtonMasculino.setError(null);
        ((TextView)spinnerEstadoCivil.getSelectedView()).setError(null);
        editTextFechaNac.setError(null);
        editTextCorreo.setError(null);


        //validar campos
        if (editTextNombre.getText().toString().trim().isEmpty()) {
            editTextNombre.setError(getString(R.string.text_nombre_error));
            editTextNombre.requestFocus();

        } else if (editTextApellido.getText().toString().trim().isEmpty()) {
            editTextApellido.setError(getString(R.string.text_apellido_error));
            editTextApellido.requestFocus();

        } else if (editTextEdad.getText().toString().trim().isEmpty()) {
            editTextEdad.setError(getString(R.string.text_edad_error));
            editTextEdad.requestFocus();

        } else if (radioGroup.getCheckedRadioButtonId()==-1) {
            radioButtonMasculino.setError(getString(R.string.button_radio_sexo_error));
            radioGroup.requestFocus();

        } else if (spinnerEstadoCivil.getSelectedItem().toString().isEmpty()) {
            ((TextView)spinnerEstadoCivil.getSelectedView()).setError(getString(R.string.spinner_estado_civil_error));
            spinnerEstadoCivil.requestFocus();

        } else if (editTextFechaNac.getText().toString().trim().isEmpty()) {
            editTextFechaNac.setError(getString(R.string.text_fecha_nac_error));
            editTextFechaNac.requestFocus();

        } else if (editTextCorreo.getText().toString().trim().isEmpty()) {
            editTextCorreo.setError(getString(R.string.text_correo_error));
            editTextCorreo.requestFocus();

        } else if (!validarEmail(editTextCorreo.getText().toString().trim())) {
            editTextCorreo.setError(getString(R.string.text_correo_error_formato));
            editTextCorreo.requestFocus();

        } else {
            //Toast.makeText(this, "Formulario Completado", Toast.LENGTH_SHORT).show();
            String[] arrayDatos={
                    editTextNombre.getText().toString(),
                    editTextApellido.getText().toString(),
                    editTextEdad.getText().toString(),
                    ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString(),
                    spinnerEstadoCivil.getSelectedItem().toString(),
                    editTextFechaNac.getText().toString(),
                    editTextCorreo.getText().toString(),
            };
            Intent intent=new Intent(this,SecondActivity.class);
            intent.putExtra("array_datos",arrayDatos);
            startActivity(intent);

            //limpiar campos
            clickButtonNuevo();
        }
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}