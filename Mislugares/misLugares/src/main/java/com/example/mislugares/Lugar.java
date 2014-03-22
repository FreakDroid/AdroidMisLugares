package com.example.mislugares;

/**
 * Created by Willy on 22/03/14.
 */
public class Lugar {

    private String nombre;
    private String direccion;
    private GeoPunto posicion;
    private String foto;

    private int telefono;
    private String url;
    private String comentario;
    private long fecha;
    private float valoracion;
    private TipoLugar tipo;

    public String getNombre()
    {
        return this.nombre;
    }
    public String getDireccion()
    {
        return this.direccion;
    }
    public TipoLugar getTipo()
    {
        return this.tipo;
    }
    public int getTelefono()
    {
        return this.telefono;
    }
    public String getUrl()
    {
        return this.url;
    }
    public String getComentario()
    {
        return this.comentario;
    }
    public Long getFecha()
    {
        return this.fecha;
    }
    public float getValoracion()
    {
        return this.valoracion;
    }
    public  void setValoracion(float valor)
    {
        this.valoracion = valor;
    }




    public Lugar(String nombre, String direccion, double longitud,
                 double latitud,TipoLugar tipo, int telefono, String url, String comentario,
                 int valoracion) {
        fecha = System.currentTimeMillis();
        posicion = new GeoPunto(longitud, latitud);
        this.tipo = tipo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.url = url;
        this.comentario = comentario;
        this.valoracion = valoracion;
    }
    public Lugar()
    {

    }
}
