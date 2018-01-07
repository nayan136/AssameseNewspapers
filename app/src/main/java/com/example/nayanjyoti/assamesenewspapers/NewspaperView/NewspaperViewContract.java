package com.example.nayanjyoti.assamesenewspapers.NewspaperView;

/**
 * Created by Nayanjyoti on 01-10-2017.
 */

public interface NewspaperViewContract {

    interface View{
        void setPresenter(NewspaperViewContract.Presenter presenter);
        void makeToast(String message);
    }

    interface Presenter{
        String setStartUrl(String date, int position);
    }
}
