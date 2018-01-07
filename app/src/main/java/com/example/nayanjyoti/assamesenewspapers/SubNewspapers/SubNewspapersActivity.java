package com.example.nayanjyoti.assamesenewspapers.SubNewspapers;



import android.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import com.example.nayanjyoti.assamesenewspapers.Home.MainActivity;
import com.example.nayanjyoti.assamesenewspapers.R;
import com.squareup.leakcanary.RefWatcher;

public class SubNewspapersActivity extends AppCompatActivity {

    private static final String FRAGMENT_NAME = "SubNewspapersFragment";
    private int position;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_newspapers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //for navigation stack back button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // get intent values
        Intent intent = getIntent();
        if (intent != null){

            position = intent.getIntExtra("position", 0);
            date = intent.getStringExtra("date");
            Log.i("position",date);
        }

        //send value to fragment
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putString("date", date);
//        SubNewspapersFragment.newInstance().setArguments(bundle);

        //create fragment
        SubNewspapersFragment fragment = SubNewspapersFragment.newInstance();
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment, FRAGMENT_NAME);
        transaction.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        RefWatcher refWatcher = MainActivity.getRefWatcher(this);
 //       refWatcher.watch(this);
    }


}
