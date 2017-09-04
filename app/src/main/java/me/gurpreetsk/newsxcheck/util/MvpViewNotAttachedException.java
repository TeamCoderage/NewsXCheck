package me.gurpreetsk.newsxcheck.util;

/**
 * Created by Gurpreet on 29/08/17.
 */

public class MvpViewNotAttachedException extends RuntimeException {

  public MvpViewNotAttachedException() {
    super("Please call Presenter.attachView(V view) before" +
        " requesting data to the Presenter");
  }

}
