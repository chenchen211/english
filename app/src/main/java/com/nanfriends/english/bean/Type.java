package com.nanfriends.english.bean;

public class Type extends Base {
    private int id;
    private String title;

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
