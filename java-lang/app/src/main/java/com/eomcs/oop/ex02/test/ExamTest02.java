package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.domain.Calculator02;

public class ExamTest02{


  public static void main(String[] args) {

    Calculator02 s1 = new Calculator02() ;
    Calculator02 s2 = new Calculator02() ;


    s1.plus(2);
    s1.plus(3);
    s1.minus(1);
    s1.multiple(7);
    s1.divide( 3);

    System.out.printf("result = %d\n", s1.result);

    s2.plus( 3);
    s2.multiple(2);
    s2.plus(7);
    s2.divide(4);
    s2.minus( 5);

    System.out.printf("result = %d\n", s2.result);


  }

}
