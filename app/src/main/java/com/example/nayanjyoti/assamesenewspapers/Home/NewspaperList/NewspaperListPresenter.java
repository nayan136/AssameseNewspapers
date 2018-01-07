package com.example.nayanjyoti.assamesenewspapers.Home.NewspaperList;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.nayanjyoti.assamesenewspapers.Home.MainActivity;
import com.example.nayanjyoti.assamesenewspapers.SubNewspapers.SubNewspapersActivity;

import java.util.Calendar;

/**
 * Created by Nayanjyoti on 29-09-2017.
 */

public class NewspaperListPresenter implements NewspaperListContract.Presenter {

    public NewspaperListContract.View view;

    public NewspaperListPresenter(NewspaperListContract.View view) {
        this.view = view;
    }

    @Override
    public void onClickDateChange() {

            final TextView showDate = view.getTextView();
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            long time= System.currentTimeMillis();

            DatePickerDialog datePickerDialog = new DatePickerDialog(view.getParentActivity(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            monthOfYear = monthOfYear+1;
                            String month, day;
                            if(dayOfMonth <10){
                                day = "0"+dayOfMonth;
                            }else{
                                day = String.valueOf(dayOfMonth);
                            }
                            if(monthOfYear <10){
                                month = "0"+monthOfYear;
                            }else{
                                month = String.valueOf(monthOfYear);
                            }
                            showDate.setText(day + "-" + month + "-" + year);

                        }
                    }, year, month, day);
            datePickerDialog.getDatePicker().setMaxDate(time);
            datePickerDialog.show();
    }

    @Override
    public void setCurrentDate() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int monthOfYear = c.get(Calendar.MONTH)+1;
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        String month, day;
        if(dayOfMonth <10){
            day = "0"+dayOfMonth;
        }else{
            day = String.valueOf(dayOfMonth);
        }
        if(monthOfYear <10){
            month = "0"+monthOfYear;
        }else{
            month = String.valueOf(monthOfYear);
        }
        view.setDate(day + "-" + month + "-" + year);
    }

    @Override
    public void onClickChooseNewspaper(Context context, int position) {
       // view.makeToast(String.valueOf(position));
        TextView showDate = view.getTextView();
        Intent i = new Intent(context, SubNewspapersActivity.class);
        i.putExtra("position", position);
        i.putExtra("date", showDate.getText().toString());
        context.startActivity(i);

    }


}
