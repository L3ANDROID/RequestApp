package com.lmorocho.requestapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.lmorocho.requestapp.R;

public class RegisterActivity extends AppCompatActivity {

    private Spinner tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tipo = findViewById(R.id.tipo_solicitud);
        String[] tipos = {"Solicitud de Matrícula","Soicitud de Ingreso","Solicitud de Certificado","Solicitud de pasantilla","Otra Solicitud"};
        tipo.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipos));
    }
}
