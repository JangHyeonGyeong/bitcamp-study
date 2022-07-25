package com.eomcs.oop.ex02;

//0) 낱개 변수 사용
//1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
//2) 리팩토링: 메서드 추출(extract method), static nested class
//3) 리팩토링: 메서드 추출(extract method) = 한 개의 메서드는 한 개의 기능을 수행해야 한다.
//4) GRASP(General Responsibility Assignment Software Patterns) 패턴 
//     => Information Expert: 데이터를 다룰 때는 그 데이터를 갖고 있는 객체에게 묻는다.
//   리팩토링: 메서드 이동(Move Method)
//     => 메서드를 관련된 클래스로 이동시킨다. => 코드의 이해가 쉽다.
//5) 인스턴스 메서드: 인스턴스 주소를 받는 더 쉬운 문법
//6) 패키지 멤버 클래스: 
//     => 여러 곳에서 사용할 클래스라면 다른 클래스에 안에 두지 말고 
//        패키지의 멤버 클래스로 둬라!
//7) 클래스를 역할에 따라 패키지로 분류
//     => 클래스가 많을 경우 유지보수하기 쉽도록 적절한 패키지로 분산 배치한다.
//     => 데이터 타입의 역할을 하는 클래스의 경우 
//        보통 domain, vo(value object), dto(data transfer object) 라는 이름을 가진 
//        패키지에 분류한다.
//     => 패키지가 다르면 modifier 옵션에 따라 접근 범위가 달라진다. 
//   멤버의 접근 범위 설정
//     => public: 모두 공개
//     => protected: 서브 클래스와 같은 패키지의 멤버는 접근 가능
//     => (default): 같은 패키지의 멤버는 접근 가능
//     => private: 접근 불가! 그 멤버가 속한 클래스의 내부에서만 접근 가능

import com.eomcs.oop.ex02.domain.Score;

public class Exam0170 {

  public static void main(String[] args) {

    Score s1 = new Score();

    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    s1.compute();
    printScore(s1);

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;
    s2.compute();
    printScore(s2);

    Score s3 = new Score();
    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;
    s3.compute();
    printScore(s3);
  }

  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", 
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }


}



