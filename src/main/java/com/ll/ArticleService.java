package com.ll;

import com.ll.article.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    List<Article>  articleList = new ArrayList<>();
    int lastId = 1;

    public int create(String title, String content){
        Article article = new Article(lastId, title, content);
        articleList.add(article);
        lastId++;

        return article.getId();
    }
    public List<Article> findAll(){
        return articleList;
    }
    public Article getFindById(int id) {

        // articleLIst 를 받아서, Article 객체item 에 넣어서 반복한다
        // if문 조건에 맞는 item을 return 한다
        for ( Article item : articleList){
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public void remove(Article article){
        articleList.remove(article);
    }
    public void modify(Article article, String subject, String content){
        article.setSubject(subject);
        article.setContent(content);
    }
}

