package com.example.lab5_1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView circle;
    public TextView num;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        circle = itemView.findViewById(R.id.circle);
        num = itemView.findViewById(R.id.num);

    }
}