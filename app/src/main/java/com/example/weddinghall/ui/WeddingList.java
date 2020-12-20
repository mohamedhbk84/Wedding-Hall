package com.example.weddinghall.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weddinghall.MainActivity;
import com.example.weddinghall.R;
import com.example.weddinghall.model.model.Wedding;
import com.example.weddinghall.model.model.WeddingListAdapter;

import java.util.ArrayList;

public class WeddingList extends AppCompatActivity {
    GridView gridView;
    ArrayList<Wedding> weddingList;
    WeddingListAdapter adapter = null;
    private ArrayList<String> labels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_list);
        gridView = findViewById(R.id.wedding_Grid);
        weddingList = new ArrayList<>();
        adapter = new WeddingListAdapter(this,R.layout.wedding_row,weddingList);
        gridView.setAdapter(adapter);
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM WEDDING");
        weddingList.clear();

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String price = cursor.getString(1);
            String Name = cursor.getString(2);
            String desc = cursor.getString(3);
            byte [] image = cursor.getBlob(4);


            weddingList.add(new Wedding( price, Name , desc ,image , id ));
        }
        adapter.notifyDataSetChanged();
    }
}


