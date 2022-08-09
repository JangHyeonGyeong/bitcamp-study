package com.eomcs.design_pattern.iterator.Test;

import java.util.HashSet;

public class Test01 {

  public static void main(String[] args) {
    ArrayList<String> list1 = new ArrayList<>();
    list1.add("aaa");
    list1.add("bbb");
    list1.add("ccc");
    list1.add("ddd");

    LinkedList<String> list2 = new LinkedList<>();
    list2.add("aaa2");
    list2.add("bbb2");
    list2.add("ccc2");
    list2.add("ddd2");

    Stack<String> list3 = new Stack<>();
    list3.push("aaa3");
    list3.push("bbb3");
    list3.push("ccc3");
    list3.push("ddd3");

    Queue<String> list4 = new Queue<>();
    list4.offer("aaa4");
    list4.offer("bbb4");
    list4.offer("ccc4");
    list4.offer("ddd4");

    HashSet<String> list5 = new HashSet<String>();
    list5.add("aaa5");
    list5.add("bbb5");
    list5.add("ccc5");
    list5.add("ddd5");

    // 목록에서 값 꺼내기
    // 1) ArrayList 에서 값 꺼내기
    // => ArrayList에게 값을 꺼내는 일을 할 객체를 달라고 요구

    Iterator<String> iterator1 = list1.iterator();
    while(iterator1.hasNext()) {
      System.out.println(iterator1.next());
    }
    System.out.println("-------------------------");

    // 2) LinkedList 에서 값 꺼내기
    Iterator<String> iterator2 = list2.iterator();
    while(iterator2.hasNext())  {
      System.out.println(iterator2.next());
    }
    System.out.println("-------------------------");


    // 3) Stack 에서 값 꺼내기
    Iterator<String> iterator3 = list3.iterator();
    while (iterator3.hasNext()) {
      System.out.println(iterator3.next());
    }
    System.out.println("-------------------------");


    // 4) Queue 에서 값 꺼내기

    Iterator<String> iterator4 = list4.iterator();
    while (iterator4.hasNext()) {
      System.out.println(list4.poll());
    }
    System.out.println("-------------------------");

    // 5) HashSet 에서 값 꺼내기
    // => 해시셋은 입력 된 순서가 아니라 해시값의 오름차순으로 꺼낸다.

    //우리가 만든 iterator가 아니라 java.util.Iterator가 리턴한다
    // 메서드명은 같음 / 사용법같음

    java.util.Iterator<String> iterator5 = list5.iterator();
    while(iterator5.hasNext()) {
      System.out.println(iterator5.next());
    }
    System.out.println("-------------------------");

    // 문제점
    // - 자료 구조에 따라 데이터를 꺼내는 방식이 다르다!
    // - 데이터 조회에 일관성이 없다.
    // 
    // 해결책
    // - 데이터 조회하는 일을 별도의 객체에 맡기자!
    // - 단 데이터 조회 방식을 통일하기 위해 인터페이스로 조회 방식을 규격화 한다.
  }

}









