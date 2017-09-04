package me.gurpreetsk.newsxcheck.ui.base;

/**
 * Created by Gurpreet on 29/08/17.
 */

public interface BasePresenter<V extends BaseMvpView> {

  void attachView(V mvpView);

  void detachView();

}
