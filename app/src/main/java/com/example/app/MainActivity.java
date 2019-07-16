package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre, edad;
    Spinner género;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txtNombre);
        edad = findViewById(R.id.txtEdad);
        género = findViewById(R.id.SpinnerGénero);
        agregar = findViewById(R.id.btnAdd);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource( this,
                        R.array.arrayspinner ,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        género.setAdapter(adapter);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnAdd:
                        if (nombre.getText().toString().trim().length() == 0)
                            nombre.setError("Nombre requerido");
                        if (edad.getText().toString().trim().length() == 0)
                            edad.setError("Edad requerida");
                        Toast.makeText( MainActivity. this, nombre.getText().toString()+ "\n"+
                            edad.getText().toString()+"\n"+
                                género.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                        clean();
                        break;

                }
            }
        });
    }

 private void clean(){
        nombre.setText("");
        edad.setText("");
        género.setSelection(0);
 }


}