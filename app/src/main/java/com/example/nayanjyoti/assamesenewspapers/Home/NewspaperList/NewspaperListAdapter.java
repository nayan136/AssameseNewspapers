package com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nayanjyoti.assamesenewspapers.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nayanjyoti on 26-09-2017.
 */

public class NewspaperListAdapter extends RecyclerView.Adapter<NewspaperListAdapter.MyViewHolder> {

    private List<Newspaper> newspaperList;
    private Context context;
    private NewspaperListContract.Presenter presenter;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_newspaper;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_newspaper = (TextView)itemView.findViewById(R.id.tv_newspaper);
        }
    }

    public NewspaperListAdapter(List<Newspaper> newspaperList, NewspaperListContract.Presenter presenter ) {
        this.newspaperList = newspaperList;
        this.presenter = presenter;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_newspaper,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Newspaper newspaper = newspaperList.get(position);
        holder.tv_newspaper.setText(newspaper.getNewspaper());
        holder.tv_newspaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickChooseNewspaper(context, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newspaperList.size();
    }

}
