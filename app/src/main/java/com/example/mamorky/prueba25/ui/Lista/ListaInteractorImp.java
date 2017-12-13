package com.example.mamorky.prueba25.ui.Lista;

import com.example.mamorky.prueba25.data.pojo.Contacto;
import com.example.mamorky.prueba25.data.repository.ContactoRepository;

import java.util.ArrayList;

/**
 * Created by mamorky on 12/12/17.
 */

public class ListaInteractorImp implements ListaInteractor{
    ListaPresenter presenter;

    interface onLoadSucess{
        void onSuccess(ArrayList<Contacto> contactos);
    }

    interface onDeleteSucess{
        void onDeleteSucces();
    }

    public ListaInteractorImp(ListaPresenter listaPresenterImp) {
        this.presenter = listaPresenterImp;
    }

    @Override
    public void searchPersonas(onLoadSucess onLoadSucess) {
        ArrayList<Contacto> contactos = ContactoRepository.getInstance().getContactos();
        onLoadSucess.onSuccess(contactos);
    }

    @Override
    public void deleteContacto(Contacto contacto,onDeleteSucess onDeleteSucess) {
        ContactoRepository.getInstance().deleteContacto(contacto);
        onDeleteSucess.onDeleteSucces();
    }
}
