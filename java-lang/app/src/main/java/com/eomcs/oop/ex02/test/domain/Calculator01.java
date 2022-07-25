package com.eomcs.oop.ex02.test.domain;

public class Calculator01 {
  public int result = 0;

  public void plus(int value) {
    this.result += value ;
  }

  public void minus(int value) {
    this.result -= value ; 
  }

  public  void multiple(int value) {
    this.result *= value ;
  }

  public void divide(int value) {
    this.result /= value;
  }

  public static int abs(int a) {  // abs 인자값에 대한 절대값 반환
    return a >= 0 ? a : a * -1;
  }
}
