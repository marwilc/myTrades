package com.marwilc.mistrueques.view;

import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.marwilc.mistrueques.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;     // definicion de un drawer layout para hacer uso en side menu
    private ActionBarDrawerToggle mToggle;  // se define un drawer toggle para poner un icono de menu en la barra de// acccion
    private TextView textView;              // Se crearan textview para la prueba del Roboto font

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Colocacion de la fuente roboto a un textView

        textView = (TextView) findViewById(R.id.textViewMainLayout);
        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        textView.setTypeface(roboto);
        */
        /* Toolbar custom
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.myActionBar);

        if (toolbar != null)
            setSupportActionBar(toolbar);

        /* Se ubican los layouts respectivos con su id
         */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close);

        /* Se coloca en modo escucha el toggle
         */
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        /* Se activa el icono de menu en la barra de accion
         */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    /**
     * Este metodo indica si esta seleccionado el boton de de menu en la barra
     * @param item
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
