package me.gurpreetsk.newsxcheck.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import me.gurpreetsk.newsxcheck.InitApplication;
import me.gurpreetsk.newsxcheck.dagger.component.ActivityComponent;
import me.gurpreetsk.newsxcheck.dagger.component.DaggerActivityComponent;
import me.gurpreetsk.newsxcheck.dagger.module.ActivityModule;
import me.gurpreetsk.newsxcheck.util.DialogUtils;

/**
 * Created by Gurpreet on 04/09/17.
 */

public class BaseActivity extends AppCompatActivity implements BaseMvpView {

  private ActivityComponent mActivityComponent;
  private ProgressDialog progressDialog;

  public ActivityComponent activityComponent() {
    if (mActivityComponent == null)
      mActivityComponent = DaggerActivityComponent.builder()
          .activityModule(new ActivityModule(this))
          .appComponent(InitApplication.getApplication(this).getComponent())
          .build();
    return mActivityComponent;
  }

  @TargetApi(Build.VERSION_CODES.M)
  public void requestPermissionsSafely(String[] permissions, int requestCode) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      requestPermissions(permissions, requestCode);
    }
  }

  @TargetApi(Build.VERSION_CODES.M)
  public boolean hasPermission(String permission) {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
        checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
  }

  @Override
  public void showLoading() {
    hideLoading();
    progressDialog = DialogUtils.showLoadingDialog(this);
  }

  @Override
  public void hideLoading() {
    if (progressDialog != null && progressDialog.isShowing()) {
      progressDialog.cancel();
    }
  }

}
