package com.bitcamp.util;


// List 규격에 따라 메서드를 구현할 것이라고 선언한다.
// 만약 규격에따라 메서드를 구현하지 않으면 컴파일 안해준다.
//
public class ObjectList implements List {

  private static final int DEFAULT_CAPACITY = 10;

  private int size;
  private Object[] elementData;

  public ObjectList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ObjectList(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  @Override
  public void add(Object e) {
    if (size == elementData.length) {
      grow();
    }

    elementData[size++] = e;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = elementData[i];
    }
    return arr;
  }

  // 개발자가 예외 클래스 이름만 보고도 
  // 어떤 작업을 하다가 예외가 발생했는지 
  // 직관적으로 알 수 있도록 사용자 정의 예외를 던진다!!!
  // => RuntimeException 계열의 예외는 메서드 선언부에 표시할 필요가 없다.
  /**
   * 목록에서 인덱스에 해당 하는 항목을 찾아 리턴한다. 
   * @param index 목록에 저장된 항목의 인덱스
   * @return index에 저장된 항목
   * @throws ListException 인덱스가 무효함 
   */

  @Override  // 인터페이스 규격에 따라 메서드를 정의하는 것도 오버라이딩으로 간주한다.
  public Object get(int index) /*throws ListException*/ {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효함!");
    }
    return elementData[index];
  }

  @Override
  public Object remove(int index) /*throws ListException*/ {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효합니다!");
    }
    // 삭제한 객체를 리턴 할 수 있도록 임시변수에 담아둔다 
    Object deleted = elementData[index];

    for (int i = index + 1; i < size; i++) {
      elementData[i - 1] = elementData[i];
    }
    elementData[--size] = null;
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  private void grow() {
    int newCapacity = elementData.length + (elementData.length >> 1);
    Object[] newArray = new Object[newCapacity];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];
    }
    elementData = newArray;
  }
}








