package com.renthut.laba4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductDetailAdapter extends RecyclerView.Adapter<ProductDetailAdapter.ProductDetailHolder> {

    private List<String> details;
    private List<String> values;
    private List<Integer> icons;

    public ProductDetailAdapter(List<String> details, List<Integer> icons, List<String> values) {
        this.details = details;
        this.values = values;
        this.icons = icons;
    }

    class ProductDetailHolder extends RecyclerView.ViewHolder {

        TextView detailName;
        TextView detailValue;
        ImageButton detailImg;

        public ProductDetailHolder(@NonNull View itemView) {
            super(itemView);

            detailImg = itemView.findViewById(R.id.detail_img);
            detailName = itemView.findViewById(R.id.detail_name);
            detailValue = itemView.findViewById(R.id.detail_value);
        }
    }

    @NonNull
    @Override
    public ProductDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_details_item, parent, false);
        return new ProductDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDetailHolder holder, int position) {
        holder.detailImg.setImageResource(icons.get(position));
        holder.detailName.setText(details.get(position));
        holder.detailValue.setText(values.get(position));
    }

    @Override
    public int getItemCount() {
        return details.size();
    }
}