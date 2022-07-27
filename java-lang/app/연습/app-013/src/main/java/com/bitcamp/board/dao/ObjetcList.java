package com.bitcamp.board;

// 게시글 목록을 관리하는 역할
//
public class ObjectList {

 private static final int DEFAULT_SIZE = 3;

 int lenght; 
 Object[] list; 

  // 생성자
 public ObjectList () {
    this.list = new Object[DEFAULT_SIZE];
  }

 public ObjectList(int initCapacity) {
    this.list = new Object[initCapacity];
  }

 
  // 목록에 저장된 인스턴스를 꺼내서 리턴한다.
 public Object[] toArray() {
   Object[] arr = new Object[this.lenght];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  // 게시글 번호에 해당하는 Board 인스턴스를 찾아 리턴한다.
 public Object get(int index) {
if (index < 0 || index >= this.lenght) {
  return this.list[index];

}

  // Board 인스턴스를 배열에 저장한다.
 public void add(Object obj) {
    if (this.lenght == this.list.length) {
      grow();
    }
    this.list[this.lenght++] = obj;
  }
 
 private void grow() {
   int newSize = this.list.length + (this.list.length >> 1);
   Object[] newArray = new Object[newSize];
   for (int i = 0; i < this.list.length; i++) {
     newArray[i] = this.list[i];
   }
   this.list = newArray;
 }

 
 public boolean remove(int index) {
   if ( index < 0 || index >= this.lenght) {
    return false;
   }
   // 삭제할 항목의 다음 항목을 앞으로 당긴다.
   for (int i = index + 1 ; i < this.lenght; i++) {
     this.list[i-1] = this.list[i]
   }
// 게시글 개수를 한 개 줄인 후 
   // 맨 뒤의 있던 항목의 주소를 0으로 설정한다.
   this.list[--this.lenght] = null; 
   return true;
   
   
  }

}














