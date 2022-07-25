package com.eomcs.quiz.ex01;

// [문제] 
// 파라미터로 주어진 정수 값을 2진수로 표현했을 때 1로 설정된 비트의 개수를 구하라!
// [훈련 목표]
// - 관계 연산자 및 비트 연산자, 비트 이동 연산자 활용
// - 반복문 활용
// - 메서드 파라미터 및 리턴 값 다루기

//[시간복잡도]
//O(n) 시간 복잡도 
public class Test01 {

  public static void main(String[] args) {
    int c = countBits(0b01100011);
    System.out.println(c == 4); // true

    c = countBits(0b01010111_01100011);
    System.out.println(c == 9); // true
  }

  static int countBits(int value) {

    // 이 메서드를 완성하시오!
    return r;
  }

}


// r += (value & 1) ;  // 1 

// value >>>= 1 ; 
// r += (value & 1) ; //2 

//value >>>= 1 ;
//r += (value & 1) ; //2
//value >>>= 1 ;
// ... 계속 진행 으로 반복문 진행 

//
//while(value != 0 ) {
//  r =+ (value & 1);
//  value >>>= 1;
////}


