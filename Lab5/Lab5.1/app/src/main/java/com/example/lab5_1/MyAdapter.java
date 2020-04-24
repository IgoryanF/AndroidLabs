package com.example.lab5_1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Random;

   //class Adapter for correctly work of RecyclerView

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Integer> list;

    public MyAdapter(List<Integer> list, Context context) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.circle, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        //create random color

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        ColorDrawable cd = new ColorDrawable(color);
        myViewHolder.circle.setImageDrawable(cd);
        String txt = String.valueOf(list.get(i));
        myViewHolder.num.setText(txt);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}