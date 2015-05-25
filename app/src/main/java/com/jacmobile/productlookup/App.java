package com.jacmobile.productlookup;


import android.app.Application;

import com.jacmobile.productlookup.di.AppComponent;
import com.jacmobile.productlookup.di.AppModule;
import com.jacmobile.productlookup.di.DaggerAppComponent;

public class App extends Application {
    private AppComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }
}