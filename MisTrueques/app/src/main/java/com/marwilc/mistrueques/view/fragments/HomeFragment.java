package com.marwilc.mistrueques.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marwilc.mistrueques.R;
import com.marwilc.mistrueques.adapters.HomeAdapter;


/**
 * Esta clase se encarga de crear y setear las vistas al recycler view del home fragment
 * implementando la interfaz {@see IRecyclerViewFragment}
 * A simple {@link Fragment} subclass.
 * @author marwilc
 */
public class HomeFragment extends Fragment{

    private SwipeRefreshLayout swipeRefreshLayout;  // Swipe Refresh Layout
    private RecyclerView recyclerView;              // Recycler View


    /**
     * Este metodo se encarga de crear e inflar la vista del {@see HomeFragment}
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        //Obtiene el swipe refresh layout del fragment_home.xml
        //swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.srl_home);

        //TODO: implementar el presentador de la vista

        // coloca el refresh layout en modo escucha
       /** swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });**/

        return v;
    }


    /**
     * este metodo se encarga de refrescar la vista cuando el usuario coloca el dedo en la pantalla
     * y lo desliza hacia abajo
     */
    private void refreshContent() {
        //presenter = new RecyclerViewFragmentPresenter(this, getContext());
        swipeRefreshLayout.setRefreshing(false);
    }


}
