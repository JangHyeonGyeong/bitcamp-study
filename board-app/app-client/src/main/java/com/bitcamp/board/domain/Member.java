package com.bitcamp.board.domain;

import java.io.Serializable;

public class Member implements Serializable {
  private static final long serialVersionUID = 1L;

  public int no;
  public String name;
  public String email;
  public String password;
  public long createdDate;


  public static Member create(String csv) { // 인스턴스만들거라서 스테틱
    // 객체로 사용했음!
    String [] values = csv.split(",");

    Member member = new Member();
    member.no = Integer.parseInt(values[0]);
    member.name= values[1];
    member.email = values[2];
    member.password = values[3];
    member.createdDate = Long.parseLong(values[4]);

    return member;
  }

  //인스턴스 필드를 사용할것 그럼 인스턴스필드로 만들어야함
  //=> GRASP 패텬의  information Expert 패턴
  // 정보생성은 그 데이터를 갖고있는 전문가에게 맡긴다 
  public String toCsv() {
    return String.format("%d,%s,%s,%s,%d",
        this.no,
        this.name,
        this.email,
        this.password,
        this.createdDate);
  }


}
