package me.gurpreetsk.newsxcheck.data.db;

import ckm.simple.sql_provider.UpgradeScript;
import ckm.simple.sql_provider.annotation.ProviderConfig;
import ckm.simple.sql_provider.annotation.SimpleSQLConfig;

/**
 * Created by Gurpreet on 04/09/17.
 */

@SimpleSQLConfig(name = "ClipboardProvider",
    authority = "me.gurpreetsk.newsxcheck",
    database = "clipboard.db",
    version = 1)
public class ClipboardProvider implements ProviderConfig {
  @Override
  public UpgradeScript[] getUpdateScripts() {
    return new UpgradeScript[0];
  }
}
