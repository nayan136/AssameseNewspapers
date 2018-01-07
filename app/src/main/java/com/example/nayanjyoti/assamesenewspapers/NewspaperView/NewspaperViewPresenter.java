package com.example.nayanjyoti.assamesenewspapers.NewspaperView;

import com.example.nayanjyoti.assamesenewspapers.Data;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Nayanjyoti on 01-10-2017.
 */

public class NewspaperViewPresenter implements NewspaperViewContract.Presenter {

    private NewspaperViewContract.View view;

    public NewspaperViewPresenter(NewspaperViewContract.View view) {
        this.view = view;
    }

    @Override
    public String setStartUrl(String date, int position) {
        List<String> newspaperUrls = Data.getNewspaperUrls();
        String url = newspaperUrls.get(position);
        String[] time = date.split("-");
        String realUrl;
        String format = "jpg";
        if (position == 2){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            if (day == Integer.valueOf(time[0])&& month == Integer.valueOf(time[1])-1 && year == Integer.valueOf(time[2])){
                realUrl = String.format(url,"","","current",1,format);
            }else {
                realUrl = String.format(url,time[0],time[1],time[2],1,format);
            }

        }else{
            realUrl = String.format(url,time[0],time[1],time[2],1);
        }

        return realUrl;
    }
}
