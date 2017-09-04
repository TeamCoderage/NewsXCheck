package me.gurpreetsk.newsxcheck.dagger.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import me.gurpreetsk.newsxcheck.InitApplication;
import me.gurpreetsk.newsxcheck.dagger.ApplicationContext;
import me.gurpreetsk.newsxcheck.dagger.module.AppModule;
import me.gurpreetsk.newsxcheck.data.DataManager;
import me.gurpreetsk.newsxcheck.data.DbHelper;
import me.gurpreetsk.newsxcheck.data.SharedPrefsHelper;

/**
 * Created by Gurpreet on 29/08/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

  void inject(InitApplication application);

  @ApplicationContext
  Context getContext();

  Application getApplication();

  DataManager getDataManager();

  SharedPrefsHelper getPreferenceHelper();

  DbHelper getDbHelper();

}
