package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.bitcamp.board.servlet.BoardServlet;

public class ServerApp {

  public static void main(String[] args) {
    System.out.println("[게시글 데이터 관리 서버]");

    //   while(true) {

    try (
        //네트워크 준비
        //=> 클라이언트 연결을 관리할 객체를 준비한다
        ServerSocket serversocket = new ServerSocket (8888);) {

      System.out.println("서버소켓 준비 완료!");

      try(
          //클라이언트의 연결을 기다림
          //=> 클라이언트와 연결되면 그 클라이언트와 통신할 준비를 한다
          //   즉 socket 객체 리턴
          //=> 클라이언트와 연결이 될때까지 리턴하지 않는다.
          Socket socket=  serversocket.accept();

          // 클라이언트와 데이터를 주고 받는다.
          // 클라이언트가 보낸 데이터를 읽을 때 사용할 도구를 준비한다.

          //=> 데이터를 읽을때  primitive타입 또는 String 타입의 값을
          // 보다 손쉽게 읽을 수 있도록 기존의 입력 도구에 보조도구(decorator)를 붙여 사용한다.
          DataInputStream in = new DataInputStream(socket.getInputStream());

          // =>클라이언트로 데이터를 보낼 사용할 도구를 준비한다
          //=> 데이터를 출력때  primitive타입 또는 String 타입의 값을
          // 보다 손쉽게 출력할 수 있도록 기존의 입력 도구에 보조도구(decorator)를 붙여 사용한다.
          DataOutputStream out = new DataOutputStream(socket.getOutputStream()); ){

        System.out.println("클라이언트와 연결 되었음!");

        //클라이언트 요청을 처리할 객체 준비 
        BoardServlet boardservlet = new BoardServlet("board") ;
        BoardServlet redingservlet = new BoardServlet("reading") ;
        BoardServlet visitservlet = new BoardServlet("visit") ;
        BoardServlet noticeservlet = new BoardServlet("notice") ;
        BoardServlet dailyservlet = new BoardServlet("daily") ;


        while(true) {

          //클라이언트와 서버 사이에 정해진 규칙(protocol)에 따라 데이터를 주고받는다.
          String dataName = in.readUTF() ; // write로 읽은 문자를 하나 읽을때

          if(dataName.equals("exit")) {
            break;
          }

          switch(dataName) {
            case "board" :  boardservlet.service(in, out); break;
            case "visit" :  visitservlet.service(in, out); break;
            case "reading" :  redingservlet.service(in, out); break;
            case "notice" :  noticeservlet.service(in, out); break;
            case "daily" :  dailyservlet.service(in, out); break;
            default: 
              out.writeUTF("fail");
          }
        }//while

        socket.close(); // 클라이언트와 연결된 것을 끊는다

        System.out.println("클라이언트와 연결을 끊엇음");
      } //안쪽  try
    } catch (Exception e) {
      e.printStackTrace();
    } // 밖 try
    System.out.println("종료!");
  }
}
