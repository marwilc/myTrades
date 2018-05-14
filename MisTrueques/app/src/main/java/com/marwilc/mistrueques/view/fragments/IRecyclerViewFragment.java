package com.marwilc.mistrueques.view.fragments;

import com.marwilc.mistrueques.adapters.InboxMenssageAdapter;
import com.marwilc.mistrueques.model.InboxMenssage;

import java.util.ArrayList;

/**
 * Created by marwilc on 5/13/18.
 * Package name  com.marwilc.mistrueques.view.fragments
 * Time 2:23 PM
 * Project  MisTrueques
 * Esta interface se encarga de los detalles de la funcionalidad de la vista del RV
 */
public interface IRecyclerViewFragment {

    /**
     * Este metodo genera un linear layout vertical para el RV
     */
    public void generateLinearLayoutVertical();

    /**
     * Este metodo inicializa el adaptador para el rv del imbox fragment
     */
    public void initAdapterForRVInboxFragment(InboxMenssageAdapter inboxMenssageAdapter);

    /**
     * Este metodo crea el adaptador para los inbox Menssages
     * @param menssages
     * @return
     */
    public InboxMenssageAdapter createMenssageAdapter(ArrayList<InboxMenssage> menssages);
}
