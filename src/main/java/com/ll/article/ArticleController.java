package com.ll.article;

import com.ll.ArticleService;
import com.ll.Container;
import com.ll.Request;

import java.util.ArrayList;
import java.util.List;


public class ArticleController {

    List<Article> articleList = new ArrayList<>();
    int lastId = 0;

    ArticleService articleService;

    public ArticleController(){
        articleService = new ArticleService();
    }

    public void write() {
            System.out.print("제목을 입력하세요 : ");
            String inputSubject = Container.getSc().nextLine().trim();
            System.out.println("제목: " + inputSubject);

            System.out.print("내용을 입력하세요 : ");
            String inputContent = Container.getSc().nextLine().trim();
            System.out.println("내용: " + inputContent);

            int id = articleService.create(inputSubject, inputContent);
            System.out.println(id + "번 게시물이 등록되었습니다");
    }
    public void list() {
        List<Article> articleList = articleService.findAll();
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

        Article article = articleService.getFindById(id);

        if( article == null){
            System.out.printf("%d게시물은 존재하지 않습니다\n", id);
        } else {
            articleService.remove(article);
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

        Article article = articleService.getFindById(id);

        if( article == null){
            System.out.printf("%d게시물은 존재하지 않습니다\n", id);
        } else {
            System.out.printf("%d / %s / %s\n" , article.getId(),article.getSubject(),article.getContent());
            System.out.println("제목을 입력해주세요");
            String modifySubject = Container.getSc().nextLine().trim();

            System.out.println("내용을 입력해주세요");
            String modifyContent = Container.getSc().nextLine().trim();

            articleService.modify(article,modifySubject,modifyContent);

            System.out.printf("%d / %s / %s\n" , article.getId(),article.getSubject(),article.getContent());
            System.out.printf("%d게시물이 수정되었습니다\n", id);

        }
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
