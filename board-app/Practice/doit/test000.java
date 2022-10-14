package com.bitcamp.doit;

// 연습 문제 000 수 정렬 하기 
// n개의 수가 주어졌을 때 이를 오름 차준으로 정렬하는 프로그램
public class test000 {

  public static void main(String[] args) {

    int N = 100000;    
    int cnt = 0;

    for(int i = 0 ; i < N; i++) {
      System.out.println("연산 횟수 : " + cnt++);
    }
  }











  //  public static void main(String[] args) {
  //
  //    try(Scanner in = new Scanner(System.in);){
  //
  //      int N = in.nextInt();
  //      int[] arr = new int [N];
  //
  //      for(int i =0; i<N; i++) {
  //        arr[i] = in.nextInt() ;
  //      }
  //
  //      // 정렬 메소드
  //      Arrays.sort(arr);
  //
  //      for(int val : arr) {
  //        System.out.println(val);
  //      }
  //    }
  //  }


}