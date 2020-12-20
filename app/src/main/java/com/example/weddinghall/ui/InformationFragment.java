package com.example.weddinghall.ui;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weddinghall.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment {
    private TextView tx_phone;
    private Button btn_call;
    private ImageView im_twitter, im_face, im_google, im_youtube, im_insta, im_whats;
    private String[] permissions;

    public InformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_information, container, false);
        tx_phone = inflate.findViewById(R.id.contact_num);
        im_face = inflate.findViewById(R.id.contact_face);
        im_google = inflate.findViewById(R.id.contact_google);
        im_insta = inflate.findViewById(R.id.contact_insta);
        im_twitter = inflate.findViewById(R.id.contact_twitter);
        im_whats = inflate.findViewById(R.id.contact_whats);
        im_youtube = inflate.findViewById(R.id.contact_youtube);
        btn_call = inflate.findViewById(R.id.contact_call);
        im_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullUrl = "https://m.facebook.com";
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setPackage("com.facebook.katana");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "your title text");
                    startActivity(sharingIntent);

                } catch (Exception e) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(fullUrl));
                    startActivity(i);


                }
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
//                startActivity(browserIntent);
            }
        });

        im_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullUrl = "https://m.twitter.com";
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setPackage("com.twitter.katana");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "your title text");
                    startActivity(sharingIntent);

                } catch (Exception e) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(fullUrl));
                    startActivity(i);


                }
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl));
//                startActivity(browserIntent);
            }
        });

        im_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullUrl = "https://m.youtube.com";
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setPackage("com.youtube");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "your title text");
                    startActivity(sharingIntent);

                } catch (Exception e) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(fullUrl));
                    startActivity(i);


                }
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
//                startActivity(browserIntent);
            }
        });

        im_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullUrl = "https://m.instagram.com";
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setPackage("com.instagram.katana");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "your title text");
                    startActivity(sharingIntent);

                } catch (Exception e) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(fullUrl));
                    startActivity(i);


                }
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
//                startActivity(browserIntent);
            }
        });
        im_whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PackageManager pm = getContext().getPackageManager();
                try {

                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");

                    PackageInfo info = pm.getPackageInfo("com.whatsapp",
                            PackageManager.GET_META_DATA);

                    waIntent.setPackage("com.whatsapp");

                    waIntent.putExtra(Intent.EXTRA_TEXT, "تطبيق بنك الدم");
                    startActivity(Intent.createChooser(waIntent, "Share with"));

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(getContext(), "WhatsApp not Installed", Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });

        im_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullUrl = "https://m.google.com";
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setPackage("com.google.katana");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "your title text");
                    startActivity(sharingIntent);

                } catch (Exception e) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(fullUrl));
                    startActivity(i);


                }

//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleUrl));
//                startActivity(browserIntent);
            }
        });
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isPermissionGranted()) {
                    call_action();
                }
            }
        });
        permissions = new String[]{Manifest.permission.CALL_PHONE};
        return inflate;
    }

    private boolean isPermissionGranted() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(getContext(), p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(getActivity(), listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 100);
            return false;
        }
        return true;

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // do something
            }
            return;
        }
    }


    public void call_action() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel: 01559606577" ));
        startActivity(callIntent);
    }
}