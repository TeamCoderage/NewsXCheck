package me.gurpreetsk.newsxcheck;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import me.gurpreetsk.newsxcheck.dagger.component.AppComponent;
import me.gurpreetsk.newsxcheck.dagger.component.DaggerAppComponent;
import me.gurpreetsk.newsxcheck.dagger.module.AppModule;
import me.gurpreetsk.newsxcheck.data.DataManager;

/**
 * Created by Gurpreet on 29/08/17.
 */

public class InitApplication extends Application {

  AppComponent appComponent;

  @Inject
  DataManager datamanager;

  @Override
  public void onCreate() {
    super.onCreate();
    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
    appComponent.inject(this);
  }

  public static InitApplication getApplication(Context context) {
    return (InitApplication) context.getApplicationContext();
  }

  public AppComponent getComponent() {
    return appComponent;
  }

}
