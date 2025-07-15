package com.ll.article;

import com.ll.Container;

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
    public void remove(String command) {
        //split이란? 문장이 들어오면 쪼개는 기능, 인자는 2개 들어간다. 물음표를 기준으로 solit하겠다는 의미
        String[] commandList = command.split("\\?", 2); //remove?id=1 이란 문자열을 remove 와 id=1로 2개로 나누었다
        String[] paramsStr = commandList[1].split("=",2); //id=1 이란 문자열을 id 와 1로 2개로 나누었다

        String value = paramsStr[1];
        int idx = Integer.parseInt(paramsStr[1]);

        Article article = _getFindById(idx); //변수명앞에 _ 언더바가 있다는 것은 비교적 private 하다는 것을 의미한다

        if( article == null){
            System.out.printf("%d게시물은 존재하지 않습니다\n", idx);
        } else {
            articleList.remove(article);
            System.out.printf("%d게시물이 삭제되었습니다\n", idx);
        }
    }
    public void modify(String command){

        //split이란? 문장이 들어오면 쪼개는 기능, 인자는 2개 들어간다. 물음표를 기준으로 solit하겠다는 의미
        String[] commandList = command.split("\\?", 2); //remove?id=1 이란 문자열을 remove 와 id=1로 2개로 나누었다
        String[] paramsStr = commandList[1].split("=",2); //id=1 이란 문자열을 id 와 1로 2개로 나누었다

        String value = paramsStr[1];

        int idx = Integer.parseInt(paramsStr[1]);
        Article article = _getFindById(idx);

        if( article == null){
            System.out.printf("%d게시물은 존재하지 않습니다\n", idx);
        } else {
            System.out.printf("%d / %s / %s\n" , article.getId(),article.getSubject(),article.getContent());
            System.out.println("제목을 입력해주세요");
            article.setSubject(Container.getSc().nextLine().trim());
            System.out.println("내용을 입력해주세요");
            article.setContent(Container.getSc().nextLine().trim());
            System.out.printf("%d / %s / %s\n" , article.getId(),article.getSubject(),article.getContent());
            System.out.printf("%d게시물이 수정되었습니다\n", idx);
        }
    }
    private Article _getFindById(int id) {
        for ( Article item : articleList){
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }



}
