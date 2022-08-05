package com.eomcs.quiz.ex01.sol;
// copyright by codefights.com
// 
// 더하기 연산자를 이용하여 사각형의 면적을 구하라!
// 예)
//    rectangleArea(2, 3) = 6
// 
/*
Find the area of a rectangle with given sides.

Example

rectangleArea(2, 3) = 6

[input] integer a
positive integer

[input] integer b
positive integer

[output] integer
 */
//
// [시간 복잡도]
// - O(n) : n은 너비 또는 높이이다. 
//
public class Test21 {

  public static void main(String[] args) {
    System.out.println(rectangleArea(5, 9) == 45);
    System.out.println(rectangleArea(3, 2) == 6);
  }

  static int rectangleArea(int a, int b) {
    int result = 0;
    for (int i = 0; i < a; i++) {
      result += b;
    }
    return result;
  }
}
