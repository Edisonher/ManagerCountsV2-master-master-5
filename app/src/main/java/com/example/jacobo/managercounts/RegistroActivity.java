package com.example.jacobo.managercounts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jacobo.managercounts.Objetos.Clientes;
import com.example.jacobo.managercounts.Objetos.FirebaseReferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegistroActivity extends AppCompatActivity {

    EditText eNombre,eApellido,eTelefono,eDireccion,eBarrio,eCedula, eRClave1, eRClave2, eRCorreo;
    Button bRegistrarse, bCancelar;

    String cedula,nombre,apellido,direccion,barrio, correo, telefono;

    Clientes cliente;
    DatabaseReference myRef;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        bRegistrarse = (Button) findViewById(R.id.bRegistrarse);
        bCancelar = (Button) findViewById(R.id.bCancelar);
        eNombre = (EditText) findViewById(R.id.eRNombres);
        eApellido = (EditText) findViewById(R.id.eRApellidos);
        eTelefono = (EditText) findViewById(R.id.eRTelefono);
        eDireccion = (EditText) findViewById(R.id.eRDireccion);
        eBarrio = (EditText) findViewById(R.id.eRBarrio);
        eCedula = (EditText) findViewById(R.id.eRCedula);






    }

    public void click(View v) {
        Intent i = new Intent();
        switch (v.getId()) {

            case R.id.bRegistrarse:
                cedula = eCedula.getText().toString();
                nombre = eNombre.getText().toString();
                apellido = eApellido.getText().toString();
                telefono = eTelefono.getText().toString();
                direccion = eDireccion.getText().toString();
                barrio = eBarrio.getText().toString();

                Clientes cliente = new Clientes(cedula,nombre,apellido,telefono,direccion,barrio,"","");
                //Clientes cliente = new Clientes(apellido,barrio,cedula,"",direccion,"",nombre,telefono);
                myRef = database.getReference("clientes").child(cedula);
                myRef.setValue(cliente);


                //setResult(RESULT_OK, i);

                //Intent intent = new Intent(this, DrawerVendActivity.class);
                //startActivity(intent);
                //finish();
                //finish();
                break;
            case R.id.bCancelar:
                setResult(RESULT_CANCELED, i);
                finish();
                break;
        }
    }
}
