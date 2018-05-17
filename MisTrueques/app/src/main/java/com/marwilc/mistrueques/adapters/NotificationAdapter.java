package com.marwilc.mistrueques.adapters;

import android.app.Activity;
import android.app.Notification;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.marwilc.mistrueques.R;
import com.marwilc.mistrueques.model.Notifications;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marwilc on 5/14/18.
 * Package name  com.marwilc.mistrueques.adapters
 * Time 2:25 PM
 * Project  MisTrueques
 */
public class NotificationAdapter
        extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>{

    private ArrayList<Notifications> myNotifications;
    private Activity myActivity;


    /**
     * Este constructor crea un adaptador del inbox messages con los parametros siguientes
     * @param notifications
     * @param activity
     */
    public NotificationAdapter(ArrayList<Notifications> notifications, Activity activity) {
        this.myNotifications = notifications;
        this.myActivity = activity;
    }

    /**
     * Called when RecyclerView needs a new {@link RecyclerView.ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * . Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(RecyclerView.ViewHolder, int)
     */
    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification,parent,false);
        return new NotificationViewHolder(v);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the  to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use  which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(RecyclerView.ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationViewHolder holder, int position) {
        final Notifications notification = myNotifications.get(position);

        /*
            Se configuran los datos en los distintos campos
         */

        holder.civIcon.setImageResource(notification.getIdProfilePicture());
        holder.tvHeader.setText(notification.getUserName());
        holder.tvContentNotification.setText(notification.getContentMenssage());
        holder.tvDateNotification.setText(notification.getDateMenssage());


    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return myNotifications.size();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder{
        private CircularImageView civIcon; // icono de la notificacion
        private TextView tvHeader;  // este es la cabecera de la notificacion
        private TextView tvDateNotification;    // fecha de la notificacion
        private TextView tvContentNotification; // contenido de la notificacion

        public NotificationViewHolder( View itemView){
            super(itemView);
            civIcon = (CircularImageView) itemView.findViewById(R.id.civ_icon_notification);
            tvHeader = (TextView) itemView.findViewById(R.id.tv_head_notification);
            tvContentNotification = (TextView) itemView.findViewById(R.id.tv_message_notification);
            tvDateNotification = (TextView) itemView.findViewById(R.id.tv_date_notification);

        }

    }

    public ArrayList<Notifications> getMyNotifications() {
        return myNotifications;
    }

    public void setMyNotifications(ArrayList<Notifications> myNotifications) {
        this.myNotifications = myNotifications;
    }

    public Activity getMyActivity() {
        return myActivity;
    }

    public void setMyActivity(Activity myActivity) {
        this.myActivity = myActivity;
    }
}