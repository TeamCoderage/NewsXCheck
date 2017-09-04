package me.gurpreetsk.newsxcheck.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import me.gurpreetsk.newsxcheck.dagger.ApplicationContext;

@Singleton
public class DbHelper {

  Context context;

  @Inject
  public DbHelper(@ApplicationContext Context context) {
    this.context = context;
  }

  //  public Observable<List<ClipboardData>> getClipboardContents()
//      throws Resources.NotFoundException, NullPointerException {
//    return context.getContentResolver().query();
//  }
//
//  public Long insertData(ClipboardData data) throws Exception {
//    return context.getContentResolver().insert();
//  }

}
