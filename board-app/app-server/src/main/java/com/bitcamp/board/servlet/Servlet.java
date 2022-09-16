package com.bitcamp.board.servlet;

import java.io.PrintWriter;

//웹 서버가 요청을 다루는 객체를 호출 할 때 사용할 규칙
public interface Servlet {
  void service(PrintWriter out) throws Exception;

}
