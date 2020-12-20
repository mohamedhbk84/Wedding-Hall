package com.example.weddinghall.ui;


import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.weddinghall.R;
import com.example.weddinghall.data.SQLiteHelper;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    EditText edtPrice, edtName, edtDesc;
    Button btnChoose, btnAdd, btnList;
    ImageView imageView;
    final int REQUEST_CODE_GALLERY = 999;
    public static SQLiteHelper sqLiteHelper;


    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_setting, container, false);
        edtPrice = inflate.findViewById(R.id.edt_price_cam);
        edtName = inflate.findViewById(R.id.edt_name_cam);
        edtDesc = inflate.findViewById(R.id.edt_desc_cam);
        btnChoose = inflate.findViewById(R.id.Choose_Image);
        btnAdd = inflate.findViewById(R.id.add_Image_cam);
        btnList = inflate.findViewById(R.id.wedding_Image_view);
        imageView = inflate.findViewById(R.id.Image_cam);
        sqLiteHelper = new SQLiteHelper(getActivity(), "WeddingDB.sqlite", null, 1);
        sqLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS WEDDING(Id INTEGER PRIMARY KEY AUTOINCREMENT, price VARCHAR,name VARCHAR ,desc VARCHAR , image BLOG)");
        getImage();
        addImage();

        return inflate;
    }

    private void addImage() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    sqLiteHelper.InsertData(
                            edtPrice.getText().toString().trim(),
                            edtName.getText().toString().trim(),
                            edtDesc.getText().toString().trim(),
                            imageViewTOByte(imageView));
                            Toast.makeText(getActivity(), "add successfully", Toast.LENGTH_SHORT).show();
                             edtPrice.setText("");
                             edtName.setText("");
                             edtDesc.setText("");
                             imageView.setImageResource(R.drawable.ic_camera_black_24dp);

                }catch (Exception e){
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        });
    }

    private void getImage() {
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
//                        Manifest.permission.READ_EXTERNAL_STORAGE);
//
//                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//                    startGallery();
//                } else {
//                    ActivityCompat.requestPermissions(getActivity(),
//                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                            2000);
//                }


                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}
                        , REQUEST_CODE_GALLERY);
//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, 1888);
            }
        });

    }

//    private void startGallery() {
//        Intent cameraIntent = new Intent(Intent.ACTION_GET_CONTENT);
//        cameraIntent.setType("image/*");
//        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//            startActivityForResult(cameraIntent, 1000);
//        }
//    }

    private byte[] imageViewTOByte(ImageView image) {
      Bitmap bitmap = ( (BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();

        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(getActivity(), " you don't have the location", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
//@Override
//public void onActivityResult(int requestCode, int resultCode, Intent data) {
//    super.onActivityResult(requestCode, resultCode, data);
//
//    if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {
//
//    }
//    Uri returnUri;
//    returnUri = data.getData();
//
//    Glide.with(getActivity())
//            .load(returnUri)
//            .override(1280, 1280)
//            .centerCrop()
//            .crossFade()
//            .into(imageView);
//}

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null ){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
//@Override
//public void onActivityResult(int requestCode, int resultCode, Intent data) {
//    if( requestCode == 1888 ) {
//        Bitmap photo = (Bitmap) data.getExtras().get("data");
//        imageView.setImageBitmap(photo);
//    }
//    }
}

