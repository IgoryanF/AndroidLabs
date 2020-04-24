package com.renthut.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityOptionsCompat;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private List<Product> list;

    public ProductAdapter(List<Product> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_item, parent, false);

        TextView title = convertView.findViewById(R.id.card_title_product);
        TextView price = convertView.findViewById(R.id.card_product_price);
        TextView status = convertView.findViewById(R.id.card_product_status);
        TextView type = convertView.findViewById(R.id.card_product_type);
        final ImageView photo = convertView.findViewById(R.id.card_product_img);
        final TextView description = convertView.findViewById(R.id.card_product_description);

        type.setText(list.get(position).getType());
        price.setText(list.get(position).getPrice() + "$");
        status.setText(list.get(position).getStatus());
        title.setText(list.get(position).getName());
        photo.setImageResource(list.get(position).getPhoto());
        description.setText(list.get(position).getDescription());

        convertView.setOnClickListener(new View.OnClickListener() {
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
                i.putExtra("product", list.get(position));
                context.startActivity(i, options.toBundle());
            }
        });

        return convertView;
    }
}
