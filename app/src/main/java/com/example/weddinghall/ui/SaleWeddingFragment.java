package com.example.weddinghall.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weddinghall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaleWeddingFragment extends Fragment {


    public SaleWeddingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sale_wedding, container, false);
    }

}
