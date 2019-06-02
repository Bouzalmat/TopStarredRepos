package com.example.topstarredrepos.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by BouzalmatAbderrahman on 6/2/2019
 */
public class VolleySingleton {


    public static VolleySingleton volleyInstance;
    public static Context ctx;
    public RequestQueue requestQueue;

    public VolleySingleton(Context context){
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized VolleySingleton getInstance(Context context){
        if(volleyInstance == null){
            volleyInstance = new VolleySingleton(context);
        }

        return volleyInstance;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
