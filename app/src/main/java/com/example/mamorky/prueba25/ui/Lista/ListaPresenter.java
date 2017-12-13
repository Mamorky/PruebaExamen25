package com.example.mamorky.prueba25.ui.Lista;

import com.example.mamorky.prueba25.adapter.AdapterContacto;
import com.example.mamorky.prueba25.data.pojo.Contacto;

import java.util.Comparator;

/**
 * Created by mamorky on 12/12/17.
 */

public interface ListaPresenter {
    void loadContactos();
    void orderContactos(Comparator<Contacto> comparator, AdapterContacto adapterContacto);
    void deleteContacto(Contacto contacto);
}
