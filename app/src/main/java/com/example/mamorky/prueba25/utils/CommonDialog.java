package com.example.mamorky.prueba25.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.mamorky.prueba25.ui.Lista.ListaPresenter;
import com.example.mamorky.prueba25.R;
import com.example.mamorky.prueba25.data.pojo.Contacto;

/**
 * Created by mamorky on 12/12/17.
 */
public class CommonDialog {
    public static final String MESSAGE="messageContext";
    public static final String TITLE = "titleContext";
    public static final String CONTACTO = "contactoContext";


    public Dialog showDialogResult(Bundle bundle, final ListaPresenter presenter, Context context){
        String message = bundle.getString(MESSAGE);
        String title = bundle.getString(TITLE);
        final Contacto contacto = (Contacto) bundle.getSerializable(CONTACTO);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(title).setMessage(message).setPositiveButton(R.string.btn_context_delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.deleteContacto(contacto);
            }
        }).setNegativeButton(R.string.btn_context_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.show();
    }
}
