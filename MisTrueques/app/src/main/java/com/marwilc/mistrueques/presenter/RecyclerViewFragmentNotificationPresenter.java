package com.marwilc.mistrueques.presenter;

import android.content.Context;
import android.content.res.Resources;

import com.marwilc.mistrueques.R;
import com.marwilc.mistrueques.model.Notifications;
import com.marwilc.mistrueques.view.fragments.IRecyclerViewFragment;
import com.marwilc.mistrueques.view.fragments.NotificationsFragment;

import java.util.ArrayList;

/**
 * Created by marwilc on 5/14/18.
 * Package name  com.marwilc.mistrueques.presenter
 * Time 12:28 PM
 * Project  MisTrueques
 */
public class RecyclerViewFragmentNotificationPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragment myIRecyclerViewFragment;
    private ArrayList<Notifications> myListNotifications;
    private Context myContext;

    public RecyclerViewFragmentNotificationPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.myIRecyclerViewFragment = iRecyclerViewFragment;
        this.myContext = context;
        buildListNotificationsDummy();
        showItemsForRecyclerView();

    }

    private void buildListNotificationsDummy() {
        Resources res = myContext.getResources();

        String header = res.getString(R.string.lorem_ipsum);
        String dateNotificationDummy = res.getString(R.string.dummy_date_inbox);
        String contentDummy = res.getString(R.string.lorem_ipsum_short);
        setMyListNotifications(new ArrayList<Notifications>());

        ArrayList<Integer> idIcons = new ArrayList<>();

        idIcons.add(R.drawable.ic_party_mode_black_48dp);
        idIcons.add(R.drawable.ic_person_outline_black_48dp);
        idIcons.add(R.drawable.ic_plus_one_black_48dp);
        idIcons.add(R.drawable.ic_public_black_48dp);
        idIcons.add(R.drawable.ic_school_black_48dp);
        idIcons.add(R.drawable.ic_sentiment_dissatisfied_black_48dp);
        idIcons.add(R.drawable.ic_share_black_48dp);
        idIcons.add(R.drawable.ic_whatshot_black_48dp);

        for (int i = 0; i <= 6; i++){
            Notifications notification =
                    new Notifications(header, contentDummy, dateNotificationDummy, idIcons.get(i));

            myListNotifications.add(notification);
        }
    }

    /**
     * Este metodo se encarga de mostrar los datos en el RV
     */
    @Override
    public void showItemsForRecyclerView() {
        //Inicia el adaptadador para el rv
        myIRecyclerViewFragment.initAdapterForRVNotificationFragment(myIRecyclerViewFragment.createNotificationAdapter(this.myListNotifications));
        myIRecyclerViewFragment.generateLinearLayoutVertical();
    }

    public IRecyclerViewFragment getMyIRecyclerViewFragment() {
        return myIRecyclerViewFragment;
    }

    public void setMyIRecyclerViewFragment(IRecyclerViewFragment myIRecyclerViewFragment) {
        this.myIRecyclerViewFragment = myIRecyclerViewFragment;
    }

    public ArrayList<Notifications> getMyListNotifications() {
        return myListNotifications;
    }

    public void setMyListNotifications(ArrayList<Notifications> myListNotifications) {
        this.myListNotifications = myListNotifications;
    }

    public Context getMyContext() {
        return myContext;
    }

    public void setMyContext(Context myContext) {
        this.myContext = myContext;
    }
}
