package com.marwilc.mistrueques.view.fragments;


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
import com.marwilc.mistrueques.model.InboxMenssage;
import com.marwilc.mistrueques.model.Notifications;
import com.marwilc.mistrueques.presenter.IRecyclerViewFragmentPresenter;
import com.marwilc.mistrueques.presenter.RecyclerViewFragmentInboxPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InboxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InboxFragment extends Fragment implements IRecyclerViewFragment{

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rvMenssages;
    private IRecyclerViewFragmentPresenter presenter;

    private final String TAG = this.getClass().getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public InboxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InboxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InboxFragment newInstance(String param1, String param2) {
        InboxFragment fragment = new InboxFragment();
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

        // infla el layouy del fragment inbox
        View v = inflater.inflate(R.layout.fragment_inbox, container, false);

        // construye un SwipeRefreshLayout y lo configura con el id del xml
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.srl_inbox);

        // construye un RecyclerView y lo configura con el id del xml
        rvMenssages = (RecyclerView) v.findViewById(R.id.rv_inbox);
        // se construye un presentador
        presenter = new RecyclerViewFragmentInboxPresenter(this, getContext());
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        return v;
    }


    /**
     * Este metodo refresca la vista del inbox
     */
    private void refreshContent(){
        this.setPresenter(new RecyclerViewFragmentInboxPresenter(this, getContext()));
        swipeRefreshLayout.setRefreshing(false);
    }
    /**
     * Este metodo genera un linear layout vertical para el RV
     */
    @Override
    public void generateLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMenssages.setLayoutManager(linearLayoutManager);

    }

    /**
     * Este metodo inicializa el adaptador para el rv del imbox fragment
     *
     * @param inboxMenssageAdapter
     */
    @Override
    public void initAdapterForRVInboxFragment(InboxMenssageAdapter inboxMenssageAdapter) {
        rvMenssages.setAdapter(inboxMenssageAdapter);
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
     * Este metodo crea el adaptador para los inbox Menssages
     *
     * @param menssages
     * @return
     */
    @Override
    public InboxMenssageAdapter createMenssageAdapter(ArrayList<InboxMenssage> menssages) {
        InboxMenssageAdapter adapter = new InboxMenssageAdapter(menssages, getActivity());
        return adapter;
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

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    public RecyclerView getRvMenssages() {
        return rvMenssages;
    }

    public void setRvMenssages(RecyclerView rvMenssages) {
        this.rvMenssages = rvMenssages;
    }

    public IRecyclerViewFragmentPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(IRecyclerViewFragmentPresenter presenter) {
        this.presenter = presenter;
    }
}
