package me.gurpreetsk.newsxcheck.data;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import me.gurpreetsk.newsxcheck.dagger.ApplicationContext;
import me.gurpreetsk.newsxcheck.data.model.ClipboardData;


@Singleton
public class DataManager {

  private Context mContext;
  private DbHelper mDbHelper;
  private SharedPrefsHelper mSharedPrefsHelper;

  @Inject
  public DataManager(@ApplicationContext Context context,
                     DbHelper dbHelper,
                     SharedPrefsHelper sharedPrefsHelper) {
    mContext = context;
    mDbHelper = dbHelper;
    mSharedPrefsHelper = sharedPrefsHelper;
  }

  public void saveAccessToken(String accessToken) {
    mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
  }

  public String getAccessToken() {
    return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
  }

  //TODO: setup M
  public long insertData(ClipboardData data) throws Exception {
    return mDbHelper.insertData(data);
  }

  public Observable<ClipboardData> getAllClipboardData()
      throws Resources.NotFoundException, NullPointerException {
    return mDbHelper.getClipboardContents();
  }

}
