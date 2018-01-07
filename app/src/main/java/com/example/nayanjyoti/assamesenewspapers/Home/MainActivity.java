package com.example.nayanjyoti.assamesenewspapers.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.nayanjyoti.assamesenewspapers.Home.Collection.MyCollectionFragment;
import com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList.NewspaperListFragment;
import com.example.nayanjyoti.assamesenewspapers.R;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


public class MainActivity extends AppCompatActivity{

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private int day, month, year;
    private RefWatcher refWatcher;

//    public static RefWatcher getRefWatcher(Context context) {
//        MainActivity application = (MainActivity) context.getApplicationContext();
//        return application.refWatcher;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //     refWatcher = LeakCanary.install(getApplication());
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return NewspaperListFragment.newInstance();

                case 1:
                    return MyCollectionFragment.newInstance();

                default:
                    return NewspaperListFragment.newInstance();


            }

        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Newspapers";
                case 1:
                    return "My Collection";

            }
            return null;
        }
    }

//    private void chooseDate() {
//        if (mViewPager.getCurrentItem() == 0) {
//            // Get Current Date
//            final Calendar c = Calendar.getInstance();
//            year = c.get(Calendar.YEAR);
//            month = c.get(Calendar.MONTH);
//            day = c.get(Calendar.DAY_OF_MONTH);
//            long time= System.currentTimeMillis();
//
//            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
//                    new DatePickerDialog.OnDateSetListener() {
//
//                        @Override
//                        public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
//                            String month;
//                            if(monthOfYear <10){
//                                month = "0"+monthOfYear;
//                            }else{
//                                month = String.valueOf(monthOfYear);
//                            }
//                            showDate.setText(dayOfMonth + "-" + month + "-" + year);
//
//                        }
//                    }, year, month, day);
//            datePickerDialog.getDatePicker().setMaxDate(time);
//            datePickerDialog.show();
//        }
//    }

//    public List<Integer> getData(){
//        List<Integer> dateDetails = new ArrayList<>();
//        dateDetails.add(day);
//        dateDetails.add(month);
//        dateDetails.add(year);
//        return dateDetails;
//    }



}
