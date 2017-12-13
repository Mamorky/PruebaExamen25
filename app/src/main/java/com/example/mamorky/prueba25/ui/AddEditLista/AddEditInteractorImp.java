package com.example.mamorky.prueba25.ui.AddEditLista;

import com.example.mamorky.prueba25.data.pojo.Contacto;
import com.example.mamorky.prueba25.data.repository.ContactoRepository;

/**
 * Created by mamorky on 12/12/17.
 */

public class AddEditInteractorImp implements AddEditInteractor{
    AddEditPresenter presenter;

    public AddEditInteractorImp(AddEditPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void editContacto(Contacto contacto, String numeroTlf, onValidateAddEdit onValidateAddEdit) {
        if(numeroTlf.length() != 9)
            onValidateAddEdit.onErrorTlf();
        else {
            ContactoRepository.getInstance().editContact(contacto,numeroTlf);
            onValidateAddEdit.onSucces();
        }
    }

    @Override
    public void addContacto(String nombre, String tlf, onValidateAddEdit onValidateAddEdit) {
        if(nombre.isEmpty())
            onValidateAddEdit.onErrorName();
        else if(tlf.isEmpty())
            onValidateAddEdit.onErrorTlf();
        else {
            int idCorresponiente;
            if(ContactoRepository.getInstance().getContactos().size() > 0)
                idCorresponiente = ContactoRepository.getInstance().getContactos().get(ContactoRepository.getInstance().getContactos().size()-1).getId()+1;
            else
                idCorresponiente = 0;

            ContactoRepository.getInstance().addContacto(new Contacto(idCorresponiente, nombre, tlf));
            onValidateAddEdit.onSucces();
        }
    }
}
