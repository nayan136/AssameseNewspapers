package com.example.nayanjyoti.assamesenewspapers.NewspaperView;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.nayanjyoti.assamesenewspapers.Data;
import com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList.Newspaper;
import com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList.NewspaperListContract;
import com.example.nayanjyoti.assamesenewspapers.R;

import java.util.List;
import java.util.concurrent.ExecutionException;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewspaperViewFragment extends Fragment implements NewspaperViewContract.View{

    private NewspaperViewContract.Presenter presenter;
    private int position;
    private String date;
    private String realUrl;
    private Bitmap bitmap;

    private ImageViewTouch imageView;

    public NewspaperViewFragment() {
        // Required empty public constructor
    }

    public static NewspaperViewFragment newInstance(){
        return new NewspaperViewFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //get valString realUrlues from adapter
        realUrl = getArguments().getString("urlByPosition");
        //*****************************************************
        View rootView = inflater.inflate(R.layout.fragment_newspaper_view, container, false);
        imageView = (ImageViewTouch)rootView.findViewById(R.id.iv_newspaper);
        imageView.setDisplayType(ImageViewTouchBase.DisplayType.FIT_WIDTH);
        makeToast(realUrl);



        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        if (presenter == null){
//            presenter = new NewspaperViewPresenter(this);
//        }

        Glide.with(this)
                .asBitmap()
                .load(realUrl)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        bitmap = resource;
                        imageView.setImageBitmap(resource);
                    }
                });
    }

    @Override
    public void setPresenter(NewspaperViewContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
       // presenter = null;

    }
}
