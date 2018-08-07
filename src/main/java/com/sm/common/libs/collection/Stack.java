/**
 * 
 */
package com.sm.common.libs.collection;

import java.io.Serializable;
// import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * 从<code>LinkedList</code>继承的stack，避免<code>java.util.Stack</code> 中synchronized的代价。
 * 
 * @author <a href="chenxu.xc@alibaba-inc.com">xc</a>
 * @version create on 2018年3月2日 下午5:34:54
 */
public class Stack<T> implements Serializable, CloneableObject<Stack<T>> {

  /**
   * 
   */
  private static final long serialVersionUID = 2884212111417967679L;

  private LinkedList<T> list = new LinkedList<>();

  public T peek() {
    if (list.isEmpty()) {
      return null;
      // throw new EmptyStackException();
    }

    return list.getLast();
  }

  public void push(T object) {
    list.addLast(object);
  }

  public T pop() {
    if (list.isEmpty()) {
      return null;
      // throw new EmptyStackException();
    }

    return list.removeLast();
  }

  public T top() {
    if (isEmpty()) {
      return null;
    }

    return list.peekFirst();
  }

  public int size() {
    return list.size();
  }

  public void clear() {
    list.clear();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public String toString() {
    return list.toString();
  }

  @Override
  public Stack<T> clone() throws CloneNotSupportedException {
    Stack<T> stack = new Stack<T>();
    @SuppressWarnings("unchecked")
    LinkedList<T> newList = (LinkedList<T>) list.clone();

    stack.list = newList;
    return stack;
  }

}
