package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.domain.Score02;

public class Test02 {



  public static void main(String[] args) {

    Score02 s1 = new Score02("홍길동", 100, 90, 85);
    printScore(s1);

    Score02 s2 = new Score02("임꺽정", 90, 80, 75);
    printScore(s2);

    Score02 s3 = new Score02("유관순", 80, 70, 65);
    printScore(s3);

  }
  static void printScore(Score02 s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);

  }

}



