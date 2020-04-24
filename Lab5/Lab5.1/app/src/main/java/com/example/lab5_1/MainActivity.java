package com.example.lab5_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogWin.DialogWinListener  {

    //Create an array of elements

    List<Integer> data;
    RecyclerView recycler;
    int i;
    int N = 18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create random in a loop

        data = new ArrayList<Integer>(N);
        for (i = 0; i < N; i++){
            int a = (int) (Math.random()*(99));
            data.add(a);
        }

        recycler = findViewById(R.id.recycler_view);
        recycler.setHasFixedSize(true);

        //Smth grid for elements

        recycler.setLayoutManager(new GridLayoutManager(this, 3));
        recycler.setAdapter(new MyAdapter(data, this));
        recycler.addOnItemTouchListener(

          new RecyclerClickListener(this, recycler ,new RecyclerClickListener.OnItemClickListener() {
           @Override public void onItemClick(View view, int position) {
            String txt = data.get(position).toString();
            DialogWin dialogwin = DialogWin.newInstance(txt);

            dialogwin.show(getSupportFragmentManager(), "dialog");
         }

              @Override public void onLongItemClick(View view, int position) {}
        })
      );
   }

    @Override
    public void onDialogWinResult(String choice) {}
}