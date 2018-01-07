package com.example.nayanjyoti.assamesenewspapers.NewspaperView;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nayanjyoti.assamesenewspapers.Home.MainActivity;
import com.example.nayanjyoti.assamesenewspapers.R;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.List;

public class NewspaperViewActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LeakCanary.install(getApplication());
        setContentView(R.layout.activity_newspaper_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get values
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        String date = intent.getStringExtra("date");
        List<String> urlList = intent.getStringArrayListExtra("list");

        adapter = new CustomViewPagerAdapter(getSupportFragmentManager(), this, urlList);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        //send Values to fragment
//        Bundle bundle = new Bundle();
//        bundle.putInt("position", position);
//        bundle.putString("date", date);

        //create fragment
//        NewspaperViewFragment fragment = NewspaperViewFragment.newInstance();
//        fragment.setArguments(bundle);
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.fragment_container,fragment);
//        transaction.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        RefWatcher refWatcher = MainActivity.getRefWatcher(this);
//        refWatcher.watch(this);
    }


}
