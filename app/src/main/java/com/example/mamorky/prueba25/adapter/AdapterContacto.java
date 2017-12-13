package com.example.mamorky.prueba25.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.mamorky.prueba25.R;
import com.example.mamorky.prueba25.data.pojo.Contacto;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mamorky on 12/12/17.
 */

public class AdapterContacto extends ArrayAdapter<Contacto> {
    public AdapterContacto(@NonNull Context context) {
        super(context, R.layout.item_lista,new ArrayList<Contacto>());
    }

    public class ContactoHolder{
        TextView txvNombre;
        TextView txvTlf;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewRoot = convertView;

        ContactoHolder holder = new ContactoHolder();

        if(viewRoot == null){
            viewRoot = View.inflate(getContext(),R.layout.item_lista,null);

            holder.txvNombre = viewRoot.findViewById(R.id.txvNombre);
            holder.txvTlf = viewRoot.findViewById(R.id.txvNumero);

            //Importantisimo
            viewRoot.setTag(holder);
        }
        else {
            //Esto no lo recorde bien
            holder = (ContactoHolder) viewRoot.getTag();
        }

        holder.txvNombre.setText(getItem(position).getNombre());
        holder.txvTlf.setText(getItem(position).getTlf());

        return viewRoot;
    }
}
