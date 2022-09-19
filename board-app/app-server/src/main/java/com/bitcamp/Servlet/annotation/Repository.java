package com.bitcamp.Servlet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 애노테이션을 붙일 수 있는 범위를 설정
@Retention(value = RetentionPolicy.RUNTIME) // 애노테이션 값을 추출할 때 지정

//다음 애노테이션은 Dao 객체를 표시할 때 사용한다
public @interface Repository {
  String value(); // 애노태이션의 필수 속성을 설정

}
