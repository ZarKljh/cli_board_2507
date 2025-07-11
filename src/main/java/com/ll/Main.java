package com.ll;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int lastId = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("==============   게시판 앱   ===================");
        System.out.println("==============  등록 : signin  ===================");
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
                String inputTitle = sc.nextLine().trim();
                System.out.println("제목: " + inputTitle);

                System.out.print("내용을 입력하세요 : ");
                String inputContent = sc.nextLine().trim();
                System.out.println("내용: " + inputContent);

                //게시판번호++
                lastId ++;
                System.out.println(lastId + "번 게시물이 등록되었습니다");
            }
        }
        sc.close();
    }
}