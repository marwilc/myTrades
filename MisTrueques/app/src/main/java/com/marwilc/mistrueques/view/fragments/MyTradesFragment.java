package com.marwilc.mistrueques.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marwilc.mistrueques.R;
import com.marwilc.mistrueques.adapters.InboxMenssageAdapter;
import com.marwilc.mistrueques.adapters.NotificationAdapter;
import com.marwilc.mistrueques.adapters.TradeAdapter;
import com.marwilc.mistrueques.model.InboxMenssage;
import com.marwilc.mistrueques.model.Notifications;
import com.marwilc.mistrueques.model.Trade;
import com.marwilc.mistrueques.presenter.IRecyclerViewFragmentPresenter;
import com.marwilc.mistrueques.presenter.RecyclerViewFragmentInboxPresenter;
import com.marwilc.mistrueques.presenter.RecyclerViewFragmentTradesPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyTradesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyTradesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyTradesFragment extends Fragment implements IRecyclerViewFragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rvTrades;
    private IRecyclerViewFragmentPresenter presenter;
    private final String TAG = this.getClass().getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MyTradesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyTradesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyTradesFragment newInstance(String param1, String param2) {
        MyTradesFragment fragment = new MyTradesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, mParam1);
        Log.d(TAG, mParam2);

        View v = inflater.inflate(R.layout.fragment_my_trades, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.srl_trades);
        rvTrades = (RecyclerView) v.findViewById(R.id.rv_trades);

        presenter = new RecyclerViewFragmentTradesPresenter(this, getContext());
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        return v;
    }

    private void refreshContent() {
        this.setPresenter(new RecyclerViewFragmentTradesPresenter(this, getContext()));
        swipeRefreshLayout.setRefreshing(false);
    }


    /**
     * Este metodo genera un linear layout vertical para el RV
     */
    @Override
    public void generateLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrades.setLayoutManager(linearLayoutManager);
    }

    /**
     * Este metodo inicializa el adaptador para el rv del imbox fragment
     *
     * @param inboxMenssageAdapter
     */
    @Override
    public void initAdapterForRVInboxFragment(InboxMenssageAdapter inboxMenssageAdapter) {

    }

    /**
     * Este metodo inicializa el adaptador para el rv del imbox fragment
     *
     * @param notificationAdapter
     */
    @Override
    public void initAdapterForRVNotificationFragment(NotificationAdapter notificationAdapter) {

    }

    /**
     * metodo inicializa el adaptador para el rv del trades fragment
     *
     * @param tradeAdapter
     */
    @Override
    public void initAdapterForRVTradesFragment(TradeAdapter tradeAdapter) {
        rvTrades.setAdapter(tradeAdapter);
    }

    /**
     * Este metodo crea el adaptador para los inbox Menssages
     *
     * @param menssages
     * @return
     */
    @Override
    public InboxMenssageAdapter createMenssageAdapter(ArrayList<InboxMenssage> menssages) {
        return null;
    }

    /**
     * Este metodo crea el adaptador para los notifications Menssages
     *
     * @param notifications
     * @return
     */
    @Override
    public NotificationAdapter createNotificationAdapter(ArrayList<Notifications> notifications) {
        return null;
    }

    /**
     * Este metodo crea el adaptador para los trades
     *
     * @param trades
     * @return
     */
    @Override
    public TradeAdapter createTradeAdapter(ArrayList<Trade> trades) {
        TradeAdapter adapter = new TradeAdapter(trades, getActivity());
        return adapter;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    public RecyclerView getRvTrades() {
        return rvTrades;
    }

    public void setRvTrades(RecyclerView rvTrades) {
        this.rvTrades = rvTrades;
    }

    public IRecyclerViewFragmentPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(IRecyclerViewFragmentPresenter presenter) {
        this.presenter = presenter;
    }
}
