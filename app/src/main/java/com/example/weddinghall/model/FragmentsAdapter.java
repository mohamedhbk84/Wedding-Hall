package com.example.weddinghall.model;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.weddinghall.ui.SaleWeddingFragment;
import com.example.weddinghall.ui.WeddingFragment;



public class FragmentsAdapter extends FragmentPagerAdapter {

    Fragment fragments []= {new WeddingFragment(), new SaleWeddingFragment()};
    private String title;

    public FragmentsAdapter(FragmentManager childFragmentManager) {
        super(childFragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            title = "قاعات";
        }
        if (position == 1){
            title = "عروض القاعات";
        }
        return title;
    }
}
