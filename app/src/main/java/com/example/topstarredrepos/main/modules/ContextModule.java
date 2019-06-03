package com.example.topstarredrepos.main.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BouzalmatAbderrahman on 6/3/2019
 */
@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return this.context;
    }
}
