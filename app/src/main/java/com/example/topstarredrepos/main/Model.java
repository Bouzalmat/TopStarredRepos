package com.example.topstarredrepos.main;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.topstarredrepos.main.interfaces.ModelInterface;
import com.example.topstarredrepos.utils.VolleySingleton;

/**
 * Created by Arcana inc on 6/2/2019
 */
public class Model implements ModelInterface {
    @Override
    public void setCustomRequest(String url, int page, Context context, Response.Listener<String> responseListener, Response.ErrorListener errorListener) {
        //set up string request to get repos list from the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url + page,
                responseListener,
                errorListener);

        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
