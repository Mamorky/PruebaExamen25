package com.example.mamorky.prueba25.ui.Lista;

import com.example.mamorky.prueba25.data.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by mamorky on 12/12/17.
 */

public interface ListaView {
    void showLista(ArrayList<Contacto> contactos);
    void onSetDeleteSuccess();
}
