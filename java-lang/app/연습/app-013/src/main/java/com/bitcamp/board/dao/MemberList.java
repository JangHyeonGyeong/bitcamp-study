package com.bitcamp.board;

// 회원 목록을 관리하는 역할
//
public class MemberList extends ObjectList{
  
  private int no = 0;
  
  private int nextNo() {
    return ++no;
  }
  


public void add(Object obj) {
  Member member = (member) obj;
  member.no = nextNo();
  super.add(obj);
  
 }



 public Member[] toArray() {
    Member[] arr = new Member[this.memberCount];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.members[i];
    }
    return arr;
  }

 public Member get(int memberNo) {
    for (int i = 0; i < this.lenght; i++) {
      if (this.members[i].no == memberNo) {
        return this.members[i];
      }
    }
    return null;
  }



 public boolean remove(int memberNo) {
    int memberIndex = -1;
    for (int i = 0; i < this.memberCount; i++) {
      if (this.members[i].no == memberNo) {
        memberIndex = i;
        break;
      }
    }

    if (memberIndex == -1) {
      return false;
    }

    for (int i = memberIndex + 1; i < this.memberCount; i++) {
      this.members[i - 1] = this.members[i];
    }

    this.members[--this.memberCount] = null;

    return true;
  }

 private void grow() {
    int newSize = this.members.length + (this.members.length >> 1);
    Member[] newArray = new Member[newSize];
    for (int i = 0; i < this.members.length; i++) {
      newArray[i] = this.members[i];
    }
    this.members = newArray;
  }


}














