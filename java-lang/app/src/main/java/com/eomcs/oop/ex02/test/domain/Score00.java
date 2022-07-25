package com.eomcs.oop.ex02.test.domain;

public class Score00 {

  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver; 

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }

}

