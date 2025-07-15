package com.ll.article;

import com.ll.Container;
import com.ll.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController {

    List<Article> articleList = new ArrayList<>();
    int lastId = 0;

    public void write() {
            System.out.print("제목을 입력하세요 : ");
            String inputSubject = Container.getSc().nextLine().trim();
            System.out.println("제목: " + inputSubject);

            System.out.print("내용을 입력하세요 : ");
            String inputContent = Container.getSc().nextLine().trim();
            System.out.println("내용: " + inputContent);

            //게시판번호++
            lastId ++;

            Article newarticle = new Article(lastId, inputSubject, inputContent);
            articleList.add(newarticle);
            System.out.println(lastId + "번 게시물이 등록되었습니다");
    }
    public void list() {
        System.out.println(" 번호 / 제목 / 내용");

        for(int i =articleList.size()-1; i >=0 ; i--){
            Article a = articleList.get(i);
            System.out.printf("%d / %s / %s\n" , a.getId(),a.getSubject(),a.getContent());
        }
    }
    public void remove(Request request) {
        int id = _getIntParams(request.getParams("id"));

        if(id == -1){
            System.out.println("잘못된 입력입니다");
            return;
        }

        Article article = _getFindById(id); //변수명앞에 _ 언더바가 있다는 것은 비교적 private 하다는 것을 의미한다

        if( article == null){
            System.out.printf("%d게시물은 존재하지 않습니다\n", id);
        } else {
            articleList.remove(article);
            System.out.printf("%d게시물이 삭제되었습니다\n", id);
        }
    }
    public void modify(Request request){

        int id = _getIntParams(request.getParams("id"));

        if(id == -1){
            System.out.println("잘못된 입력입니다");
            return;
        }
        //split이란? 문장이 들어오면 쪼개는 기능, 인자는 2개 들어간다. 물음표를 기준으로 solit하겠다는 의미

        Article article = _getFindById(id);

        if( article == null){
            System.out.printf("%d게시물은 존재하지 않습니다\n", id);
        } else {
            System.out.printf("%d / %s / %s\n" , article.getId(),article.getSubject(),article.getContent());
            System.out.println("제목을 입력해주세요");
            article.setSubject(Container.getSc().nextLine().trim());
            System.out.println("내용을 입력해주세요");
            article.setContent(Container.getSc().nextLine().trim());
            System.out.printf("%d / %s / %s\n" , article.getId(),article.getSubject(),article.getContent());
            System.out.printf("%d게시물이 수정되었습니다\n", id);
        }
    }
    private Article _getFindById(int id) {

        // articleLIst 를 받아서, Article 객체item 에 넣어서 반복한다
        // if문 조건에 맞는 item을 return 한다
        for ( Article item : articleList){
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private int _getIntParams(String id){
        int defaultValue = -1;

        try {
            return Integer.parseInt(id);
        } catch(NumberFormatException e) {
            return defaultValue;
        }
    }


}
