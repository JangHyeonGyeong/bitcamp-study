package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.domain.Calculator00;

public class ExamTest00 {

  public static void main(String[] args) {

    Calculator00 c1 = new Calculator00();
    Calculator00 c2 = new Calculator00();

    c1.plus(2);
    c2.plus(3);

    c1.plus(3);
    c2.multiple(2);

    c1.minus(1);
    c2.plus(7);

    c1.multiple(7);
    c2.divide(4);

    c1.divide(3);
    c2.minus(5);


    System.out.printf("c1.result = %d\n", c1.getResult());
    System.out.printf("c2.result = %d\n", c2.getResult());



  }

}
