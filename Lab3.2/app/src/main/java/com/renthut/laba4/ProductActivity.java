package com.renthut.laba4;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);

        Product product = (Product) getIntent().getSerializableExtra("product");

        ImageView photo = findViewById(R.id.product_img);
        TextView name = findViewById(R.id.product_name);
        TextView type = findViewById(R.id.product_type);
        TextView description = findViewById(R.id.product_description);

        photo.setImageResource(product.getPhoto());
        name.setText(product.getName());
        description.setText(product.getDescription());
        type.setText(product.getType());

        List<Integer> icons = Arrays.asList(
                R.drawable.ic_price,
                R.drawable.ic_status,
                R.drawable.ic_weight,
                R.drawable.ic_material
        );

        List<String> details = Arrays.asList(
                "Price",
                "Status",
                "Weight",
                "Material"
        );

        List<String> values = Arrays.asList(
                product.getPrice() + "$",
                product.getStatus(),
                product.getWeight() + "kg",
                product.getMaterial()
        );

        RecyclerView rv = findViewById(R.id.product_details_list);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(new ProductDetailAdapter(details, icons, values));
    }
}
