package com.renthut.laba4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> list;

    public ProductAdapter(List<Product> list) {
        this.list = list;
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView price;
        TextView status;
        TextView type;
        TextView description;
        ImageView photo;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.card_title_product);
            price = itemView.findViewById(R.id.card_product_price);
            status = itemView.findViewById(R.id.card_product_status);
            type = itemView.findViewById(R.id.card_product_type);
            photo = itemView.findViewById(R.id.card_product_img);
            description = itemView.findViewById(R.id.card_product_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent i = new Intent(context, ProductActivity.class);
                    String transitionName = context.getString(R.string.transition_product_card_string);
                    ActivityOptionsCompat options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                                    photo,
                                    transitionName
                            );
                    i.putExtra("product", list.get(getAdapterPosition()));
                    context.startActivity(i, options.toBundle());
                }
            });
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.type.setText(list.get(position).getType());
        holder.price.setText(list.get(position).getPrice() + "$");
        holder.status.setText(list.get(position).getStatus());
        holder.title.setText(list.get(position).getName());
        holder.photo.setImageResource(list.get(position).getPhoto());
        holder.description.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
