import article.Article;
import article.ArticleController;
import system.SystemController;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
   Scanner sc;
   ArticleController articleController;
   SystemController systemController;

    App(Scanner sc) {
        this.sc = sc;
        articleController = new ArticleController(sc);
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
            String command = sc.nextLine().trim();
            //exit 입력시 게시판앱 종료
            if(command.equals("exit")){
                systemController.exit();
                break;
            } else if(command.equals("write")) {
                articleController.write();
            } else if (command.equals("list")){
                articleController.list();
            } else if (command.startsWith("remove?id=")){
                articleController.remove(command);
            } else if (command.startsWith("modify?id=")){
                articleController.modify(command);
            }
        }
    }

}