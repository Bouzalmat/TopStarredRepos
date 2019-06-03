package com.example.topstarredrepos.main.components;


import com.example.topstarredrepos.main.MainActivity;
import com.example.topstarredrepos.main.modules.ContextModule;
import com.example.topstarredrepos.main.modules.MainModule;

import dagger.Component;

/**
 * Created by BouzalmatAbderrahman on 6/3/2019
 */

@Component( modules = {MainModule.class, ContextModule.class})
public interface MainComponent {
    void inject (MainActivity mainActivity);
}

