package com.example.deber;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNombres, etApellidos, etFechaNacimiento, etEmpresa, etCorreo, etTelefono;
    private RadioGroup rgGenero;
    private Button btnEnviar, btnLimpiar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los controles
        etNombres = findViewById(R.id.Nombres);
        etApellidos = findViewById(R.id.Apellidos);
        etFechaNacimiento = findViewById(R.id.VFechaNacimiento);
        etEmpresa = findViewById(R.id.Empresa);
        etCorreo = findViewById(R.id.VCorreo);
        etTelefono = findViewById(R.id.VTelefono);
        rgGenero = findViewById(R.id.rgGenero);
        btnEnviar = findViewById(R.id.btnEnviar);




    }

    private boolean validarFormulario() {
        // Validar campos
        if (TextUtils.isEmpty(etNombres.getText()) || etNombres.getText().toString().length() > 500) {
            etNombres.setError("Ingrese un nombre válido (máx. 500 caracteres)");
            return false;
        }
        if (TextUtils.isEmpty(etApellidos.getText()) || etApellidos.getText().toString().length() > 500) {
            etApellidos.setError("Ingrese un apellido válido (máx. 500 caracteres)");
            return false;
        }
        if (TextUtils.isEmpty(etFechaNacimiento.getText())) {
            etFechaNacimiento.setError("Ingrese una fecha válida");
            return false;
        }
        if (TextUtils.isEmpty(etEmpresa.getText()) || etEmpresa.getText().toString().length() > 200) {
            etEmpresa.setError("Ingrese una ciudad válida (máx. 200 caracteres)");
            return false;
        }
        if (rgGenero.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Seleccione un género", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(etCorreo.getText()).matches()) {
            etCorreo.setError("Ingrese un correo electrónico válido");
            return false;
        }
        if (etTelefono.getText().toString().length() != 10 || !TextUtils.isDigitsOnly(etTelefono.getText())) {
            etTelefono.setError("Ingrese un número de teléfono válido de 10 dígitos");
            return false;
        }
        return true;
    }


}