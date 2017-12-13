package com.example.mamorky.prueba25.ui.AddEditLista;

import com.example.mamorky.prueba25.data.pojo.Contacto;

/**
 * Created by mamorky on 12/12/17.
 */

public interface AddEditPresenter {
    void editContacto(Contacto contacto, String tlf);
    void addContacto(String nombre,String tlf);
}
