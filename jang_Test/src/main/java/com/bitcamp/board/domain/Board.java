package main.java.com.bitcamp.board.domain;

import java.io.Serializable;

public class Board implements  Serializable{


  private static final long seriaVersionUID =1L; 

  // 인스턴스를 생성할 때 준비되는 메모리를 선언
  public int no;
  public String title;
  public String content;
  public String writer;
  public String password;
  public int viewCount;
  public long createdDate;
}
