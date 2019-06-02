package com.example.topstarredrepos.main.interfaces;

import android.content.Context;

import com.android.volley.Response;

/**
 * Created by BouzalmatAbderrahman on 6/2/2019
 */
public interface ModelInterface {
     void setCustomRequest (String url, int page, Context context, Response.Listener<String> responseListener, Response.ErrorListener errorListener);
}
