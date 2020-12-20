package com.example.weddinghall.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weddinghall.R;
import com.example.weddinghall.model.model.Wedding;

import java.util.ArrayList;

public class WeddingAdapter extends RecyclerView.Adapter<WeddingAdapter.WeddingHolder> {

    private ArrayList<Wedding> weddingArrayList;



    @NonNull
    @Override
    public WeddingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wedding_row, parent, false);
        return  new WeddingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeddingHolder holder, int position) {
        Wedding wedding = weddingArrayList.get(position);
        holder.imageView.setImageResource(wedding.getImage());
        holder.nameText.setText(wedding.getName());
        holder.saleText.setText(wedding.getSale());
        holder.decText.setText(wedding.getDesc());

    }

    @Override
    public int getItemCount() {
        return weddingArrayList!=null? weddingArrayList.size():0;
    }
    public  void setDataSource(ArrayList<Wedding> weddingArrayList) {
        this.weddingArrayList = weddingArrayList;

    }


    class WeddingHolder extends RecyclerView.ViewHolder {
        TextView saleText,nameText,decText;
        ImageView imageView;

        public WeddingHolder(@NonNull View itemView) {
        super(itemView);
        saleText = itemView.findViewById(R.id.Txt_view_sale);
        nameText = itemView.findViewById(R.id.Txt_view_name);
        decText = itemView.findViewById(R.id.Txt_view_desc);
        imageView = itemView.findViewById(R.id.image_view);

    }
}
}
