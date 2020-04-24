package com.renthut.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Product> products = Arrays.asList(
                new Product("Soup",  "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 50, 200, "Material", R.drawable.ribsteak),
                new Product("Meat", "Beef","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "Sold", 100, 10, "Material", R.drawable.ribsteak),
                new Product("Soup", "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 80, 20, "Material", R.drawable.ribsteak),
                new Product("Soup", "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 40, 23, "Material", R.drawable.ribsteak),
                new Product("Soup", "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 50, 234, "Material", R.drawable.ribsteak),
                new Product("Meat", "Beef","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "Sold", 60, 42, "Material", R.drawable.ribsteak),
                new Product("Soup", "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 80, 12, "Material", R.drawable.ribsteak),
                new Product("Soup", "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 70, 1.2, "Material", R.drawable.ribsteak),
                new Product("Soup", "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 545, 23.3, "Material", R.drawable.ribsteak),
                new Product("Meat", "Beef","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "Sold", 50, 2, "Material", R.drawable.ribsteak),
                new Product("Soup", "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 560, 17, "Material", R.drawable.ribsteak),
                new Product("Soup", "Borsch","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 20, 75, "Material", R.drawable.ribsteak)
        );

        ListView lv = findViewById(R.id.product_list);
        lv.setAdapter(new ProductAdapter(products));
    }
}
