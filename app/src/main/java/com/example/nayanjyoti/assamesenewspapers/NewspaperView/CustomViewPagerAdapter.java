package com.example.nayanjyoti.assamesenewspapers.NewspaperView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Nayanjyoti on 02-10-2017.
 */

public class CustomViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    List<String> urlList;
    private int position;

    public CustomViewPagerAdapter(FragmentManager fm, Context context, List<String> urlList) {
        super(fm);
        this.context = context;
        this.urlList = urlList;
    }

    @Override
    public Fragment getItem(int position) {
        this.position = position;
        Fragment fragment = new NewspaperViewFragment();
        String url = urlList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("urlByPosition", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return urlList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.i("fragment destroy", String.valueOf(position));
        super.destroyItem(container, position, object);
    }
}
