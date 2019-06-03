package com.example.topstarredrepos.main.modules;

import com.example.topstarredrepos.main.interfaces.ViewInterface;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BouzalmatAbderrahman on 6/3/2019
 */
@Module
public class MainModule {

    private ViewInterface viewInterface;

    public MainModule(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Provides
    public ViewInterface provideMainViewInterface(){
        return viewInterface;
    }

}
