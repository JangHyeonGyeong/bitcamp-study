package com.eomcs.quiz.ex01;

// [문제] 
// 음이 아닌 두 정수의 곱셈을 수행하는 프로그램을 작성하라.
// 조건:
// => 2진수로 변환하여 비트 연산자만 이용하여 곱셈을 수행한다.
//
// [훈련 목표]
// - 비트 연산자를 이용한 2진수의 곱셈 수행 방법
//
// [시간 복잡도]
// - ?
//
public class Test08 {
  public static void main(String[] args) {
    System.out.println(multiply(5, 3) == 15);
    System.out.println(multiply(17, 13) == 221);
  }



  static int multiply(int a, int b) {  
    int result = 0;  // 결과를 담을 변수 
    // 이 메서드를 완성하시오!

    while(a > 0) {  // b 값에 대해 곱할 값이 있으면 계산 계속 수행
      int lsb = a & 1; // &는 최하위비트 추출, 곱할값에서 추출
      if (lsb != 0 ) { // 최하위 비트 값이 있으면 b값을 결과에 더한다
        result = result | b ; //
      }
      a = a >>> 1 ;// 두번째 자리수 추출
      // 곱할 값에서 다음 비트를 최하위 비트로 이동시킨다 

      b= b << 1;    // 두번째 자리수 만큼 두배 증가 
      // b 값을 1비트 이동 (즉 , 곱하기 2)하여 
      //다음 비트의 계산을 수행하도록 준비한다
    }

    return result;
  }
}


