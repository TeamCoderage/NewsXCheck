package me.gurpreetsk.newsxcheck.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import me.gurpreetsk.newsxcheck.R;


/**
 * Created by Gurpreet on 29/08/17.
 */

public class DialogUtils {

  // This utility class is not publicly instantiable
  private DialogUtils() {
  }

  public static ProgressDialog showLoadingDialog(Context context) {
    ProgressDialog progressDialog = new ProgressDialog(context);
    progressDialog.show();
    if (progressDialog.getWindow() != null) {
      progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
    progressDialog.setContentView(R.layout.progress_dialog);
    progressDialog.setIndeterminate(true);
    progressDialog.setCancelable(true);
    progressDialog.setCanceledOnTouchOutside(false);
    return progressDialog;
  }

}
