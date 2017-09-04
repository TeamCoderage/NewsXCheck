package me.gurpreetsk.newsxcheck.ui.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import me.gurpreetsk.newsxcheck.R;
import me.gurpreetsk.newsxcheck.ui.base.BaseActivity;


public class MainActivity extends BaseActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  public static Intent getStartIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }



}
