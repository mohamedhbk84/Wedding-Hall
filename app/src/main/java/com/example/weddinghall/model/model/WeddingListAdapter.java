package com.example.weddinghall.model.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weddinghall.R;

import java.util.ArrayList;

public class WeddingListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Wedding> weddingList;

    public WeddingListAdapter(Context context, int layout, ArrayList<Wedding> weddingList) {
        this.context = context;
        this.layout = layout;
        this.weddingList = weddingList;
    }

    @Override
    public int getCount() {
        return weddingList.size();
    }

    @Override
    public Object getItem(int position) {
        return weddingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
private class ViewHolder{
    ImageView imageView;
    TextView txtPrice,txtDesc;
}



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtPrice = row.findViewById(R.id.Txt_view_sale);
            holder.txtDesc = row.findViewById(R.id.Txt_view_desc);
            holder.imageView = row.findViewById(R.id.image_view);
            row.setTag(holder);
        }else {

            holder= (ViewHolder) row.getTag();
        }

        Wedding wedding =weddingList.get(position);
        holder.txtPrice.setText(wedding.getPrice());
        holder.txtName.setText(wedding.getName());
        holder.txtDesc.setText(wedding.getDesc());
        byte [] weddingImage = wedding.getImage();
           Bitmap bitmap = BitmapFactory.decodeByteArray(weddingImage,0,weddingImage.length);
           holder.imageView.setImageBitmap(bitmap);


        return row;
    }
}
