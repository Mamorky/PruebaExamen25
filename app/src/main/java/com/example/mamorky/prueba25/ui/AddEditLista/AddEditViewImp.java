package com.example.mamorky.prueba25.ui.AddEditLista;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mamorky.prueba25.R;
import com.example.mamorky.prueba25.data.pojo.Contacto;
import com.example.mamorky.prueba25.utils.AddEdit;

public class AddEditViewImp extends AppCompatActivity implements AddEditView{

    AddEdit modo;
    private EditText edtNombre;
    private EditText edtTelefono;
    private TextInputLayout tilNombre;
    private TextInputLayout tilTelelfono;
    private Button btnGuardar;

    private AddEditPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        edtNombre = findViewById(R.id.edtNombre);
        edtTelefono = findViewById(R.id.edtTelefono);
        tilNombre = findViewById(R.id.tilNombre);
        tilTelelfono = findViewById(R.id.tilTelefono);
        btnGuardar = findViewById(R.id.btnGuardar);

        final Bundle bundle = getIntent().getBundleExtra("bundle");

        modo = new AddEdit();

        modo.modo = bundle.getInt(AddEdit.ADDEDITMODE_KEY);
        presenter = new AddEditPresenterImp(this);

        if(modo.modo == AddEdit.EDIT){
            edtNombre.setEnabled(false);

            final Contacto contacto = (Contacto) bundle.getSerializable(Contacto.TAGCONTACTO);
            edtNombre.setText(contacto.getNombre());
            edtTelefono.setText(contacto.getTlf());

            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.editContacto(contacto,edtTelefono.getText().toString());
                }
            });
        }
        else if(modo.modo == AddEdit.ADD){
            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                presenter.addContacto(edtNombre.getText().toString(),edtTelefono.getText().toString());
                }
            });
        }
    }

    @Override
    public void onSetErrorName() {
        tilNombre.setError(getString(R.string.message_error_empty_name));
    }

    @Override
    public void onSetErrorTlf() {
        tilTelelfono.setError(getString(R.string.message_error_format_tlf));
    }

    @Override
    public void onSuccess() {
        finish();
    }
}
