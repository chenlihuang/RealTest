package stackandqueue;

import java.util.Stack;

/**
 * 用两个栈实现队列.
 */
public class MyQueue<T> {
  private Stack<T> stack1 = new Stack<>();
  private Stack<T> stack2 = new Stack<>();

  public void offer(T data) {
    stack1.push(data);
  }

  public T poll() {
    if (!stack2.isEmpty()) {
      return stack2.pop();
    } else if (!stack1.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
      return stack2.pop();
    } else {
      return null;
    }
  }
}
