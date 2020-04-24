package com.renthut.laba4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                List<Product> products = Arrays.asList(
                        new Product("Soup",  "Борщ","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 50, 200, "Material", R.drawable.borsh),
                        new Product("Meat", "Пельмени","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "Sold", 100, 10, "Material", R.drawable.pelmen),
                        new Product("Soup", "Стейк","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 80, 20, "Material", R.drawable.ribsteak),
                        new Product("Soup", "Суши","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 40, 23, "Material", R.drawable.sushi),
                        new Product("Soup", "Пицца","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ...", "In rent", 50, 234, "Material", R.drawable.pizza)
                );

        RecyclerView recyclerView = findViewById(R.id.product_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ProductAdapter(products));
    }
}
