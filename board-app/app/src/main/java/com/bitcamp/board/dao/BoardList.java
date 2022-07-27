package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Board;
import com.bitcamp.util.ObjectList;

// 게시글 목록을 관리하는 역할
//
public class BoardList extends ObjectList{

  // 자동으로 증가하는 게시글 번호 
  private int boardNO = 0;

  // 게시글을 저장할 때 자동으로 증가한 번호를 게시글 번호로 설정할 수 있도록
  // add 메서드를 재정의 한다 .
  // 컨트롤 스페이스 눌러봐
  @Override
  public void add(Object e) {
    Board board = (Board) e; 
    board.no = nextNo();
    super.add(e);
  }


  //목록에서 인덱스로 해당항목을 찾는 get 메서드를 오버라이딩 하여
  // 게시글을 등록할때 부여한 일련 번호로 찾을 수 있도록
  // get()메서드를 재정의 (오버라이딩) 한다.
  //=> 오버라이딩 메서드의 리턴타입은 원래 타입의 서브 클래스로 변경할수잇다
  @Override
  public Board get(int boardNo) {
    for (int i = 0; i < size(); i++) { 
      //size() 수퍼클래스의 사이즈를 사용할때 선언

      Board board = (Board) super.get(i);
      if (board.no == boardNo) {
        return board;
      }
    }
    return null;
  }

  // 수퍼클래스의 remove는 인덱스로 지정한 항목을 삭제한다.
  // 이것을 게시글 번호로 지정한 항목을 삭제하도록 상속받은
  // 메서드를 재정의한다.

  @Override
  public boolean remove(int boardNo) {
    for (int i = 0; i < size(); i++) {
      Board board = (Board) super.get(i) ;

      if (board.no == boardNo) {
        super.remove(i);
        return super.remove(i);
      }
    }
    return false;
  }



  private int nextNo() {
    return ++boardNO;
  }
}













