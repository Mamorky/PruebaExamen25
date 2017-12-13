package com.example.mamorky.prueba25.ui.AddEditLista;

import com.example.mamorky.prueba25.data.pojo.Contacto;

/**
 * Created by mamorky on 12/12/17.
 */

public interface AddEditInteractor {
    void editContacto(Contacto contacto,String numeroTlf,onValidateAddEdit onValidateAddEdit);
    void addContacto(String nombre,String tlf,onValidateAddEdit onValidateAddEdit);

    interface onValidateAddEdit {
        void onErrorTlf();
        void onErrorName();
        void onSucces();
    }
}
