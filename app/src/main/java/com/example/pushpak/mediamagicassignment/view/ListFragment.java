package com.example.pushpak.mediamagicassignment.view;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pushpak.mediamagicassignment.model.ModelClass;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<ModelClass> list;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = new ArrayList<>();
        final ListAdapter adapter = new ListAdapter(getActivity(), list);
        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        if(getActivity() instanceof MainActivity){
            ((MainActivity) getActivity()).getViewMModel().getTuners().observe(this, new Observer<List<ModelClass>>() {
                @Override
                public void onChanged(@Nullable List<ModelClass> modelClasses) {
                    list.clear();
                    if(modelClasses != null){
                        list.addAll(modelClasses);
                        adapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(getActivity(), "Error in fetching Data", Toast.LENGTH_LONG);
                    }
                }
            });
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


}
