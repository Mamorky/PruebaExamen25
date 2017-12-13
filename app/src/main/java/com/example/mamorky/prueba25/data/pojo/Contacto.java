package com.example.mamorky.prueba25.data.pojo;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by mamorky on 12/12/17.
 */

public class Contacto implements Serializable,Comparable<Contacto>{
    private int id;
    private String nombre;
    private String tlf;

    public static final String TAGCONTACTO = "tagcontacto";

    public Contacto(int id, String nombre, String tlf) {
        this.id = id;
        this.nombre = nombre;
        this.tlf = tlf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    @Override
    public int compareTo(@NonNull Contacto o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
