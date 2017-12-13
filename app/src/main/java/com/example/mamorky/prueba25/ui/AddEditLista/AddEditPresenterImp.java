package com.example.mamorky.prueba25.ui.AddEditLista;

import com.example.mamorky.prueba25.data.pojo.Contacto;

/**
 * Created by mamorky on 12/12/17.
 */

public class AddEditPresenterImp implements AddEditPresenter,AddEditInteractor.onValidateAddEdit {
    AddEditView view;
    AddEditInteractor interactor;

    public AddEditPresenterImp(AddEditView view)
    {
        this.view = view;
        this.interactor = new AddEditInteractorImp(this);
    }

    @Override
    public void editContacto(Contacto contacto, String tlf) {
        interactor.editContacto(contacto,tlf,this);
    }

    @Override
    public void addContacto(String nombre, String tlf) {
        interactor.addContacto(nombre,tlf,this);
    }

    @Override
    public void onErrorTlf() {
        view.onSetErrorTlf();
    }

    @Override
    public void onErrorName() {
        view.onSetErrorName();
    }

    @Override
    public void onSucces() {
        view.onSuccess();
    }
}
