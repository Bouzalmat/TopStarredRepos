package com.example.topstarredrepos.main;

import android.util.Log;

import com.example.topstarredrepos.main.interfaces.PresenterInterface;
import com.example.topstarredrepos.main.models.Repo;
import com.example.topstarredrepos.utils.GlobalVars;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public static List<Repo> extractReposList(String response){

        List<Repo> reposList = new ArrayList<>();
        try {
            //Parse the String response to a JSON object
            JSONObject data = (JSONObject) new JSONTokener(response).nextValue();
            //Retrieve the items Array
            JSONArray items = data.getJSONArray("items");
            // iterate through each item and needed field the dataSet
            for(int i = 0; i < items.length(); i++){
                String title = items.getJSONObject(i).getString("name");
                String username = items.getJSONObject(i).getJSONObject("owner").getString("login");
                String description = items.getJSONObject(i).getString("description");
                String rating =  items.getJSONObject(i).getString("stargazers_count");
                Repo repo = new Repo(title, username, description , rating);
                reposList.add(repo);

            }
        } catch (JSONException e) {
            e.printStackTrace();
            return reposList;
        }

        return reposList;
    }
}
