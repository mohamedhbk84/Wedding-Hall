package com.example.weddinghall.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TableLayout;

import com.example.weddinghall.R;
import com.example.weddinghall.model.FragmentsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TableLayout tabLayout;
    private ViewPager viewPager;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = inflate.findViewById(R.id.viewpager);
        tabLayout = inflate.findViewById(R.id.tab);

        FragmentsAdapter fragmentsAdapter = new FragmentsAdapter(getChildFragmentManager());
        viewPager.setAdapter(fragmentsAdapter);
        return inflate;
    }

}
