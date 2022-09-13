package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Member;

public class MemberDaoTest {
  public static void main(String[] args)throws Exception {
    MariaDBMemberDao dao = new MariaDBMemberDao();

    // 리스트 테스트
    List<Member> list = dao.findAll();
    for(Member member: list) {
      System.out.println(member);
    }

    System.out.println("---------------------");
    //인서트 테스트
    //    Member member = new Member();
    //    member.name="꼉이";
    //    member.email="test@naver.com";
    //    member.password = "1111";
    //    dao.insert(member); 

    // 삭제
    // dao.delete(8);

    //업데이트
    Member member = new Member();
    member.no =1;
    member.name="xxxx";
    member.email = "xxx@test.com";
    member.password = "2222";
    dao.update(member);

    // 목록 찾기 
    Member member2 = dao.findByNo(1);
    System.out.println(member2);

    //    list=dao.findAll();
    //    for(Member m : list) {
    //      System.out.println(m);
    //    }
    //    System.out.println("---------------------");


  }

}
