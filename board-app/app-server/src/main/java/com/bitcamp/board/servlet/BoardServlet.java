/*
 * board 데이터 처리 
 */
package com.bitcamp.board.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.util.Prompt;

public class BoardServlet implements Servlet {

  // 게시글 목록을 관리할 객체 준비
  private BoardDao boardDao;

  public BoardServlet(String dataName) {

    //    boardDao = new BoardDao(filename);
    //
    //    try {
    //      boardDao.load();
    //    } catch (Exception e) {
    //      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filename);
    //      //  e.printStackTrace();
    //    }
    //  }

    @Override
    public void service(DataInputStream in, DataOutputStream out) {

      try {

        String command = in.readUTF();

        switch (command) {
          case "findAll":
            out.writeUTF("success") ;
            break; 
          case "findByNo":
            out.writeUTF("success");

            break;
          case "insert" :
            out.writeUTF("success");

            break;
          case "update" :
            break;
          case "delete " : 
            break;
          default :
            out.write
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }


  }
}




