package com.example.mislugares;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

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
    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.edicion_lugar);
       /* Bundle extras = getIntent().getExtras();
        id = extras.getLong("id", -1);
        lugar = Lugares.elemento((int) id);
        EditText nombre = (EditText) findViewById(R.id.nombre);
        nombre.setText(lugar.getNombre());


        Spinner tipo = (Spinner) findViewById(R.id.tipo);
        //tipo.setText(lugar.getTipo().getTexto());

        EditText direccion = (EditText) findViewById(R.id.direccion);
        direccion.setText(lugar.getDireccion());

        EditText telefono = (EditText) findViewById(R.id.telefono);
        telefono.setText(Integer.toString(lugar.getTelefono()));

        EditText url = (EditText) findViewById(R.id.url);
        url.setText(lugar.getUrl());

        EditText comentario = (EditText) findViewById(R.id.comentario);
        comentario.setText(lugar.getComentario());
*/
    }
}
