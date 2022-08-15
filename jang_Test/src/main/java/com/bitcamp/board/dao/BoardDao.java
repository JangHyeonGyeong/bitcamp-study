package main.java.com.bitcamp.board.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    FileInputStream in = new FileInputStream(filename);
    // 게시글 개수 먼저 
    int size = (in.read() << 24 ) + (in.read() <<16) +(in.read()<<8) +in.read() ;

    for(int i = 0 ; i <size; i++) {

      //파일에서 읽은 게시글 데이터를 저장할 객체    
      Board board = new Board();

      // 게시글 번호 읽기
      // 저장된 순서대로 데이터를 읽음
      int value = 0;
      value += in.read() << 24 ;
      value += in.read() << 16 ;
      value += in.read() << 8 ;
      value += in.read()  ;
      board.no = value;


      // title
      int len = 0;

      // 게시글 제목의 바이트 수 읽음
      len = (in.read() << 24 ) + (in.read() <<16) +(in.read()<<8) +in.read() ;

      // 저장할 배열 만들기 
      byte[] bytes = new byte[len];

      //제목 배열로 읽음
      in.read(bytes);
      // 바이트 배열로 스트링 인스턴스 생성 
      board.title = new String(bytes, "UTF-8");


      // content
      len = (in.read() << 24 ) + (in.read() <<16) +(in.read()<<8) +in.read() ;
      bytes = new byte[len];
      in.read(bytes);
      board.content = new String(bytes, "UTF-8");

      // writer
      len = (in.read() << 24 ) + (in.read() <<16) +(in.read()<<8) +in.read() ;
      bytes = new byte[len];
      in.read(bytes);
      board.writer = new String(bytes, "UTF-8");

      // passward
      len = (in.read() << 24 ) + (in.read() <<16) +(in.read()<<8) +in.read() ;
      bytes = new byte[len];
      in.read(bytes);
      board.password = new String(bytes, "UTF-8");

      // vilewCoutn
      board.viewCount = (in.read() << 24 ) + (in.read() <<16) +(in.read()<<8) +in.read() ;

      // createdDate
      board.createdDate = 
          (((long)in.read()) << 56) +
          (((long)in.read()) << 48) +
          (((long)in.read()) << 40) +
          (((long)in.read()) << 32) +
          (((long)in.read()) << 24) +
          (((long)in.read()) << 16) +
          (((long)in.read()) << 8) +
          (in.read());


      // 게시글 데이터가 저장된 Board 객체를 목록에 추가
      list.add(board);

      // 파일에서 게시글을 읽어 올 때는 항상 게시글 번호를 boardNo에 저장한다.
      // 그래야만 새 게시글을 저장할 때 마지막 게시글 번호 보다 큰 값으로 저장할 수 있다.
      boardNo = board.no;
    }
    in.close();

  }



  public void save() throws Exception {
    FileOutputStream out = new FileOutputStream(filename);
    // 항상 출력 할때는 맨 끝 1바이트만 출력.
    // 게시글 개수 4바이트 int 값으로 출력
    // 모든 바이트 입출력할때 : 
    out.write(list.size() >> 24);
    out.write(list.size() >> 16);
    out.write(list.size() >> 8);
    out.write(list.size() );


    for(Board board: list) {

      //int => byte
      out.write(board.no >> 24);
      out.write(board.no >> 16);
      out.write(board.no >> 8);
      out.write(board.no );

      //title 
      // String utf-16 => 8
      // 출력할 바이트 배열의 개수 먼저 출력
      byte[] bytes = board.title.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      //content
      // String utf-16 => 8
      // 출력할 바이트 배열의 개수 먼저 출력
      bytes = board.content.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      //writer
      // String utf-16 => 8
      // 출력할 바이트 배열의 개수 먼저 출력
      bytes = board.writer.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      //passward
      // String utf-16 => 8
      // 출력할 바이트 배열의 개수 먼저 출력
      bytes = board.password.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);


      //viewCount
      //int => byte

      out.write(board.viewCount >> 24);
      out.write(board.viewCount >> 16);
      out.write(board.viewCount >> 8);
      out.write(board.viewCount );

      //createdDate
      // long => bute[]

      out.write((int) (board.createdDate >> 56 ));
      out.write((int) (board.createdDate >> 48 ));
      out.write((int) (board.createdDate >> 40 ));
      out.write((int) (board.createdDate >> 32 ));
      out.write((int) (board.createdDate >> 24 ));
      out.write((int) (board.createdDate >> 16 ));
      out.write((int) (board.createdDate >> 8 ));
      out.write((int) (board.createdDate  ));

    }
    out.close();
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














