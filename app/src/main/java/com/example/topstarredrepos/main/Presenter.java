package com.example.topstarredrepos.main;

import android.util.Log;

import com.example.topstarredrepos.main.interfaces.PresenterInterface;
import com.example.topstarredrepos.utils.GlobalVars;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by BouzalmatAbderrahman on 6/2/2019
 */
public class Presenter implements PresenterInterface {

    public static String setUpUrl(){
        // Get 1 month ago from current datetime for the api query
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date currentDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String url = GlobalVars.API_URL + GlobalVars.API_QUERY + format.format(currentDate) + GlobalVars.API_PARAMS;
        Log.d("CURRENT_DATE", url);
        return url;
    }
}
