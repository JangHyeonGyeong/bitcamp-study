package com.bitcamp.board.domain;

public class Member {
  public int no;
  public String name;
  public String email;
  public String password;
  public long createdDate;
  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
        + ", createdDate=" +  new java.sql.Date(createdDate) + "]";
  }


}
