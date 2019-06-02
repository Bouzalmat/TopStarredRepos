package com.example.topstarredrepos.utils;

/**
 * Created by BouzalmatAbderrahman on 6/2/2019
 */
public class GlobalVars {

    public final static String API_URL = "https://api.github.com/search/repositories?";
    public final static String API_QUERY = "q=created:>";
    public final static String API_PARAMS = "&sort=stars&order=desc&page=";
    //34 page because the default item count in every page is 30 and we want 1000 items 1000/30 = 34
    public final static int PAGE_LIMIT = 34;
}
