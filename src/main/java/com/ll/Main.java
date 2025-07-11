package com.ll;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("==============   게시판 앱   ===================");
        System.out.println("==============  등록 : signin  ===================");
        System.out.println("==============  종료 : exit  ===================");

        // 게시판앱 시작
        // while문으로 입력을 무한하게 받는다
        while(true){
            System.out.print("명령어: ");
            String command = sc.nextLine();
            //exit 입력시 게시판앱 종료
            if(command.equals("exit")){
                System.out.println("==============게시판 앱을 종료합니다===================");
                break;
            } else if(command.equals("signin")) {

                System.out.print("제목을 입력하세요 : ");
                String inputTitle = sc.nextLine();
                System.out.println("제목: " + inputTitle);

                System.out.print("내용을 입력하세요 : ");
                String inputContent = sc.nextLine();
                System.out.println("내용: " + inputContent);
            }
        }
        sc.close();
    }
}