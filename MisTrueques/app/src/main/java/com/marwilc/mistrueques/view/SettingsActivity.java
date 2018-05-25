package com.marwilc.mistrueques.view;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.marwilc.mistrueques.R;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView lvItemsSetings;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        lvItemsSetings = (ListView) findViewById(R.id.lv_settings);
        /* Toolbar custom
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.settings);

        if (toolbar != null)
            setSupportActionBar(toolbar);

        /* Se activa el icono de menu en la barra de accion
         */
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // esta instruccion trae desde el xml strings las cadenas de las opciones de la vista
        Resources res = getResources();
        String[] itemsSettings = res.getStringArray(R.array.items_settings);

        // crea un nuevo adaptador para la lista
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.layout.item_support, R.id.tv_option_support, itemsSettings);

        // setea el adaptador para la lista
        lvItemsSetings.setAdapter(adapter);

        lvItemsSetings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view,String.valueOf(position),Snackbar.LENGTH_SHORT).show();
            }
        });
    }


}
