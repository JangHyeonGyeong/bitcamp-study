package com.bitcamp.board;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.ErrorHandler;
import com.bitcamp.board.handler.WelcomeHandler;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// 1) 기본 웹 서버 만들기
// 2) 한글 콘텐트 응답하기
//
public class MiniWebServer {

  public static void main(String[] args) throws Exception {
    // DAo가 사용할 커넥션 객체 준비
    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");

    //DAo 객체 준비한다
    MariaDBBoardDao boardDao = new MariaDBBoardDao(con);
    MariaDBMemberDao memberDao = new MariaDBMemberDao(con);

    WelcomeHandler welcomeHandler = new WelcomeHandler();
    ErrorHandler errorHandler = new ErrorHandler();
    BoardHandler boardHandler = new BoardHandler(boardDao);


    class MyHttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        System.out.println("클라이언트가 요청함!");

        URI requestUri = exchange.getRequestURI();
        String path = requestUri.getPath();
        String query = requestUri.getQuery();
        byte[] bytes = null;


        try (StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter)) {

          Map<String, String> paramMap= new HashMap<>();
          if(query != null && query.length() > 0 ) { // 예: no =1&title=aaaa&content=bbb
            String[] entries = query.split("&"); // &로 잘라라
            for(String entry : entries) {// 예 no=1
              String[] kv = entry.split("=");
              paramMap.put(kv[0] ,kv[1]) ;
            }
          }
          System.out.println(paramMap);

          if (path.equals("/")) {
            welcomeHandler.service(paramMap, printWriter);

          } else if (path.equals("/board/list")) {
            boardHandler.list(paramMap, printWriter);

          } else if (path.equals("/board/detail")) {
            boardHandler.detail(paramMap, printWriter);

          } else if (path.equals("/board/update")) {
            boardHandler.update(paramMap, printWriter);

          } else if (path.equals("/board/delete")) {
            boardHandler.delete(paramMap, printWriter);

          } else {
            errorHandler.error(paramMap, printWriter);
          }

          // welcomeHandler.service(printWriter);
          bytes = stringWriter.toString().getBytes("UTF-8");

        } catch (Exception e) {
          bytes  = "요청 처리 중 오류 발생".getBytes("UTF-8");
          e.printStackTrace(); // 서버 콘솔창에 오류에 대한 자세한 내용 출력
        }

        // 보내는 콘텐트의 MIME 타입이 무엇인지 응답 헤더에 추가한다.
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        exchange.sendResponseHeaders(200, bytes.length);

        OutputStream out = exchange.getResponseBody();
        out.write(bytes);
        out.close();
      }
    }

    HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
    server.createContext("/", new MyHttpHandler()); 
    server.setExecutor(null); 
    server.start();

    System.out.println("서버 시작!");
  }

}
