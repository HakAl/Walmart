package com.jacmobile.productlookup.di;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import com.jacmobile.productlookup.assets.ApiConfig;
import com.jacmobile.productlookup.network.service.WalmartService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

import static android.content.Context.LOCATION_SERVICE;

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link Application} to create.
 */
@Module public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton Context provideApplicationContext() {
        return application.getApplicationContext();
    }

    @Provides @Singleton LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(LOCATION_SERVICE);
    }

    @Provides @Singleton WalmartService provideWalmartService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ApiConfig.WALMART_API_BASE_URL)
                .build();

        WalmartService service = restAdapter.create(WalmartService.class);
        return service;
    }
}