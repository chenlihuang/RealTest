package linkedlist;

import java.util.Stack;

import structure.ListNode;

/**
 * 从尾到头打印链表.
 */
public class PrintListInReversedOrder {

  /**
   * 从头便利链表，压入栈，弹出.
   * @param node 链表表头
   */
  private static void printReversinglyIteratively(ListNode<Integer> node) {
    Stack<Integer> stack = new Stack<>();
    for (ListNode<Integer> temp = node; temp != null; temp = temp.next) {
      stack.add(temp.val);
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  /**
   * 递归，从表尾输出.
   * @param node 链表表头
   */
  private static void printReversinglyRecursively(ListNode<Integer> node) {
    if (node == null) {
      return;
    } else {
      printReversinglyRecursively(node.next);
      System.out.println(node.val);
    }
  }

  /**
   * 主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    ListNode<Integer> head = new ListNode<Integer>(1);
    head.next = new ListNode<Integer>(2);
    head.next.next = new ListNode<Integer>(3);
    printReversinglyRecursively(head);
    System.out.println();
    printReversinglyIteratively(head);
  }

}
