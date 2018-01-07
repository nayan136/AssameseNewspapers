package com.example.nayanjyoti.assamesenewspapers.SubNewspapers;

import android.content.Context;

import java.util.List;

/**
 * Created by Nayanjyoti on 30-09-2017.
 */

public interface SubNewspapersContract {

    interface View{
        void setPresenter(SubNewspapersContract.Presenter presenter);
        String getDate();
        void makeToast(String message);
        List<String> getUrlsList();

    }

    interface Presenter{

        void getNewspaperUrl(int position);
        void onClickToViewNewspaper(Context context, int position, String date);
        List<String> checkNumberOfPages(int position, String date);

    }
}
