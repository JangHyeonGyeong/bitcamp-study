package com.eomcs.quiz.ex01.sol;
// copyright by codefights.com
// 
// 숫자와 달의 영어 이름을 연결하라!
// 단 숫자는 0 이상이다. 
//
// 1: "Jan"
// 2: "Feb"
// 3: "Mar"
// 4: "Apr"
// 5: "May"
// 6: "Jun"
// 7: "Jul"
// 8: "Aug"
// 9: "Sep"
// 10: "Oct"
// 11: "Nov"
// 12: "Dec"
// 예) 
//    getMonthName(1) = "Jan"
//    getMonthName(0) = "invalid month"
// 
//
/*
Map the given integer to a month.

Example

getMonthName(1) = "Jan"
getMonthName(0) = "invalid month"

[input] integer mo
a non-negative integer

[output] string

a 3 letter abbreviation of month number mo or "invalid month" 
if the month doesn't exist
 */
//
// [시간 복잡도]
// - O(1) : 시간 복잡도는 일정하다. 
//
public class Test22 {

  public static void main(String[] args) {
    System.out.println(getMonthName(1) == "Jan");
    System.out.println(getMonthName(12) == "Dec");
    System.out.println(getMonthName(0) == "invalid month"); 
  }

  static String getMonthName(int mo) {
    mo -= 1;
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
        "Aug", "Sep", "Oct", "Nov", "Dec"};
    if (mo >= 0 && mo < months.length) {
      return months[mo];
    } else {
      return "invalid month";
    }
  }
}
