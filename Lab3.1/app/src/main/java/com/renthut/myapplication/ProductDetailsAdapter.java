package com.renthut.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class ProductDetailsAdapter extends BaseAdapter {
    private List<String> details;
    private List<String> values;
    private List<Integer> icons;

    public ProductDetailsAdapter(List<String> details, List<Integer> icons, List<String> values) {
        this.details = details;
        this.values = values;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return values.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_details_item, parent, false);

        ImageButton detailImg = convertView.findViewById(R.id.detail_img);
        TextView detailName = convertView.findViewById(R.id.detail_name);
        TextView detailValue = convertView.findViewById(R.id.detail_value);

        detailImg.setImageResource(icons.get(position));
        detailName.setText(details.get(position));
        detailValue.setText(values.get(position));
        return null;
    }
}
