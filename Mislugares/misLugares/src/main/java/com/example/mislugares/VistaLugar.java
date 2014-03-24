package com.example.mislugares;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Willy on 20/03/14.
 */
public class VistaLugar extends Activity {
    public long id;
    private Lugar lugar;

    @Override
    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.vista_lugar);
        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id", -1);
        lugar = Lugares.elemento((int) id);
        TextView nombre = (TextView) findViewById(R.id.nombre);
        nombre.setText(lugar.getNombre());
        ImageView logo_tipo = (ImageView) findViewById(R.id.logo_tipo);
        logo_tipo.setImageResource(lugar.getTipo().getRecurso());
        TextView tipo = (TextView) findViewById(R.id.tipo);
        tipo.setText(lugar.getTipo().getTexto());
        TextView direccion = (TextView) findViewById(R.id.direccion);
        direccion.setText(lugar.getDireccion());
        TextView telefono = (TextView) findViewById(R.id.telefono);
        telefono.setText(Integer.toString(lugar.getTelefono()));
        TextView url = (TextView) findViewById(R.id.url);
        url.setText(lugar.getUrl());
        TextView comentario = (TextView) findViewById(R.id.comentario);
        comentario.setText(lugar.getComentario());
        TextView fecha = (TextView) findViewById(R.id.fecha);
        fecha.setText(DateFormat.getDateInstance().format(
                new Date(lugar.getFecha())));
        TextView hora = (TextView) findViewById(R.id.hora);
        hora.setText(DateFormat.getTimeInstance().format(
                new Date(lugar.getFecha())));
        RatingBar valoracion = (RatingBar) findViewById(R.id.valoracion);
        valoracion.setRating(lugar.getValoracion());
        valoracion.setOnRatingBarChangeListener( new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float valor, boolean b) {

                lugar.setValoracion(valor);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.vista_lugar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch(menuItem.getItemId()) {
            case R.id.accion_compartir:
                return true;
            case R.id.accion_llegar:
                return true;
            case R.id.accion_editar:
                Intent i = new Intent(this, EdicionLugar.class);
                //i.putExtra("id", id);
                startActivity(i);
                return true;
            case R.id.accion_borrar:
                new AlertDialog.Builder(this).setMessage("¿Esta seguro que desea Borrarlo?")
                        .setTitle("Borrar Lugar")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Lugares.borrar((int) id);
                                finish();
                            }
                        })
                        .setNegativeButton("Cancelar",null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }

    }

}
