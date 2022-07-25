package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.domain.Calculator01;

public class ExamTest01{


  public static void main(String[] args) {
    Calculator01 c1 = new Calculator01 ();
    Calculator01 c2 = new Calculator01() ;


    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    System.out.printf("result = %d\n",c1.result);


    c2.plus(3);
    c2.multiple(2);
    c2.plus(7);
    c2.divide(4);
    c2.minus(5);

    System.out.printf("result = %d\n", c2.result);


  }



}
