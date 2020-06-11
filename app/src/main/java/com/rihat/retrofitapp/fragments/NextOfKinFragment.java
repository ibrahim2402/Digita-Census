package com.rihat.retrofitapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rihat.retrofitapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NextOfKinFragment extends Fragment {

    public NextOfKinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_of_kin, container, false);
    }
}
