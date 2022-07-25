package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.domain.Score01_1;

public class Test01 {

  public static void main(String[] args) {

    Score01_1 s1 = new Score01_1("호길동", 100, 90, 85);
    printScore(s1);

    Score01_1 s2 = new Score01_1("임꺽정", 90, 80, 75);
    printScore(s2);

    Score01_1 s3 = new Score01_1("유관순", 80, 70, 65);
    printScore(s3);
  }

  static void printScore(Score01_1 s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }

}
