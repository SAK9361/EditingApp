package com.collaborativeapp;

public class Document {
    private int id;
    private String name;
    private String content;
    private String lastModifiedBy;

    public Document(int id, String name) {
        this.id = id;
        this.name = name;
        this.content = "";
        this.lastModifiedBy = "";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content, String username) {
        this.content = content;
        this.lastModifiedBy = username;
    }

    @Override
    public String toString() {
        return "Document [ID=" + id + ", Name=" + name + ", Last Modified By=" + lastModifiedBy + "]";
    }
}
