package com.marwilc.mistrueques.view;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.marwilc.mistrueques.R;
import com.marwilc.mistrueques.view.fragments.HomeFragment;
import com.marwilc.mistrueques.view.fragments.InboxFragment;
import com.marwilc.mistrueques.view.fragments.NotificationsFragment;
import com.marwilc.mistrueques.view.fragments.SupportFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;     // definicion de un drawer layout para hacer uso en side menu
    private ActionBarDrawerToggle mToggle;  // se define un drawer toggle para poner un icono de menu en la barra de// acccion
    private TextView textView;              // Se crearan textview para la prueba del Roboto font
    private FragmentManager manager;
    private Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Toolbar custom
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.user_name);
        //toolbar.setLogo(R.drawable.profilefinal);

        if (toolbar != null)
            setSupportActionBar(toolbar);

        /* Se ubican los layouts respectivos con su id
         */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close);

        /* Se coloca en modo escucha el toggle
         */
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        /* Se activa el icono de menu en la barra de accion
         */
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*coloca en modo escucha el navigation view
         */
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        /* Setea la primera vista del home
         */
        manager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        manager.beginTransaction()
                .replace(R.id.relative_layout_for_fragment, homeFragment, homeFragment.getTag())
                .commit();

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

    /**
     * Este metodo se encarga de manejar los fragments a traves del panel lateral
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        switch (id){

            case R.id.nav_home:
                Snackbar.make(this.getCurrentFocus(),R.string.home, Snackbar.LENGTH_LONG).show();
                /*
                 * Transicion de un fragment a otro
                 */
                HomeFragment homeFragment = new HomeFragment();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_for_fragment, homeFragment, homeFragment.getTag())
                        .commit();
                toolbar.setTitle(R.string.user_name);
                break;

            case R.id.nav_inbox:

                Snackbar.make(this.getCurrentFocus(),R.string.inbox, Snackbar.LENGTH_LONG).show();
                InboxFragment inboxFragment = InboxFragment.newInstance("unParametro", "OtroParametro");
                manager.beginTransaction()
                        .replace(R.id.relative_layout_for_fragment, inboxFragment, inboxFragment.getTag())
                        .commit();
                toolbar.setTitle(R.string.inbox);
                break;

            case R.id.nav_notifications:

                Snackbar.make(this.getCurrentFocus(),R.string.notifications, Snackbar.LENGTH_LONG).show();
                NotificationsFragment notificationsFragment = NotificationsFragment.newInstance("unParametro", "OtroParametro");
                manager.beginTransaction()
                        .replace(R.id.relative_layout_for_fragment, notificationsFragment, notificationsFragment.getTag())
                        .commit();
                toolbar.setTitle(R.string.notifications);
                break;

            case R.id.nav_status:
                //TODO: hacer la funcionalidad del switch on/offline
                Snackbar.make(this.getCurrentFocus(),R.string.status, Snackbar.LENGTH_LONG).show();
                break;

            case R.id.nav_sales:
                //TODO: crear el fragment para la gestion de los intercambios
                Snackbar.make(this.getCurrentFocus(),R.string.sales, Snackbar.LENGTH_LONG).show();
                break;

            case R.id.nav_settings:
                //TODO: crear el fragment para a configuracion de la aplicacion
                Snackbar.make(this.getCurrentFocus(),R.string.settings, Snackbar.LENGTH_LONG).show();
                break;

            case R.id.nav_profile:
                //TODO: crear el activity para el perfil del usuario
                Snackbar.make(this.getCurrentFocus(),R.string.profile, Snackbar.LENGTH_LONG).show();
                final Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_support:
                //TODO: crear el fragment para el soporte de usuario
                Snackbar.make(this.getCurrentFocus(),R.string.support, Snackbar.LENGTH_LONG).show();
                SupportFragment supportFragment = SupportFragment.newInstance("unParametro", "OtroParametro");
                manager.beginTransaction()
                        .replace(R.id.relative_layout_for_fragment, supportFragment, supportFragment.getTag())
                        .commit();
                toolbar.setTitle(R.string.support);
                break;

            case R.id.nav_version:
                //TODO: crear el fragment para dar informacion acerca de la aplicacion
                Snackbar.make(this.getCurrentFocus(),R.string.version, Snackbar.LENGTH_LONG).show();
                break;

            default:
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
