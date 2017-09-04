package me.gurpreetsk.newsxcheck.data.model;


import ckm.simple.sql_provider.annotation.SimpleSQLColumn;
import ckm.simple.sql_provider.annotation.SimpleSQLTable;

@SimpleSQLTable(table = "ClipboardData",
    provider = "me.gurpreetsk.newsxcheck")
public class ClipboardData {

  @SimpleSQLColumn(value = "id",
      primary = true,
      autoincrement = true)
  private Long id;
  @SimpleSQLColumn("content")
  private String content;

  public ClipboardData() {
  }

  public ClipboardData(String content) {
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + content + "}\n";
  }
}
