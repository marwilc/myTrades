package com.marwilc.mistrueques.view.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.marwilc.mistrueques.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SupportFragment} interface
 * to handle interaction events.
 * Use the {@link SupportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SupportFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ListView lvItemsSupport;

    private final String TAG = this.getClass().getSimpleName();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SupportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SupportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SupportFragment newInstance(String param1, String param2) {
        SupportFragment fragment = new SupportFragment();
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

        View v = inflater.inflate(R.layout.fragment_support, container, false);

      /*  lvItemsSupport = (ListView) v.findViewById(R.id.lv_support);

        Resources res = getResources();
        String[] itemsSupport = res.getStringArray(R.array.items_support);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getActivity().getApplicationContext(),R.layout.item_support,itemsSupport);

        lvItemsSupport.setAdapter(adapter);
        lvItemsSupport.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view,String.valueOf(position),Snackbar.LENGTH_SHORT).show();
            }
        });
*/

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvItemsSupport = (ListView) getView().findViewById(R.id.lv_support);

        Resources res = getResources();
        String[] itemsSupport = res.getStringArray(R.array.items_support);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getActivity(),R.layout.item_support,R.id.tv_option_support,itemsSupport);

        lvItemsSupport.setAdapter(adapter);
        lvItemsSupport.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view,String.valueOf(position),Snackbar.LENGTH_SHORT).show();
            }
        });
    }


}
