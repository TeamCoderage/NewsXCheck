package me.gurpreetsk.newsxcheck.data.model;

import io.realm.RealmObject;

public class ClipboardData extends RealmObject{

    private long id;
    private String content;

    public ClipboardData() {
    }

    public ClipboardData(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
