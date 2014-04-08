package com.example.mislugares;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Willy on 22/03/14.
 */
public class EdicionLugar extends Activity {
    private EditText nombre;
    private Spinner tipo;
    private EditText direccion;
    private EditText telefono;
    private EditText url;
    private EditText comentario;
    private Lugar lugar;
    public long id;

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch(menuItem.getItemId()) {
            case R.id.accion_guardar:
                lugar.setNombre(nombre.getText().toString());
                lugar.setTipo(TipoLugar.values()[tipo.getSelectedItemPosition()]);
                lugar.setDireccion(direccion.getText().toString());
                lugar.setTelefono(Integer.parseInt(telefono.getText().toString()));
                lugar.setUrl(url.getText().toString());
                lugar.setComentario(comentario.getText().toString());
                finish();
                return true;
            case R.id.accion_cancelar:
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }

    }

    public boolean onCreateMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.edicion_lugar, menu);
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.edicion_lugar);
        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id");
        lugar = Lugares.elemento((int) id);
        EditText nombre = (EditText) findViewById(R.id.editText);
        nombre.setText(lugar.getNombre());

        Spinner tipo = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, TipoLugar.getNombres());
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adaptador);
        tipo.setSelection(lugar.getTipo().ordinal());


        EditText direccion = (EditText) findViewById(R.id.editText2);
        direccion.setText(lugar.getDireccion());

        EditText telefono = (EditText) findViewById(R.id.editText3);
        telefono.setText(Integer.toString(lugar.getTelefono()));

        EditText url = (EditText) findViewById(R.id.editText4);
        url.setText(lugar.getUrl());

        EditText comentario = (EditText) findViewById(R.id.editText5);
        comentario.setText(lugar.getComentario());

    }
}
