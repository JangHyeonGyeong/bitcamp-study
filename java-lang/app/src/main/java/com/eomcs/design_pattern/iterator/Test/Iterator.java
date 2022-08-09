package com.eomcs.design_pattern.iterator.Test;

public interface Iterator<E> {

  //목록에서 조회할 데이터가 있는지 검사할때 호출
  boolean hasNext();

  // 목록에서 데이터를 한 개 꺼낼 때 호출 
  E next();

}
