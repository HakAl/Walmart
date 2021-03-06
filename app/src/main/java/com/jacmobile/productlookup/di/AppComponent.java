package com.jacmobile.productlookup.di;

import com.jacmobile.productlookup.activities.BaseActivity;
import com.jacmobile.productlookup.activities.SearchFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity activity);
    void inject(SearchFragment fragment);
    /**
     * The following are also possible:
     *
     * void inject(InputActivity activity);
     * void inject(BaseActivity activity);
     * void inject(SomeFragmentSubclass fragment);
     *
     * They can all live harmoniously here, because they have different method signatures.
     * I've also seen injectActivity() and injectFragment() variants. I have not done research into
     * the history of this.
     */
}