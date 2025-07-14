package com.ll;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class App {
    Scanner sc;

    App(Scanner sc) {
        this.sc = sc;
    }


    public void run() {

        List<Article> articleList = new ArrayList<>();
        int lastId = 0;

        System.out.println("==============   게시판 앱   ===================");
        System.out.println("==============  등록 : signin  ===================");
        System.out.println("==============  등록 : list  ===================");
        System.out.println("==============  삭제 : remove  ===================");
        System.out.println("==============  종료 : exit  ===================");

        // 게시판앱 시작
        // while문으로 입력을 무한하게 받는다
        while(true){
            System.out.print("명령어: ");
            //trim()을 붙이면 명령어 앞뒤에 생기는 공백을 없애준다
            String command = sc.nextLine().trim();
            //exit 입력시 게시판앱 종료
            if(command.equals("exit")){
                System.out.println("==============게시판 앱을 종료합니다===================");
                break;
            } else if(command.equals("signin")) {


                System.out.print("제목을 입력하세요 : ");
                String inputSubject = sc.nextLine().trim();
                System.out.println("제목: " + inputSubject);

                System.out.print("내용을 입력하세요 : ");
                String inputContent = sc.nextLine().trim();
                System.out.println("내용: " + inputContent);

                //게시판번호++
                lastId ++;

                Article newarticle = new Article(lastId, inputSubject, inputContent);
                articleList.add(newarticle);
                System.out.println(lastId + "번 게시물이 등록되었습니다");
            } else if (command.equals("list")){

                System.out.println(" 번호 / 제목 / 내용");

                for(int i =articleList.size()-1; i >=0 ; i--){
                    Article a = articleList.get(i);
                    System.out.printf("%d / %s / %s\n" , a.getId(),a.getSubject(),a.getContent());
                }
            } else if (command.startsWith("remove")){
                //split이란? 문장이 들어오면 쪼개는 기능, 인자는 2개 들어간다. 물음표를 기준으로 solit하겠다는 의미
                String[] commandList = command.split("\\?", 2); //remove?id=1 이란 문자열을 remove 와 id=1로 2개로 나누었다
                String[] paramsStr = commandList[1].split("=",2); //id=1 이란 문자열을 id 와 1로 2개로 나누었다

                String value = paramsStr[1];
                int idx = Integer.parseInt(paramsStr[1]);

                for (int i = 0; i < articleList.size(); i++){
                    Article a = articleList.get(i);
                    if (a.getId() == idx) {
                        articleList.remove(a);
                        System.out.printf("%d게시물이 삭제되었습니다\n", idx);
                    }
                }
            }
        }
    }
}