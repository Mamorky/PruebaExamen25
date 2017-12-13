package com.example.mamorky.prueba25.ui.Lista;

import com.example.mamorky.prueba25.adapter.AdapterContacto;
import com.example.mamorky.prueba25.data.pojo.Contacto;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by mamorky on 12/12/17.
 */

public class ListaPresenterImp implements ListaPresenter,ListaInteractorImp.onLoadSucess,ListaInteractorImp.onDeleteSucess{
    ListaInteractor interactor;
    ListaView view;

    public ListaPresenterImp(ListaView view){
        this.view = view;
        this.interactor = new ListaInteractorImp(this);
    }

    @Override
    public void loadContactos() {
        interactor.searchPersonas(this);
    }

    @Override
    public void orderContactos(Comparator<Contacto> comparator, AdapterContacto adapterContacto) {
        adapterContacto.sort(comparator);
    }

    @Override
    public void deleteContacto(Contacto contacto) {
        interactor.deleteContacto(contacto,this);
    }

    @Override
    public void onSuccess(ArrayList<Contacto> contactos) {
        view.showLista(contactos);
    }

    @Override
    public void onDeleteSucces() {
        view.onSetDeleteSuccess();
    }
}
