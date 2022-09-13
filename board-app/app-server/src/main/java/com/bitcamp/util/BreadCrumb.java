package com.bitcamp.util;

import java.util.Stack;

public class BreadCrumb {

  //breadcrumb 메뉴를 저장할 스택을 준비
  public  Stack<String> menuStack = new Stack<>();

  // 스레드 마다 브래드크럼 객체를 따로 관리해주는 관리자를 준비한다.
  static ThreadLocal<BreadCrumb> localManager = new ThreadLocal<>();

  public static BreadCrumb getBreadCrumbOfCurrentThread() {
    // 스레드 로컬 관리자를 통해 현재 스레드 보관소에 저장되어 있는
    // 브래드크럼 객체를 달라고 요청한다.
    return localManager.get();
  }

  //생성자준비
  public BreadCrumb() {
    //스레드 로컬 관리자에게 현재 스레드 전용 보관소에
    // 브래드크럼 객체를 보관해 달라고 요청 한다.
    localManager.set(this);
  }



  public void put(String menu) {
    menuStack.push(menu);

  }

  public void pickUp() {
    menuStack.pop();
  }
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (String title : menuStack) {
      if (!builder.isEmpty()) {
        builder.append(" > ");
      }
      builder.append(title);
    }
    return builder.toString();
  }
}
