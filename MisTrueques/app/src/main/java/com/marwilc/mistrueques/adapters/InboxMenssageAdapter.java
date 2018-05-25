package com.marwilc.mistrueques.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.marwilc.mistrueques.R;
import com.marwilc.mistrueques.model.InboxMenssage;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by marwilc on 5/13/18.
 * Package name  com.marwilc.mistrueques.adapters
 * Time 4:09 PM
 * Project  MisTrueques
 * En esta clase se define el adaptador del rv Inbox menssages
 */
public class InboxMenssageAdapter
        extends RecyclerView.Adapter<InboxMenssageAdapter.InboxMenssageViewHolder>{

    private ArrayList<InboxMenssage> myMenssages;
    private Activity myActivity;

    /**
     * Este constructor crea un adaptador del inbox messages con los parametros siguientes
     * @param menssages
     * @param activity
     */
    public InboxMenssageAdapter(ArrayList<InboxMenssage> menssages, Activity activity) {
        this.myMenssages = menssages;
        this.myActivity = activity;
    }

    /**
     * Called when RecyclerView needs a new {@link } of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #(, int, )}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #(, int)
     */
    @NonNull
    @Override
    public InboxMenssageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inbox_message,parent, false);
        return new InboxMenssageViewHolder(v);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link #} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link #()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #(, int, )} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull InboxMenssageAdapter.InboxMenssageViewHolder holder, int position) {
        final InboxMenssage menssage = myMenssages.get(position);

        /*
            Se configuran los datos en los distintos campos
         */
        holder.civPictureContact.setImageResource(menssage.getIdProfilePicture());
        String letra = String.valueOf(menssage.getUserName().charAt(0));
        holder.tvUserName.setText(menssage.getUserName());
        holder.tvDateMenssage.setText(menssage.getDateMenssage());
        holder.tvContentMenssage.setText(menssage.getContentMenssage());
        holder.tvAvatar.setText(letra);
        GradientDrawable bgShape = (GradientDrawable)holder.tvAvatar.getBackground();
        bgShape.setColor(randomColor());



    }

    private int randomColor() {

        Resources res = myActivity.getResources();
        Random rand = new Random();
        int n = rand.nextInt(5); // Gives n such that 0 <= n < 20
        int color = 0;

        switch (n){
            case 0:
                color = res.getColor(R.color.colorAccent);
            break;

            case 1:
                color = res.getColor(R.color.colorYellow);
            break;

            case 2:
                color = res.getColor(R.color.colorGreen);
            break;

            case 3:
                color = res.getColor(R.color.colorRed);
            break;

            case 4:
                color = res.getColor(R.color.colorBlue);
            break;

        }


        return color;
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return myMenssages.size();
    }

    public static class InboxMenssageViewHolder extends RecyclerView.ViewHolder{
        private CircularImageView civPictureContact; // imagen del contacto que envia el mensaje
        private TextView tvUserName; // nombre de usuaio del contacto que envia el mensaje
        private TextView tvDateMenssage; //fecha del mensaje
        private TextView tvContentMenssage; // contenido del mensaje
        private TextView tvAvatar; // text view en forma de avatar del contacto


        public InboxMenssageViewHolder(View itemView) {
            super(itemView);
            civPictureContact = (CircularImageView) itemView.findViewById(R.id.civ_avatar);
            tvUserName = (TextView) itemView.findViewById(R.id.tv_username_inbox);
            tvDateMenssage = (TextView) itemView.findViewById(R.id.tv_date_inbox);
            tvContentMenssage = (TextView) itemView.findViewById(R.id.tv_message_inbox);
            tvAvatar = (TextView) itemView.findViewById(R.id.tv_avatar);
        }
    }

    public ArrayList<InboxMenssage> getMyMenssages() {
        return myMenssages;
    }

    public void setMyMenssages(ArrayList<InboxMenssage> myMenssages) {
        this.myMenssages = myMenssages;
    }

    public Activity getMyActivity() {
        return myActivity;
    }

    public void setMyActivity(Activity myActivity) {
        this.myActivity = myActivity;
    }
}
