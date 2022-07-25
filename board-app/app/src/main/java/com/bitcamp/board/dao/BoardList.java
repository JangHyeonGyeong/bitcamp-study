package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Board;

// 게시글 목록을 관리하는 역할
//
public class BoardList extends ObjectList {

  private int no = 0;


  // 수퍼 클래스의 get() 메서드를 BoardList에 맞게 재정의 한다 .
  // => 파라미터는 인덱스가 아닌 게시글 번호가 되게 한다. 
  // Overriding 이라 부른다 

  @Override
  public Board get(int boardNo) {

    for (int i = 0; i < this.length; i++) {
      /// 오브젝트 배열에 실제 들어가 있는 것은 Board라고 컴파일러에게 알린다
      Board board = (Board) this.list[i] ;

      if (board.no ==  boardNo) {
        return board ;
        // 위에 확인 
      }
    }
    return null;
  }

  // 수퍼 클래스의 add()를 BoardList에 맞게 재정의한다. 
  // 파라미터로 받은 Board 인스턴스의 no 변수 값을 설정한 다음 배열에 추가한다.
  // 같은 이름의 유사기능을 수행하는 메서드를 추가정의한다.
  //=> 이것을 overrding 라고 부른다
  @Override
  public void add(Object obj) {
    Board board = (Board) obj;
    board.no = nextNo();
    // 재정의 하기 전의 수퍼 클래스의 add()를 사용하여 처리
    super.add(board); // 수퍼클래스부터 에드라는 메서드를 찾아서 호출 
    // this. add 는 여기에 있는 add 를 찾는 것 
  }

  // 수퍼클래스의 remove()를 BoardList 클래스의 역할에 맞춰 재정의한다
  @Override
  public boolean remove(int boardNo) {
    int boardIndex = -1;
    for (int i = 0; i < this.length; i++) {
      Board board = (Board) this.list[i];
      if (board.no == boardNo) {
        boardIndex = i;
        break;
      }
    }
    return super.remove(boardIndex); 
    // 재정의 하기 전에 수퍼클래스의 메서드를 호출한다 
  }

  private int nextNo() {
    return ++no;
  }


}














