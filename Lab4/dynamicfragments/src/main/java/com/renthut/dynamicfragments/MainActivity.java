package com.renthut.dynamicfragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener {

    private FragmentManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.menu_container, MenuFragment.newInstance())
                .commit();
    }

    @Override
    public void onFragmentInteraction(String result) {
        manager.beginTransaction()
                .add(R.id.web_view_container, WebFragment.newInstance(result))
                .commit();
    }
}
