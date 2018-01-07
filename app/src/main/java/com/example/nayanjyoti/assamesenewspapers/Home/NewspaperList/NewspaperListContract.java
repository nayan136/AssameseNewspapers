package com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;


/**
 * Created by Nayanjyoti on 29-09-2017.
 */

public interface NewspaperListContract {
    interface View{
        void setPresenter(NewspaperListContract.Presenter presenter);
        void setDate(String date);
        TextView getTextView();
        Activity getParentActivity();
        void makeToast(String message);
    }

    interface Presenter{
        void onClickDateChange();
        void onClickChooseNewspaper(Context context, int position);
        void setCurrentDate();

    }
}
