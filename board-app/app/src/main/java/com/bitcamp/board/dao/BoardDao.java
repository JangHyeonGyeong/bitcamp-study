package com.bitcamp.board.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.bitcamp.board.domain.Board;
import com.bitcamp.util.DataInputStream;
import com.bitcamp.util.DataOutputStream;

// 게시글 목록을 관리하는 역할
//
public class BoardDao {

  List<Board> list = new LinkedList<>();
  private int boardNo = 0;
  String filename;

  public BoardDao(String filename) {
    this.filename = filename;
  }

  public void load() throws Exception {
    try (
        DataInputStream in = new DataInputStream(new FileInputStream(filename)) ){
      Board board = new Board(); // 데이이터를 읽을 객체를 공유할수없음 여러개를 만들어야함!
      // 코드 다시보기
      int size = in.readInt();
      board.title = in.readUTF() ;
      board.content =in.readUTF();
      board.writer = in.readUTF();
      board.password = in.readUTF();
      board.viewCount = in.readInt();
      board.createdDate =  in.readLong();
      list.add(board);
      boardNo = board.no; // 마지막에 저장된 게시글 저장 
    }

  }
  public void save() throws Exception {
    try (
        DataOutputStream out= new DataOutputStream(new FileOutputStream(filename))) {
      // 여기 코드 다시작성 
      out.writeInt(list.size());

      for(Board board : list) {
        out.writeInt(board.no);
        out.writeUTF(board.title);
        out.writeUTF(board.content);
        out.writeUTF(board.writer);
        out.writeByte(board.password);
        out.
      }



      // int ==> byte[]
      //    System.out.printf("%08x\n", board.viewCount);
      out.write(board.viewCount >> 24);
      out.write(board.viewCount >> 16);
      out.write(board.viewCount >> 8);
      out.write(board.viewCount);

      // long ==> byte[]
      //  System.out.printf("%016x\n", board.createdDate);
      out.write((int)(board.createdDate >> 56));
      out.write((int)(board.createdDate >> 48));
      out.write((int)(board.createdDate >> 40));
      out.write((int)(board.createdDate >> 32));
      out.write((int)(board.createdDate >> 24));
      out.write((int)(board.createdDate >> 16));
      out.write((int)(board.createdDate >> 8));
      out.write((int)(board.createdDate));

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

      // 목록에서 값을 꺼내는 일을 할 객체를 준비한다.
      Iterator<Board> iterator = list.iterator();

      // 역순으로 정렬하여 리턴한다.
      Board[] arr = new Board[list.size()];

      int index = list.size() - 1;
      while (iterator.hasNext()) {
        arr[index--] = iterator.next();
      }
      return arr;
    }

    private int nextNo() {
      return ++boardNo;
    }
  }














