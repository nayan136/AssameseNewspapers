package com.example.nayanjyoti.assamesenewspapers.SubNewspapers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.nayanjyoti.assamesenewspapers.Data;
import com.example.nayanjyoti.assamesenewspapers.NewspaperView.NewspaperViewActivity;

import java.io.EOFException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.os.Handler;

/**
 * Created by Nayanjyoti on 30-09-2017.
 */

public class SubNewspapersPresenter implements SubNewspapersContract.Presenter {

    private SubNewspapersContract.View view;

    public SubNewspapersPresenter(SubNewspapersContract.View view) {
        this.view = view;
    }

    @Override
    public void getNewspaperUrl(int position) {
        List<String> allUrls = Data.getNewspaperUrls();
        String url = allUrls.get(position);
        view.makeToast(view.getDate());

    }

    @Override
    public void onClickToViewNewspaper(Context context, int position, String date) {
        List<String> urlsList = view.getUrlsList();
        if (urlsList.size() != 0) {
            Intent i = new Intent(context, NewspaperViewActivity.class);
            i.putExtra("position", position);
            i.putExtra("date", date);
            i.putStringArrayListExtra("list",(ArrayList<String>) urlsList);
            context.startActivity(i);
        }
    }

    @Override
    public List<String> checkNumberOfPages(int position, String date) {

        //real urls list
        List<String> urlsList = new ArrayList<>();

        List<String> newspaperUrls = Data.getNewspaperUrls();
        String url = newspaperUrls.get(position);
        String[] time = date.split("-");
        int i = 1;
        boolean runbefore = false;
       boolean isTrue = true;
        String format;
        HttpURLConnection connection = null;
        do {
            format = "jpg";
            String realUrl;
            if(runbefore){
                if(format.endsWith("jpg")){
                    format = "png";
                }else{
                    format = "jpg";
                }

            }
            realUrl = setUrl(position, time, url,format, i);
           
            try {
                URL url1 = new URL(realUrl);
                connection = (HttpURLConnection) url1.openConnection();
                connection.setRequestMethod("HEAD");
                int responseCode = connection.getResponseCode();
                Log.i("NewspaperPresenter",String.valueOf(isTrue) );
                Log.i("NewspaperPresenter",realUrl);
                if (responseCode == 200) {
                    urlsList.add(realUrl);
                    i++;
                    runbefore = false;

                } else {
                    //view.makeToast(String.valueOf(i));
                  if(runbefore){
                      isTrue = false;
                  }else{
                      runbefore = true;
                  }
                    //isTrue = false;
                }
            }  catch (EOFException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(isTrue);
        connection.disconnect();
        return urlsList;
    }

    private String setUrl(int position, String[] time, String url, String format, int i){
        String realUrl;
        if (position == 2){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            if (day == Integer.valueOf(time[0])&& month == Integer.valueOf(time[1])-1 && year == Integer.valueOf(time[2])){
                realUrl = String.format(url,"","","current",i,format);
            }else {
                realUrl = String.format(url,time[0],time[1],time[2],i,format);
            }

        }else{
            realUrl = String.format(url,time[0],time[1],time[2],i);
        }

        return realUrl;
    }
}
