package stackandqueue;

import java.util.Stack;

/**
 * 包含min函数的栈.
 * @param <T> 数据实现Comparable接口，使得数据可比较
 */
public class StackWithMin<T extends Comparable> {
  private Stack<T> stackData = new Stack<>();
  private Stack<T> stackMin = new Stack<>();

  /**
   * 数据入栈.
   * @param data 数据
   */
  public void push(T data) {
    stackData.push(data);
    if (stackMin.isEmpty()) {
      stackMin.push(data);
    } else {
      T temp = stackMin.peek();
      if (temp.compareTo(data) < 0) {
        stackMin.push(temp);
      } else {
        stackMin.push(data);
      }
    }
  }


  /**
   * 数据出栈.
   * @return 弹出的数据
   */
  public T pop() {
    if (stackMin.isEmpty()) {
      return null;
    }
    stackMin.pop();
    return stackData.pop();
  }


  /**
   * 数据最小值查看.
   * @return 最小值
   */
  public T min() {
    if (stackMin.isEmpty()) {
      return null;
    }
    return stackMin.peek();
  }
}
