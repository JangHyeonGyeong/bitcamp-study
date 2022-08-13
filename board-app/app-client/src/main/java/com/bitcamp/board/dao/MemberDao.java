package com.bitcamp.board.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.bitcamp.board.domain.Member;
import com.google.gson.Gson;

// 회원 목록을 관리하는 역할
//
public class MemberDao {

  List<Member> list = new LinkedList<Member>();
  String filename;

  public MemberDao(String filename) {
    this.filename = filename;
  }

  public void load() throws Exception {



    try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
      StringBuilder stringBuilder = new StringBuilder();
      String str;
      while((str = in.readLine()) != null) {
        stringBuilder.append(str);
      }
      Member[] arr =  new Gson().fromJson(stringBuilder.toString(), Member[].class) ;//보드클래스타입
      for(int i = 0 ; i <arr.length; i ++ ) {
        list.add(arr[i]); 
      }
    } // try () ==> try 블록을 벗어나기 전에 in.close()가 자동으로 실행된다.
  }

  public void save() throws Exception {
    try (FileWriter out = new FileWriter(filename)) {
      Member[] member =   list.toArray(new Member[0]); // 새로 배열을 만들어줌
      out.write(new Gson().toJson(member));
    }
  } // try () ==> try 블록을 벗어나기 전에 out.close()가 자동으로 실행된다.


  public void insert(Member member) {
    list.add(member);
  }

  public Member findByEmail(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = list.get(i);
      if (member.email.equals(email)) {
        return member;
      }
    }
    return null;
  }

  public boolean delete(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = list.get(i);
      if (member.email.equals(email)) {
        return list.remove(i) != null;
      }
    }
    return false;
  }

  public Member[] findAll() {
    Iterator<Member> iterator = list.iterator();

    Member[] arr = new Member[list.size()];

    int i = 0;
    while (iterator.hasNext()) {
      arr[i++] = iterator.next(); 
    }
    return arr;
  }
}














