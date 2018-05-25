package com.marwilc.mistrueques.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ArrayAdapter;

import com.marwilc.mistrueques.R;
import com.marwilc.mistrueques.model.Trade;
import com.marwilc.mistrueques.view.fragments.IRecyclerViewFragment;
import com.marwilc.mistrueques.view.fragments.MyTradesFragment;

import java.util.ArrayList;

/**
 * Created by marwilc on 5/23/18.
 * Package name  com.marwilc.mistrueques.presenter
 * Time 8:46 PM
 * Project  MisTrueques
 */
public class RecyclerViewFragmentTradesPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragment myIRecyclerViewFragment;
    private ArrayList<Trade> myListTrades;
    private Context myContext;

    public RecyclerViewFragmentTradesPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.myIRecyclerViewFragment = iRecyclerViewFragment;
        this.myContext = context;
        //TODO: quitar al final
        buildListTradesDummy();
        showItemsForRecyclerView();
    }

    private void buildListTradesDummy() {
        Resources res = myContext.getResources();
        String dateTradeDummy = res.getString(R.string.dummy_date_inbox);
        String descriptionDummy = res.getString(R.string.lorem_ipsum_short);
        setListTrades(new ArrayList<Trade>());

        ArrayList<Integer> idPicture = new ArrayList<>();

        idPicture.add(R.drawable.img_smartphone);
        idPicture.add(R.drawable.img_laptop);
        idPicture.add(R.drawable.img_usb);
        idPicture.add(R.drawable.img_hdd);
        idPicture.add(R.drawable.img_car);

        for (int i = 0; i <= 4 ; i++){
            Trade trade =
                    new Trade (descriptionDummy, dateTradeDummy, idPicture.get(i));

            myListTrades.add(trade);
        }

    }

    /**
     * Este metodo se encarga de mostrar los datos en el RV
     */
    @Override
    public void showItemsForRecyclerView() {
        myIRecyclerViewFragment.initAdapterForRVTradesFragment(myIRecyclerViewFragment.createTradeAdapter(this.myListTrades));
        myIRecyclerViewFragment.generateLinearLayoutVertical();
    }

    public IRecyclerViewFragment getiRecyclerViewFragment() {
        return myIRecyclerViewFragment;
    }

    public void setiRecyclerViewFragment(IRecyclerViewFragment iRecyclerViewFragment) {
        this.myIRecyclerViewFragment = iRecyclerViewFragment;
    }

    public ArrayList<Trade> getListTrades() {
        return myListTrades;
    }

    public void setListTrades(ArrayList<Trade> listTrades) {
        this.myListTrades = listTrades;
    }

    public Context getContext() {
        return myContext;
    }

    public void setContext(Context context) {
        this.myContext = context;
    }
}
