package com.example.mamorky.prueba25.ui.Lista;

import com.example.mamorky.prueba25.data.pojo.Contacto;

/**
 * Created by mamorky on 12/12/17.
 */

public interface ListaInteractor {
    void searchPersonas(ListaInteractorImp.onLoadSucess onLoadSucess);
    void deleteContacto(Contacto contacto, ListaInteractorImp.onDeleteSucess onDeleteSucess);
}
