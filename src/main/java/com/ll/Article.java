package com.ll;


public class Article {
    private int id;
    private String subject;
    private String content;

    Article() {
        this.id = 0;
        this.subject = "";
        this.content = "";
    }
    Article( int id, String subject, String content){
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    int getId() {
        return this.id;
    }
    String getSubject() {
        return this.subject;
    }
    String getContent() {
        return this.content;
    }
}
