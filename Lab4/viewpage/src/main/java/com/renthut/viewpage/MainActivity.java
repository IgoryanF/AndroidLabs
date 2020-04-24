package com.renthut.viewpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager = findViewById(R.id.pager);

        ViewPageAdapter adapter = new ViewPageAdapter(this);
        adapter.addFragment(WebFragment.newInstance("https://www.google.com.ua/"));
        adapter.addFragment(WebFragment.newInstance("https://uk-ua.facebook.com/"));
        adapter.addFragment(WebFragment.newInstance("https://twitter.com/?lang=ru"));
        adapter.addFragment(WebFragment.newInstance("https://bit.ly/2xQGcd2"));

        pager.setAdapter(adapter);


        TabLayout tabLayout = findViewById(R.id.tabs);
        new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Google");
                        break;
                    case 1:
                        tab.setText("Facebook");
                        break;
                    case 2:
                        tab.setText("Twitter");
                        break;
                    case 3:
                        tab.setText("Wikipedia");
                        break;
                }
            }
        }).attach();
    }

    static class ViewPageAdapter extends FragmentStateAdapter {

        private List<Fragment> list;

        ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            list = new ArrayList<>();
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return list.get(position);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        void addFragment(Fragment fragment) {
            list.add(fragment);
        }
    }
}
