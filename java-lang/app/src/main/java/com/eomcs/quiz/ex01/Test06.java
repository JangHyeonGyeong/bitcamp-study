package com.eomcs.quiz.ex01;

// [문제] 
// 양의 정수 x를 2진수로 표현했을 때 1 값을 갖는 비트 개수를 정수의 무게라고 정의 하자 ,
// 같은 무게를 가지는 양의 정수 중에서 x와 가장 가까운 양의 정수를 구하시오!
// 예) x = 0b0000_1010 (10)
//   x와 같은 무게를 가지는 정수들
//     0b0000_1001 (9)
//     0b0000_1100 (12)
//     0b0001_0010 (18)
//     ...
//   답: 0b0000_1001 (9)
//
// [훈련 목표]
// - 2진수를 다루는 방법
// - 연산자, 흐름제어문을 다루는 방법
//
// [시간 복잡도]
// - ?
//
public class Test06 {

  public static void main(String[] args) {
    System.out.println(closestIntSameBit(0b00001010) == 0b00001001); // 10 ==> 9
    System.out.println(closestIntSameBit(0b11001000) == 0b11000100); // 200 ==> 196
  }

  static int closestIntSameBit(int x) {
    // 이 메서드를 완성하시오!
    //
    //    for (int i = 0 ; i < 31; i++) { // 맨앞을 빼고 30번까지 반복해야 맨앞과 31번이 비교할수있으니까 
    //      int bit1 = ( x >> i ) & 1 ; // 반복 할 때 마 다 한 비트씩 증가하면서 최하위 비트 두개를 추출 한다 
    //      int bit2 = (x >>1 +1) & 1; // 
    //      if (bit1 != bit2) { // 두 비트가 서로 다르다면 맞교환 한다 
    //        int mask = (1 << i) | (1 << (i+1)) ; 
    //        x ^=  mask; // 원래 값을 마스크와 ^로 하여  1로 설정된 비트 값을 뒤집는다
    //
    //        return x;  // 결과가 true 가 나와야하는디 
    //      }
    //    }


    // x의 모든 비트가 0이거나 1이면 오류를 반환한다.
    throw new IllegalArgumentException("모든 비트가 0 또는 1이다.");
  }
}
