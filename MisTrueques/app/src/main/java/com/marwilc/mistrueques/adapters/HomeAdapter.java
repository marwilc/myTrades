package com.marwilc.mistrueques.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marwilc.mistrueques.R;

import java.util.ArrayList;

/**
 * Created by marwilc on 4/17/18.
 * Package name  com.marwilc.mistrueques.adapters
 * Time 10:49 PM
 * Project  MisTrueques
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{

    /**
     * Called when RecyclerView needs a new {@see ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@see onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     *
     */
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // infla la vista del header del home
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_home_fragment,parent,false);
        return new HomeViewHolder(v);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@see ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@see ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@see #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, int position) {
        //TODO setear los valores de la vista

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 0;
    }


    /**
     * Esta clase se encarga de mapear en memoria los objetos de la vista .xml
     */
    public static class HomeViewHolder extends RecyclerView.ViewHolder {

        // atributos del header home fragment
        private ImageButton btnHelp;
        private TextView tvLevelTrader;
        private TextView tvNextEvaluation;
        private TextView tvTimeResponse;
        private ProgressBar pbResponseRate;
        private ProgressBar pbTradComplete;
        private ProgressBar pbOnTimeDelivery;
        private ProgressBar pbPositiveRating;

        /**
         * este metodo obtienes los elementos como vistas y coloca como objetos para trabajarlos
         * en java
         * @param itemView
         */
        public HomeViewHolder(View itemView) {
            super(itemView);
            btnHelp          = (ImageButton) itemView.findViewById(R.id.btn_help);
            tvLevelTrader    = (TextView)    itemView.findViewById(R.id.tv_level_trader) ;
            tvNextEvaluation = (TextView)    itemView.findViewById(R.id.tv_next_evaluation);
            tvTimeResponse   = (TextView)    itemView.findViewById(R.id.tv_response_time);
            pbResponseRate   = (ProgressBar) itemView.findViewById(R.id.pb_response_rate);
            pbTradComplete   = (ProgressBar) itemView.findViewById(R.id.pb_trad_complete);
            pbOnTimeDelivery = (ProgressBar) itemView.findViewById(R.id.pb_ontime_delivery);
            pbPositiveRating = (ProgressBar) itemView.findViewById(R.id.pb_positive_rating);
        }
    }
}
