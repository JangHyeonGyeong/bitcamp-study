package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.domain.Score03;

public class Test03 {


  public static void main(String[] args) {
    Score03 s1 = new Score03("홍길동", 100, 90, 80 );
    printScore(s1);

    Score03 s2 = new Score03("임꺽정", 90, 80, 75);
    printScore(s2);


    Score03 s3 = new Score03("유관순" , 80, 70, 65);
    printScore(s3);

  }

  static void printScore(Score03 s) {

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);

  }
}
