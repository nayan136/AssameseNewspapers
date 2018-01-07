package com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nayanjyoti.assamesenewspapers.R;
import com.example.nayanjyoti.assamesenewspapers.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewspaperListFragment extends Fragment implements NewspaperListContract.View {
    private static final String ARG_SECTION_NAME = "NewspaperList";
    private List<Newspaper> newspaperNameList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewspaperListAdapter mAdapter;
    private TextView showDate;

    private NewspaperListContract.Presenter presenter;

    public NewspaperListFragment() {
        // Required empty public constructor
    }

    public static NewspaperListFragment newInstance() {
            return new NewspaperListFragment();
        }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_newspaper_list, container, false);
        rootView.setTag(ARG_SECTION_NAME);

        presenter = new NewspaperListPresenter(this);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        showDate = (TextView)rootView.findViewById(R.id.tv_show_date);
        presenter.setCurrentDate();
        showDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickDateChange();
            }
        });
        populateList();
        mAdapter = new NewspaperListAdapter(newspaperNameList, presenter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        return rootView;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(presenter == null){
            presenter = new NewspaperListPresenter(this);

        }
    }

    private void populateList() {
        List<String> nameList = Data.getNewspaperNameList();
        for (int i=0; i<nameList.size(); i++){
            Newspaper newspaper = new Newspaper();
            newspaper.setNewspaper(nameList.get(i));
            newspaperNameList.add(newspaper);
        }

    }

    @Override
    public void setPresenter(NewspaperListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setDate(String date) {
        showDate.setText(date);
    }

    @Override
    public TextView getTextView() {
        return showDate;
    }

    @Override
    public Activity getParentActivity() {
        return getActivity();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }

}
