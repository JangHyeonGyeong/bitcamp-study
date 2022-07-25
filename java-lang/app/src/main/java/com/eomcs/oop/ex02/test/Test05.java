package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.domain.Score05;

//0) 낱개 변수 사용
//
public class Test05 {


  public static void main(String[] args) {
    Score05 s1 = new Score05("홍길동", 100, 90, 85);
    printScore(s1);

    Score05 s2 = new Score05("임꺽정", 90, 80, 75);
    printScore(s2);

    Score05 s3 = new Score05("유관순", 80, 70, 76);
    printScore(s3);
  }

  static void printScore(Score05 s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }

}
