package com.example.nayanjyoti.assamesenewspapers.Home.Collection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nayanjyoti.assamesenewspapers.Home.MainActivity;
import com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList.NewspaperListFragment;
import com.example.nayanjyoti.assamesenewspapers.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollectionFragment extends Fragment {

    View v;
    public MyCollectionFragment() {
        // Required empty public constructor
    }

    public static MyCollectionFragment newInstance() {
        MyCollectionFragment fragment = new MyCollectionFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_collection, container, false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
           // ((MainActivity) getActivity()).hideDate();
        }
}
}