package me.gurpreetsk.newsxcheck.ui.base;


import me.gurpreetsk.newsxcheck.util.MvpViewNotAttachedException;

/**
 * Created by Gurpreet on 29/08/17.
 */

public class BasePresenterImpl<V extends BaseMvpView> implements BasePresenter<V> {

  private V view;

  @Override
  public void attachView(V view) {
    this.view = view;
  }

  @Override
  public void detachView() {
    view = null;
  }

  public boolean isViewAttached() {
    return view != null;
  }

  public V getView() {
    return view;
  }

  public void checkViewAttached() {
    if (!isViewAttached()) throw new MvpViewNotAttachedException();
  }

}
