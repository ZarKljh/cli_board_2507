package com.ll.article;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
//    List<Article> articleList = new ArrayList<>();
    int lastId = 1;

    public int create(String subject, String content){
        String sql = String.format("insert into article set subject='%s', content='%s'",subject, content);
        int id = Container.getDBConnection().insert(sql);

        return id;
    }
    public List<Article> findAll(){
        List<Article> articleList = new ArrayList<>();

        List<Map<String,Object>> rows = Container.getDBConnection().selectRows("select * from article");

        for(Map<String, Object> row: rows){
            Article article = new Article(row);
            articleList.add(article);
        }

        return articleList;
    }
    public Article findById(int id){
        // articleLIst 를 받아서, Article 객체item 에 넣어서 반복한다
        // if문 조건에 맞는 item을 return 한다
        List<Article> articleList = this.findAll();

        for ( Article item : articleList){
            if (item.getId() == id) {
                return item;
            }
        }
        return null;


    }
    public void remove(Article article){
        String sql = String.format("DELETE from article where id=%d",article.getId());
        Container.getDBConnection().delete(sql);
    }
    public void modify(Article article, String subject, String content){

        String sql = String.format("update article set subject='%s', content='%s' where id=%d",subject, content, article.getId());
        Container.getDBConnection().update(sql);
    }
}
