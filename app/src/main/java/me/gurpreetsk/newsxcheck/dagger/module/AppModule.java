package me.gurpreetsk.newsxcheck.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import me.gurpreetsk.newsxcheck.dagger.ApplicationContext;
import me.gurpreetsk.newsxcheck.dagger.DatabaseInfo;

/**
 * Created by Gurpreet on 29/08/17.
 */

@Module
public class AppModule {

  private Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return application;
  }

  @Provides
  Application provideApplication() {
    return application;
  }

  @Provides
  @DatabaseInfo
  String provideDatabaseName() {
    return "kitecash-task.db";
  }

  @Provides
  @DatabaseInfo
  Integer provideDatabaseVersion() {
    return 2;
  }

  @Provides
  SharedPreferences provideSharedPrefs() {
    return application.getSharedPreferences("kitecash-task", Context.MODE_PRIVATE);
  }

}
