package com.bitcamp.doit;

// 0~99 사이의 무작윗값을 찾아 출력하는 코드
// 빅-오메가 표기법의 시간 복잡도 1번 
// 빅-세타 표기법의 시간 복잡도는 N/2
// 빅-오 표비걱의 시간 복잡도 N번 

public class timeComplexityExample1 {
  public static void main(String[] args) {
    //1~100 값 랜덤 선택
    int findNumber = (int)(Math.random() * 100);
    for(int i =0; i<100; i++) {
      if(i==findNumber) {
        System.out.println(i);
        break;
      }
    }
  }
}
