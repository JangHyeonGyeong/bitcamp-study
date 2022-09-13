package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Board;

public class BoardDaoTest {

  public static void main(String[] args)throws Exception {
    MariaDBBoardDao dao = new MariaDBBoardDao();

    // 리스트 테스트
    List<Board> list = dao.findAll();
    for(Board b: list) {
      System.out.println(b);
    }

    System.out.println("---------------------");
    //인서트 테스트
    //    Board board = new Board();
    //    board.title="꼉이";
    //    board.content="gggggg";
    //    board.memberNo = 2;
    //    dao.insert(board); 

    // 삭제
    //    dao.delete(22);

    //업데이트
    Board board = new Board();
    board.no =12;
    board.title="xxxx";
    board.content = "oklkkk";
    dao.update(board);

    System.out.println("---------------------");

    // 목록 찾기 
    Board board2 = dao.findByNo(12);
    System.out.println(board2);

    list=dao.findAll();
    for(Board b : list) {
      System.out.println(b);
    }
    System.out.println("---------------------");


  }

}
