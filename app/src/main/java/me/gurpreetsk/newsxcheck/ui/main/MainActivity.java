package me.gurpreetsk.newsxcheck.ui.main;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import butterknife.ButterKnife;
import me.gurpreetsk.newsxcheck.R;
import me.gurpreetsk.newsxcheck.data.DataManager;
import me.gurpreetsk.newsxcheck.data.model.ClipboardData;
import me.gurpreetsk.newsxcheck.ui.base.BaseActivity;


public class MainActivity extends BaseActivity implements MainView {

  ClipboardManager manager;
  @Inject
  DataManager dataManager;

  private static final String TAG = MainActivity.class.getSimpleName();

  public static Intent getStartIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityComponent().inject(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
  }

  @Override
  protected void onStart() {
    super.onStart();
    if (manager.hasPrimaryClip())
      Log.i(TAG, "onPrimaryClipChanged: " + manager.getPrimaryClip().toString());
    manager.addPrimaryClipChangedListener(() -> {
      if (manager.getPrimaryClip() != null && manager.getPrimaryClip().getItemCount() > 0) {
        ClipboardData data = new ClipboardData(manager.getPrimaryClip().getItemAt(0)
            .coerceToText(MainActivity.this).toString());
        try {
          dataManager.insertData(data);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void showData() {

  }

}
