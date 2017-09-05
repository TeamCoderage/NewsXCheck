package me.gurpreetsk.newsxcheck.data;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.realm.Realm;
import me.gurpreetsk.newsxcheck.dagger.ApplicationContext;
import me.gurpreetsk.newsxcheck.data.model.ClipboardData;

@Singleton
public class DbHelper {

  private Context context;
  private Realm realm;

  @Inject
  public DbHelper(@ApplicationContext Context context, Realm realm) {
    this.context = context;
    this.realm = realm;
  }

  //TODO: check
  public Observable<ClipboardData> getClipboardContents()
      throws Resources.NotFoundException, NullPointerException {
    return Observable.fromIterable(realm.where(ClipboardData.class).findAll());
  }

  public long insertData(final ClipboardData clipboardData) throws Exception {
    final long[] dataId = {-1};
    realm.executeTransaction(new Realm.Transaction() {
      @Override
      public void execute(@NonNull Realm realm) {
        ClipboardData data = realm.createObject(ClipboardData.class);
        data.setContent(clipboardData.getContent());
        data.setId(clipboardData.getId());
        dataId[0] = data.getId();
      }
    });
    return dataId[0];
  }

}
