package com.example.mamorky.prueba25.ui.Lista;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mamorky.prueba25.ui.AddEditLista.AddEditViewImp;
import com.example.mamorky.prueba25.R;
import com.example.mamorky.prueba25.adapter.AdapterContacto;
import com.example.mamorky.prueba25.data.pojo.Contacto;
import com.example.mamorky.prueba25.ui.pref.OpcionesActivity;
import com.example.mamorky.prueba25.utils.AddEdit;
import com.example.mamorky.prueba25.utils.CommonDialog;
import com.example.mamorky.prueba25.utils.Comparators;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaViewImp extends AppCompatActivity implements ListaView{

    private ListView listaContactos;
    private AdapterContacto adapterContacto;
    private ListaPresenter presenter;

    //Esto me sirve para cuando vuelvo del AddEdit pueda ordenar la lista tal y como estaba
    private Comparator<Contacto> comparatorsMio;

    private FloatingActionButton fab;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        listaContactos = (ListView) findViewById(R.id.listaContactos);
        fab = findViewById(R.id.fab);

        adapterContacto = new AdapterContacto(this);
        presenter = new ListaPresenterImp(this);

        listaContactos.setAdapter(adapterContacto);
        registerForContextMenu(listaContactos);

        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt(AddEdit.ADDEDITMODE_KEY,AddEdit.EDIT);
                bundle.putSerializable(Contacto.TAGCONTACTO,(Contacto)parent.getItemAtPosition(position));

                Intent intent = new Intent(getApplicationContext(), AddEditViewImp.class);
                intent.putExtra("bundle",bundle);

                startActivity(intent);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(AddEdit.ADDEDITMODE_KEY,AddEdit.ADD);
                Intent intent = new Intent(getApplicationContext(),AddEditViewImp.class);
                intent.putExtra("bundle",bundle);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Boolean listaVisible = sharedPreferences.getBoolean(getString(R.string.preferences_key_switch),true);
        if(!listaVisible)
            listaContactos.setVisibility(View.INVISIBLE);
        else
            listaContactos.setVisibility(View.VISIBLE);

        presenter.loadContactos();
        presenter.orderContactos(comparatorsMio,adapterContacto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_order,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_order_id:
                presenter.orderContactos(new Comparators.CompareById(),adapterContacto);
                comparatorsMio = new Comparators.CompareById();
                break;
            case R.id.action_order_number:
                presenter.orderContactos(new Comparators.CompareByTLF(),adapterContacto);
                comparatorsMio = new Comparators.CompareByTLF();
                break;
            case R.id.action_order_name:
                presenter.orderContactos(null,adapterContacto);
                comparatorsMio = null;
                break;
            case R.id.action_preferences:
                Intent intent = new Intent(getApplicationContext(), OpcionesActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Opciones de Contacto");
        getMenuInflater().inflate(R.menu.menu_context_lista_contactos,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_borrar_lista:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Contacto contactoDel = (Contacto) listaContactos.getItemAtPosition(info.position);

                Bundle bundle = new Bundle();
                bundle.putString(CommonDialog.TITLE,"Desea ELIMINAR?");
                bundle.putString(CommonDialog.MESSAGE,"Estas seguro de eliminar a: "+contactoDel.getNombre());
                bundle.putSerializable(CommonDialog.CONTACTO,contactoDel);

                Dialog dialogo = new CommonDialog().showDialogResult(bundle,presenter,this);
                dialogo.show();
                super.onContextItemSelected(item);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void showLista(ArrayList<Contacto> contactos) {
        adapterContacto.clear();
        adapterContacto.addAll(contactos);
    }

    @Override
    public void onSetDeleteSuccess() {
        presenter.loadContactos();
        Toast.makeText(this,"Se elimino correctamente",Toast.LENGTH_LONG).show();
    }
}
