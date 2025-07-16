package com.ll;

import com.ll.article.ArticleController;
import com.ll.db.DBConnection;
import com.ll.system.SystemController;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

   ArticleController articleController;
   SystemController systemController;

    App() {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        DBConnection DBConnection = new DBConnection();
        DBConnection.connect();

        List<Map<String, Object>> rs = DBConnection.selectRows("select * from article");

        systemController = new SystemController();

        articleController = new ArticleController();
        systemController = new SystemController();
    }

    public void run() {

        System.out.println("==============   게시판 앱     =================");
        System.out.println("==============  등록 : write  =================");
        System.out.println("==============  등록 : list    =================");
        System.out.println("==============  삭제 : remove&id ===============");
        System.out.println("==============  수정 : modify&id ===============");
        System.out.println("==============  종료 : exit    =================");

        // 게시판앱 시작
        // while문으로 입력을 무한하게 받는다
        while(true){

            System.out.print("명령어: ");
            //trim()을 붙이면 명령어 앞뒤에 생기는 공백을 없애준다
            String command = Container.getSc().nextLine().trim();

            Request request = new Request(command);

            if(request.getActionCode().equals("exit")){
                systemController.exit();
                break;
            } else if(request.getActionCode().equals("write")) {
                articleController.write();
            } else if (request.getActionCode().equals("list")){
                articleController.list();
            } else if (request.getActionCode().startsWith("remove")){
                articleController.remove(request);
            } else if (request.getActionCode().startsWith("modify")){
                articleController.modify(request);
            }
        }
    }
}