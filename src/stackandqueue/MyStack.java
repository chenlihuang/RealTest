package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈.
 */
public class MyStack<T> {
  Queue<T> queue1 = new LinkedList<>();
  Queue<T> queue2 = new LinkedList<>();

  public void push(T data) {
    if (queue1.isEmpty()) {
      queue2.add(data);
      return;
    }
    if (queue2.isEmpty()) {
      queue1.add(data);
      return;
    }

  }
  public T pop() {
    if (queue1.isEmpty() && queue2.isEmpty()) {
      return null;
    }
    if (queue1.isEmpty()) {
      while (queue2.size() > 1) {
        queue1.add(queue2.poll());
      }
      return queue2.poll();
    }
    if (queue2.isEmpty()) {
      while (queue1.size() > 1) {
        queue2.add(queue1.poll());
      }
      return queue1.poll();
    }
    return null;
  }

}
