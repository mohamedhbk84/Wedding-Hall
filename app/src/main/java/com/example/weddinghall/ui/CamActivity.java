package com.example.weddinghall.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.weddinghall.R;
import com.example.weddinghall.data.SQLiteHelper;


public class CamActivity extends AppCompatActivity {

    public static SQLiteHelper sqLiteHelper;
    final int REQUEST_CODE_GALLERY = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);


        sqLiteHelper = new SQLiteHelper(this, "WeddingDB.sqlite", null, 1);
        sqLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS WEDDING(Id INTEGER PRIMARY KEY AUTOINCREMENT, price VARCHAR,name VARCHAR ,desc VARCHAR , image BLOG)");
    }


}
