package main.java.com.bitcamp.board.dao;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import main.java.com.bitcamp.board.domain.Board;

// 게시글 목록을 관리하는 역할
//
public class BoardDao {

  List<Board> list = new LinkedList<>();
  private int boardNo = 0;
  String filename;

  public BoardDao (String filename) {
    this.filename = filename;
  }


  //read는 1바이트를 읽어 int값으로 만든 후 리턴
  public void load() throws Exception {
    try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
      String str;
      while ((str = in.readLine()) != null) {

        String[] values = str.split(",");

        Board board = new Board();
        board.no = Integer.parseInt(values[0]);
        board.title = values[1];
        board.content = values[2];
        board.writer = values[3];
        board.password = values[4];
        board.viewCount = Integer.parseInt(values[5]);
        board.createdDate = Long.parseLong(values[6]);

        list.add(board);
        boardNo = board.no;
      }
    }

  }



  public void save() throws Exception {
    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){ 
      out.writeInt(list.size());

      for(Board board: list) {
        out.writeObject(board);
      }

    }
  }





  public void insert(Board board) {
    board.no = nextNo();
    list.add(board);
  }

  public Board findByNo(int boardNo) {
    for (int i = 0; i < list.size(); i++) {
      Board board = list.get(i);
      if (board.no == boardNo) {
        return board;
      }
    }
    return null;
  }

  public boolean delete(int boardNo) {
    for (int i = 0; i < list.size(); i++) {
      Board board = list.get(i);
      if (board.no == boardNo) {
        return list.remove(i) != null;
      }
    }
    return false;
  }

  public Board[] findAll() {

    // 목록에서 값을 꺼내는 일을 할 객체 준비
    Iterator<Board> iterator = list.iterator();
    Board[] arr = new Board[list.size()];

    int index = list.size() -1;
    while (iterator.hasNext()) {
      arr[index--] = iterator.next();
    }

    return arr;
  }

  private int nextNo() {
    return ++boardNo;
  }
}














