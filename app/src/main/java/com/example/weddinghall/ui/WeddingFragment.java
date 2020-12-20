package com.example.weddinghall.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weddinghall.R;
import com.example.weddinghall.model.WeddingAdapter;
import com.example.weddinghall.model.model.Wedding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeddingFragment extends Fragment {


    private RecyclerView recyclerView;
    private WeddingAdapter weddingadapter;

    public WeddingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_wedding, container, false);
         recyclerView = inflate.findViewById(R.id.Rv_Wedding);
        SetUpRecycler();
        getDataSource();
        return inflate;
    }

    public void getDataSource() {
        ArrayList<Wedding> weddingArrayList = new ArrayList<>();
        weddingArrayList.add(new Wedding("10.000","الواحة","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.mmmmmmmmmm));
        weddingArrayList.add(new Wedding("15.000","الهضبة","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.nnnnn));
        weddingArrayList.add(new Wedding("5.000","ميت عدلان","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.aaaaa));
        weddingArrayList.add(new Wedding("20.000","مسايا","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.asasas));
        weddingArrayList.add(new Wedding("13.000","طناح","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.wwwww));
        weddingArrayList.add(new Wedding("13.000","بنى عبيد","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.madadas));
        weddingArrayList.add(new Wedding("10.000","الواحة","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.mmmmmmmmmm));
        weddingArrayList.add(new Wedding("15.000","الهضبة","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.nnnnn));
        weddingArrayList.add(new Wedding("5.000","ميت عدلان","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.aaaaa));
        weddingArrayList.add(new Wedding("20.000","مسايا","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.asasas));
        weddingArrayList.add(new Wedding("13.000","طناح","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.wwwww));
        weddingArrayList.add(new Wedding("13.000","بنى عبيد","القاعة تحتوى على امكانيات غير متوفرة فى الاماكن الاخرى",R.drawable.madadas));
         weddingadapter.setDataSource(weddingArrayList);
         weddingadapter.notifyDataSetChanged();

    }

    public void SetUpRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
         weddingadapter = new WeddingAdapter();
        recyclerView.setAdapter(weddingadapter);

    }

}
