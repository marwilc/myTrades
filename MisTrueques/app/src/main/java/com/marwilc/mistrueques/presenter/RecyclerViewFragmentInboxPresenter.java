package com.marwilc.mistrueques.presenter;

import android.content.Context;
import android.content.res.Resources;

import com.marwilc.mistrueques.R;
import com.marwilc.mistrueques.model.InboxMenssage;
import com.marwilc.mistrueques.view.fragments.IRecyclerViewFragment;

import java.util.ArrayList;

/**
 * Created by marwilc on 5/13/18.
 * Package name  com.marwilc.mistrueques.presenter
 * Time 8:07 AM
 * Project  MisTrueques
 * Esta clase se encarga de prensentar los datos en el recyclerView del inboxFragment
 */
public class RecyclerViewFragmentInboxPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragment myIRecyclerViewFragment;
    private ArrayList<InboxMenssage> myListMenssages;
    private Context myContext;

    public RecyclerViewFragmentInboxPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.myIRecyclerViewFragment = iRecyclerViewFragment;
        this.myContext = context;
        buildListMenssagesDummy();
        showItemsForRecyclerView();
    }

    /**
     * Este metodo creara una lista de mensajes de ejemplo para mostrarlo en el RV
     */
    private void buildListMenssagesDummy() {
        /*
            TODO: quitar al final
            En este fragmento de codigo se crea una lista de menssages de prueba para la vista
         */
        Resources res = myContext.getResources();
        String[] userNames = res.getStringArray(R.array.user_names);
        String dateMenssageDummy = res.getString(R.string.dummy_date_inbox);
        String contentDummy = res.getString(R.string.lorem_ipsum_short);
        setMyListMenssages(new ArrayList<InboxMenssage>());

        for (String userName: userNames){
            InboxMenssage menssage =
                    new InboxMenssage(userName, contentDummy, dateMenssageDummy, R.drawable.profilefinal);

            myListMenssages.add(menssage);

        }
    }

    /**
     * Este metodo se encarga de mostrar los datos en el RV
     */
    @Override
    public void showItemsForRecyclerView() {
        //Inicia el adaptadador para el rv
        myIRecyclerViewFragment.initAdapterForRVInboxFragment(myIRecyclerViewFragment.createMenssageAdapter(this.myListMenssages));
        myIRecyclerViewFragment.generateLinearLayoutVertical();
    }


    public IRecyclerViewFragment getMyIRecyclerViewFragment() {
        return myIRecyclerViewFragment;
    }

    public void setMyIRecyclerViewFragment(IRecyclerViewFragment myIRecyclerViewFragment) {
        this.myIRecyclerViewFragment = myIRecyclerViewFragment;
    }

    public ArrayList<InboxMenssage> getMyListMenssages() {
        return myListMenssages;
    }

    public void setMyListMenssages(ArrayList<InboxMenssage> myListMenssages) {
        this.myListMenssages = myListMenssages;
    }

    public Context getMyContext() {
        return myContext;
    }

    public void setMyContext(Context myContext) {
        this.myContext = myContext;
    }
}
