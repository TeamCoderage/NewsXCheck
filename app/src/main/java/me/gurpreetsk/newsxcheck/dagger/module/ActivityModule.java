package me.gurpreetsk.newsxcheck.dagger.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import me.gurpreetsk.newsxcheck.dagger.ActivityContext;

/**
 * Created by Gurpreet on 29/08/17.
 */

@Module
public class ActivityModule {

  private Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides
  @ActivityContext
  Context provideContext() {
    return activity;
  }

  @Provides
  Activity provideActivity() {
    return activity;
  }

}
