package com.example.mamorky.prueba25.ui.pref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Switch;

import com.example.mamorky.prueba25.R;

/**
 * Created by mamorky on 13/12/17.
 */

public class OpcionesActivity extends PreferenceActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_preferencias);
    }
}
