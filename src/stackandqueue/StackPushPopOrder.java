package stackandqueue;

import java.util.Stack;

/**
 * 栈的压入弹出序列.
 */
public class StackPushPopOrder {
  /**
   * 判断是否为入栈的出栈顺序.
   * @param pushSeq 入栈序列
   * @param popSeq 弹出序列
   * @return 是否
   */
  public static boolean isPopOrder(int[] pushSeq, int[] popSeq) {
    if (pushSeq == null || popSeq == null || pushSeq.length != popSeq.length) {
      return false;
    }
    Stack<Integer> stack = new Stack<>();
    int pushSeqIndex = 0;
    int popSeqIndex = 0;
    while (popSeqIndex < popSeq.length) {
      if (stack.isEmpty() || stack.peek() != popSeq[popSeqIndex]) {
        if (pushSeqIndex < pushSeq.length) {
          stack.push(pushSeq[pushSeqIndex++]);
        } else {
          return false;
        }
      } else {
        stack.pop();
        popSeqIndex++;
      }
    }
    return true;
  }

  /**
   * 主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    int[] push = {1, 2, 3, 4, 5};
    int[] pop1 = {4, 5, 3, 2, 1};
    int[] pop2 = {4, 3, 5, 1, 2};
    System.out.println(isPopOrder(push, pop1));
    System.out.println(isPopOrder(push, pop2));
  }

}
