package com.example.mamorky.prueba25.data.repository;

import com.example.mamorky.prueba25.data.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by mamorky on 12/12/17.
 */

public class ContactoRepository {
    private ArrayList<Contacto> contactos;
    private static ContactoRepository instance;

    private ContactoRepository(){
        contactos = new ArrayList<Contacto>();
        inicialice();
    }

    private void inicialice(){
        for (int i = 0; i < 6; i++) {
            addContacto(new Contacto(i,"pepe","603678489"));
            addContacto(new Contacto(i+10,"rodri","703678489"));
            addContacto(new Contacto(i+20,"maura","607677869"));
        }
    }

    public void editContact(Contacto contacto,String tlf){
        for (int i = 0; i < contactos.size(); i++) {
            if(contactos.get(i).getId() == contacto.getId()){
                contactos.get(i).setTlf(tlf);
                return;
            }
        }
    }

    public void deleteContacto(Contacto contacto){
        contactos.remove(contacto);
    }

    public void addContacto(Contacto contacto){
        contactos.add(contacto);
    }

    public ArrayList<Contacto> getContactos(){
        return contactos;
    }

    public static ContactoRepository getInstance(){
        if(instance == null)
            instance = new ContactoRepository();
        return instance;
    }
}
