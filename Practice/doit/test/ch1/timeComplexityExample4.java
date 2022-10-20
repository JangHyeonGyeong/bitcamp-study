package com.bitcamp.doit;

// 0~99 사이의 무작윗값을 찾아 출력하는 코드
// 빅-오메가 표기법의 시간 복잡도 1번 
// 빅-세타 표기법의 시간 복잡도는 N/2
// 빅-오 표비걱의 시간 복잡도 N번 

public class timeComplexityExample4 {
  // 연산 횟수가 N^2인 경우
  public  void main(String[] args) {
int N = 100000;
int cont = 0;
for(int i =0; i< N; i++){
  for(int j =0; j< N; j++) {

    System.out.println("연산 횟수 :" + cont++);
  }
}

  }
}


