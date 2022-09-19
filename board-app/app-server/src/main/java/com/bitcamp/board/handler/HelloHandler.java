package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.Map;
import com.bitcamp.Servlet.Servlet;
import com.bitcamp.Servlet.annotation.WebServlet;

@WebServlet(value = "/hello")
public class HelloHandler  implements Servlet{

  @Override
  public void service(Map<String,String> paramMap, PrintWriter out) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>힣ㅎ !2</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}
