package me.gurpreetsk.newsxcheck;

import android.app.Application;
import android.content.Context;


import javax.inject.Inject;

import io.realm.Realm;
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
    Realm.init(this);
//    Stetho.initialize(
//        Stetho.newInitializerBuilder(this)
//            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//            .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
//            .build());
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
