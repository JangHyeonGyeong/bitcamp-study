package com.rocspaper;

import java.util.Random;
import java.util.Scanner;

public class rocrspaper {
  public static void main(String[] args) {
    System.out.println("[ 가위! 바위! 보! 게임 ]");

    Scanner scanner = new Scanner(System.in); // 키보드입력받ㅈㅇ

    while(true) {

      printMenu(); // 메뉴

      int user =  inputChoice(scanner); //유저 선택

      if(user == 0) { // 0번 종료
        System.out.println("종료합니다");
        break;
      }

      computer();

      fi();









      //      if(user == 1) {
      //        if (computer() ==0)
      //          System.out.println(" 비겼습니다. ");
      //        else if(computer() ==1)
      //          System.out.println(" 컴퓨터가 이겼습니다");
      //
      //        else System.out.println("당신이 이겼습니다.");
      //      } 
      //
      //      if(user == 2) {
      //        if (computer() ==0)
      //          System.out.println("  ");
      //        else if(computer() ==1)
      //          System.out.println(" 비겼습니다");
      //
      //        else System.out.println("컴퓨터가 이겼습니다.");
      //      } 
      //
      //
      //      if(user == 3) {
      //        if (computer() ==0)
      //          System.out.println(" 컴퓨터가 이겼습니다. ");
      //        else if(computer() ==1)
      //          System.out.println(" 당신이 이겼습니다");
      //
      //        else System.out.println("비겼습니다.");
      //      } 




    } // while

  }// main

  private static void printMenu() { // ㅁ메뉴
    System.out.println("--------------");
    System.out.println("[1] 가위");
    System.out.println("[2] 바위");
    System.out.println("[3] 보");
    System.out.println("[0] 종료");
    System.out.println("--------------");

  }

  private static int inputChoice(Scanner scanner) {
    int choice = 0;

    System.out.print("선택 : ");
    choice = scanner.nextInt();

    while(choice < 0 || choice > 3 ) {
      System.out.println("다시 입력해주세요 ");
      System.out.print("선택 : ");
      choice = scanner.nextInt();
    }
    return choice;

  }


  private static  int computer() {

    Random random = new Random();
    int ran ;
    ran = random.nextInt(3); // 0~2까지 랜덤수

    System.out.println("computer : " + ran);
    if (ran == 0) {
      System.out.println(ran +": 가위입니다");
    }else if(ran ==1) {
      System.out.println(ran +": 바위입니다");
    }else 
      System.out.println(ran +": 보입니다");

    return ran;

  }


  public static void fi() {

    while (true) {

      switch (inputChoice(null)) {
        case 1: 
          if (computer() ==0)
            System.out.println(" 비겼습니다. ");
          else if(computer() ==1)
            System.out.println(" 컴퓨터가 이겼습니다");
          else System.out.println("당신이 이겼습니다.");
          // break;


        case 2: 
          if (computer() ==0)
            System.out.println("  ");
          else if(computer() ==1)
            System.out.println(" 비겼습니다");
          else System.out.println("컴퓨터가 이겼습니다.");
          //  break;

        case 3: 
          if (computer() ==0)
            System.out.println(" 컴퓨터가 이겼습니다. ");
          else if(computer() ==1)
            System.out.println(" 당신이 이겼습니다");
          else System.out.println("비겼습니다.");

          //   break;

      }
    }

  }

}
