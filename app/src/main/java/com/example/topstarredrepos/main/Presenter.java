package com.example.topstarredrepos.main;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.topstarredrepos.main.interfaces.ModelInterface;
import com.example.topstarredrepos.main.interfaces.PresenterInterface;
import com.example.topstarredrepos.main.interfaces.ViewInterface;
import com.example.topstarredrepos.main.models.Repo;
import com.example.topstarredrepos.utils.GlobalVars;
import com.paginate.Paginate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by BouzalmatAbderrahman on 6/2/2019
 */
public class Presenter implements PresenterInterface, Paginate.Callbacks {

    //public  ArrayList<Repo> reposDataSet;
    public ViewInterface view;
    @Inject Context context;
    private int page;
    private boolean loadingStatus;

    @Inject
    public Presenter(ViewInterface view){
        //this.reposDataSet = reposDataSet;
        this.view = view;
        this.page = 0;
        this.loadingStatus = false;
    }

    @Override
    public void getRepos(){
       // reposDataSet = new ArrayList<Repo>();
        Model.setCustomRequest(setUpUrl(), page, context, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loadingStatus = false;
                        //reposDataSet = (ArrayList)extractReposList(response);
                        if(view != null)
                        view.updateRepos(extractReposList(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                    }
                });
    }

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
                String avatarUrl = items.getJSONObject(i).getJSONObject("owner").getString("avatar_url");
                String rating =  items.getJSONObject(i).getString("stargazers_count");
                Repo repo = new Repo(title, username, description, avatarUrl, rating);
                reposList.add(repo);

            }
        } catch (JSONException e) {
            e.printStackTrace();
            return reposList;
        }

        return reposList;
    }

    @Override
    public void onLoadMore() {
        loadingStatus = true;
        if(page < GlobalVars.PAGE_LIMIT){
            //if the user didn't yet arrived to the bottom, increment the page count to get the next dataSet
            page++;
            getRepos();
        }
    }

    @Override
    public boolean isLoading() {
        return loadingStatus;
    }

    @Override
    public boolean hasLoadedAllItems() {
        return page >= GlobalVars.PAGE_LIMIT;
    }
}
