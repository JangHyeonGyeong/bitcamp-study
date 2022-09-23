package com.bitcamp.board.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;


//웹 애플리케이션이 시작되었을 때 공유할 자원을 준비시키거나 해제하는 일을 한다.
@WebListener
public class ContextLoaderListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유 자원을 준비 중!!");
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb","study","1111");

      // 생성자에서 getServletContext()를 호출하면 오류 발생!
      // 왜? 
      //  - ServletContext는 ServletConfig 객체를 통해 꺼낼 수 가 있는데,
      //  - ServletConfig는 아직 주입되지 않은 상태이다.
      // ServletConfig 객체가 언제 주입되는가?
      //  - 생성자 다음에 호출되는 init()가 호출될 때 ServletConfig 객체가 주입된다.
      // 
      ServletContext ctx = sce.getServletContext();
      ctx.setAttribute("boardDao", new MariaDBBoardDao(con));
      ctx.setAttribute("memberDao", new MariaDBMemberDao(con));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
