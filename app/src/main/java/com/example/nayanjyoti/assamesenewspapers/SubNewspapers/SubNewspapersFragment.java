package com.example.nayanjyoti.assamesenewspapers.SubNewspapers;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList.NewspaperListPresenter;
import com.example.nayanjyoti.assamesenewspapers.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubNewspapersFragment extends Fragment implements SubNewspapersContract.View {

    private int position;
    private String date;
    private SubNewspapersContract.Presenter presenter;
    private List<String> urlsList = new ArrayList<>();

    ImageView clickMe;

    public SubNewspapersFragment() {
        // Required empty public constructor
    }

    public static SubNewspapersFragment newInstance(){
        return new SubNewspapersFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sub_newspapers, container, false);
        presenter = new SubNewspapersPresenter(this);

        //get values from activity
        position = getArguments().getInt("position");
        date = getArguments().getString("date");
        //Toast.makeText(getActivity(),date,Toast.LENGTH_SHORT).show();

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                urlsList =  presenter.checkNumberOfPages(position,date);
            }
        });
        thread.start();

        clickMe = (ImageView)rootView.findViewById(R.id.iv_clickme);
        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(urlsList.size()>0){
                    if(thread.isAlive()){
                        thread.interrupt();
                    }
                }
                Log.i("urlSize", String.valueOf(urlsList.size()));
                presenter.onClickToViewNewspaper(getContext(),position,date);
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(presenter == null){

            presenter = new SubNewspapersPresenter(this);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getNewspaperUrl(position);
    }

    @Override
    public void setPresenter(SubNewspapersContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public List<String> getUrlsList() {
        return urlsList;
    }

}
