package me.gurpreetsk.newsxcheck.dagger.component;

import dagger.Component;
import me.gurpreetsk.newsxcheck.dagger.PerActivity;
import me.gurpreetsk.newsxcheck.dagger.module.ActivityModule;
import me.gurpreetsk.newsxcheck.ui.MainActivity.MainActivity;

/**
 * Created by Gurpreet on 29/08/17.
 */

@PerActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

  void inject(MainActivity target);

}
