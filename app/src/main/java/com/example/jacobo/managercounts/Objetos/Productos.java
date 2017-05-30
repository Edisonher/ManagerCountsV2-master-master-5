package com.example.jacobo.managercounts.Objetos;

/**
 * Created by admin on 22/05/2017.
 */

public class Productos {
    String nombre;
    String precio;

    public Productos() {
    }

    public Productos(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
