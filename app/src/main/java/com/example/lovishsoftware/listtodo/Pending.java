package com.example.lovishsoftware.listtodo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Pending extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Context context;


    private static final String ARG_SECTION_NUMBER = "section_number";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerView;
    ListAdpter adapter;
    public Pending() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Pending(Context context){
        this.context=context;

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
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerlist);
        Log.d("pending ","inside oncerateview");
        RecyclerView.LayoutManager iLayoutManager=new LinearLayoutManager(getActivity());  //create verticle view layout
        recyclerView.setLayoutManager(iLayoutManager);
        //  adapter=new ListAdpter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        Log.d("Pending","recyclerview");
//            refresh();

        return v;

    }

    public void setrecyclerlist(ArrayList<ItemList> list){

        Log.d("Pending","inside setrecyclerlist");
        Log.d("Pending",""+list);
        adapter=new ListAdpter(getActivity(),list);
        Log.d("Pending","Listadpter finished");

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
}
