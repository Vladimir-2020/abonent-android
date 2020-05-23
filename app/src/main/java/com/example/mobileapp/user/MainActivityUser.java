package com.example.mobileapp.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mobileapp.FireBase;
import com.example.mobileapp.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivityUser extends AppCompatActivity {

    private FireBase fireBase = new FireBase();
    public static ViewPager viewPagerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

        PagerAdapterUser pagerAdapter = new PagerAdapterUser(getSupportFragmentManager());
        viewPagerUser = findViewById(R.id.view_pager);

        viewPagerUser.setAdapter(pagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPagerUser);
    }
}
