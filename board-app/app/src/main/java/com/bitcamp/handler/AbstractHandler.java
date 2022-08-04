package com.bitcamp.handler;

import com.bitcamp.board.App;
import com.bitcamp.util.Prompt;

public abstract class AbstractHandler implements Handler {

  //핸들러가 사용할 메뉴 목록 담을 배열 준비
  // 생성자를 통해 초기화 시킬예정

  private  String[] menus;

  // 메뉴목록 초기화 강제시키기 위해 
  // 기본생성자 대신 메뉴 목록 받는 배열 생성자 준비
  public AbstractHandler(String[] menus) {
    this.menus = menus;
  }

  // ****
  // 서브클래스가 반드시 만들수 있도록 강제할 추상메서드 선언
  public abstract void service(int menuNo);



  protected void printMenus() {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("  %d: %s\n", i + 1, menus[i]);
    }
  }

  protected static void printHeadline() {
    System.out.println("=========================================");
  }

  protected static void printBlankLine() {
    System.out.println(); // 메뉴를 처리한 후 빈 줄 출력
  }

  protected static void printTitle() {
    System.out.printf("%s:\n", App.breadcrumbMenu);
  }

  @Override
  public void execute() {

    while (true) {
      printTitle();
      printMenus();
      printBlankLine();


      try {
        int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 이전) ");

        if (menuNo < 0 || menuNo > menus.length) {
          System.out.println("메뉴 번호가 옳지 않습니다!");
          continue; // while 문의 조건 검사로 보낸다.

        } else if (menuNo == 0) {
          return; // 메인 메뉴로 돌아간다.
        }

        // 메뉴에 진입할 때 breadcrumb 메뉴바에 그 메뉴를 등록한다.
        App.breadcrumbMenu.push(menus[menuNo - 1]);

        printHeadline();

        // 서브 메뉴의 제목을 출력한다.
        printTitle();

        service(menuNo);

        printBlankLine();

        App.breadcrumbMenu.pop();

      } catch (Exception ex) {
        System.out.printf("예외 발생: %s\n", ex.getMessage());
      }
    } // 게시판 while
  }




}
